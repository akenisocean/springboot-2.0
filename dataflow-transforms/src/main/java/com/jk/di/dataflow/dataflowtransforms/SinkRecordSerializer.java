package com.jk.di.dataflow.dataflowtransforms;

//import com.di.clients.dbz.Point;
//import com.di.clients.dbz.data.VariableScaleDecimal;
//import com.di.clients.dbz.time.Year;
//import com.di.clients.dbz.time.*;
import org.apache.kafka.connect.data.Decimal;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.data.Schema.Type;
import org.apache.kafka.connect.data.Struct;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.annotation.Nonnull;
import java.nio.ByteBuffer;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Serialize Sink Record to raw string.
 *
 * <p>Original design is
 * https://github.com/lepfhty/kafka-connect-redshift/blob/master/src/main/java/io/tenjin/kafka/connect/redshift/DefaultCopySerializer.java
 */
public class SinkRecordSerializer {
  private static final DateTimeFormatter DATE_FORMATTER;
  private static final DateTimeFormatter TIME_FORMATTER;
  public static final DateTimeFormatter DATETIME_FORMATTER;
  private static final DateTimeFormatter DATETIME_MICROS_FORMATTER;
  private static final DateTimeFormatter DATETIME_NANO_FORMATTER;
  public static final DateTimeFormatter ZONED_DATETIME_FORMATTER;
  private static final int YEAR_BASE = 1900;
  private static final long ONE_DAY_MILLIS = Duration.of(1, ChronoUnit.DAYS).toMillis();

  static {
    // By default the timezone is Chinese standard timezone
    DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    DATETIME_MICROS_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
    DATETIME_NANO_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
    TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    ZONED_DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS xxx");
    DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  }

  public interface ObjectConverter {
    Object getConvertedObject(@Nonnull Object originValue) throws JSONException;
  }

  public static class KeyValueConverter {
    final String keyName;
    final ObjectConverter objectConverter;

    public KeyValueConverter(String keyName, ObjectConverter objectConverter) {
      this.keyName = keyName;
      this.objectConverter = objectConverter;
    }
  }

  static Map<Field, KeyValueConverter> getObjectConverter(Struct struct) {
    Map<Field, KeyValueConverter> result = new HashMap<>();
    if ((struct == null) || (struct.schema() == null)) {
      return result;
    }
    for (Field field : struct.schema().fields()) {
      String name = IllegalSchemaNameUtils.getSchemaName(field.schema().name());
      ObjectConverter converter;
      if (field.schema().type() == Type.BYTES) {
        if (Decimal.LOGICAL_NAME.equals(name)) {
          converter = originValue -> originValue;
        } else {
          converter =
              originValue ->
                  originValue instanceof ByteBuffer
                      ? ((ByteBuffer) originValue).array()
                      : originValue;
        }
//      } else if (Date.SCHEMA_NAME.equals(name)) {
//        converter =
//            originValue -> getFormattedTime(originValue.toString(), TimeStringType.EPOCH_DAY);
//      } else if (Timestamp.SCHEMA_NAME.equals(name)) {
//        converter =
//            originValue -> getFormattedTime(originValue.toString(), TimeStringType.EPOCH_MILLI);
//      } else if (MicroTimestamp.SCHEMA_NAME.equals(name)) {
//        converter =
//            originValue -> getFormattedTime(originValue.toString(), TimeStringType.EPOCH_MICRO);
//      } else if (NanoTimestamp.SCHEMA_NAME.equals(name)) {
//        converter =
//            originValue -> getFormattedTime(originValue.toString(), TimeStringType.EPOCH_NANO);
//      } else if (ZonedTimestamp.SCHEMA_NAME.equals(name)) {
//        converter =
//            originValue -> getFormattedTime(originValue.toString(), TimeStringType.ZONED_TIMESTAMP);
//      } else if (Year.SCHEMA_NAME.equals(name)) {
//        converter = originValue -> getFormattedTime(originValue.toString(), TimeStringType.YEAR);
//      } else if (Time.SCHEMA_NAME.equals(name)) {
//        converter = originValue -> getFormattedTime(originValue.toString(), TimeStringType.TIME);
//      } else if (MicroTime.SCHEMA_NAME.equals(name)) {
//        converter =
//            originValue -> getFormattedTime(originValue.toString(), TimeStringType.MICROTIME);
//      } else if (NanoTime.SCHEMA_NAME.equals(name)) {
//        converter =
//            originValue -> getFormattedTime(originValue.toString(), TimeStringType.NANOTIME);
//      } else if (VariableScaleDecimal.LOGICAL_NAME.equals(name)) {
//        converter =
//            originValue -> {
//              Struct s = (Struct) originValue;
//              BigInteger bigInteger = new BigInteger(s.getBytes(VariableScaleDecimal.VALUE_FIELD));
//              int scale = s.getInt32(VariableScaleDecimal.SCALE_FIELD);
//              return new BigDecimal(bigInteger, scale);
//            };
//      } else if (Point.LOGICAL_NAME.equals(name)) {
//        converter =
//            originValue -> {
//              Struct s = (Struct) originValue;
//              JSONObject jsonObject = new JSONObject();
//              jsonObject.put(Point.X_FIELD, s.getFloat64(Point.X_FIELD));
//              jsonObject.put(Point.Y_FIELD, s.getFloat64(Point.Y_FIELD));
//              return jsonObject.toString();
//            };

      } else {
        converter =
            originValue -> {
              if (originValue instanceof Struct) {
                return parseStructValue(struct, getObjectConverter((Struct) originValue));
              } else {
                return originValue;
              }
            };
      }
      result.put(
          field, new KeyValueConverter(IllegalSchemaNameUtils.getColumnName(field), converter));
    }
    return result;
  }

  static JSONObject parseStructValue(
      Struct struct, Map<Field, KeyValueConverter> columnValueConverterMap) throws JSONException {
    // Set writeNullAsString to false to include null value.
    JSONObject store = new JSONObject(false, null, false, true);
    for (Field field : struct.schema().fields()) {
      Object value = struct.get(field);
      KeyValueConverter converterOrConverterMap = columnValueConverterMap.get(field);
      store.put(
          converterOrConverterMap.keyName,
          value == null
              ? JSONObject.NULL
              : converterOrConverterMap.objectConverter.getConvertedObject(value));
    }
    return store;
  }

  /**
   * Recursively parse Struct. Debezium defined before/after format.
   *
   * <p>e.g. {"before":{"columnA":true},"after":{"columnA":true,"columnB":32},"ts":42}
   */
  static JSONObject parseStruct(Struct struct) throws JSONException {
    Map<Field, KeyValueConverter> converterMap = getObjectConverter(struct);
    return parseStructValue(struct, converterMap);
  }

  /**
   * We assume as the datetime column being inserted, the timezone is set as UTC in MySQL session.
   * if the mysql session is by default China Standard use "Asia/Shanghai" The display of datetime
   * is not affected by timezone only depends
   */
  static String getFormattedTime(String time, TimeStringType type) {
    long timestamp;
    ZonedDateTime dateTime;
    final ZoneId zoneId = ZoneOffset.UTC;
    switch (type) {
      case EPOCH_DAY:
        timestamp = Long.parseLong(time) * ONE_DAY_MILLIS;
        dateTime = Instant.ofEpochMilli(timestamp).atZone(zoneId);
        return dateTime.format(DATE_FORMATTER);
      case EPOCH_MILLI:
        timestamp = Long.parseLong(time);
        dateTime = Instant.ofEpochMilli(timestamp).atZone(zoneId);
        return dateTime.format(DATETIME_FORMATTER);
      case EPOCH_MICRO:
        timestamp = TimeUnit.NANOSECONDS.convert(Long.parseLong(time), TimeUnit.NANOSECONDS);
        dateTime =
            Instant.ofEpochSecond(timestamp / 1000000, timestamp % 1000000 * 1000).atZone(zoneId);
        return dateTime.format(DATETIME_MICROS_FORMATTER);
      case EPOCH_NANO:
        timestamp = TimeUnit.NANOSECONDS.convert(Long.parseLong(time), TimeUnit.NANOSECONDS);
        dateTime =
            Instant.ofEpochSecond(timestamp / 1000000000, timestamp % 1000000000).atZone(zoneId);
        return dateTime.format(DATETIME_NANO_FORMATTER);
      case ZONED_TIMESTAMP:
        dateTime = ZonedDateTime.parse(time, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        return dateTime.format(ZONED_DATETIME_FORMATTER);
      case YEAR:
        return String.valueOf(
            Integer.parseInt(time) > YEAR_BASE
                ? Integer.parseInt(time)
                : (YEAR_BASE + Integer.parseInt(time)));
      case TIME:
        timestamp = Long.parseLong(time);
        dateTime = Instant.ofEpochMilli(timestamp).atZone(zoneId);
        return dateTime.format(TIME_FORMATTER);
      case MICROTIME:
        timestamp = Long.parseLong(time) / 1000;
        dateTime = Instant.ofEpochMilli(timestamp).atZone(zoneId);
        return dateTime.format(TIME_FORMATTER);
      case NANOTIME:
        timestamp = Long.parseLong(time) / 1000000;
        dateTime = Instant.ofEpochMilli(timestamp).atZone(zoneId);
        return dateTime.format(TIME_FORMATTER);
      default:
        throw new IllegalArgumentException(
            String.format("This type: %s for this time string: %s is not valid.", type, time));
    }
  }

  public enum TimeStringType {
    EPOCH_MILLI,
    EPOCH_MICRO,
    EPOCH_NANO,
    EPOCH_DAY,
    ZONED_TIMESTAMP,
    YEAR,
    TIME,
    MICROTIME,
    NANOTIME
  }
}
