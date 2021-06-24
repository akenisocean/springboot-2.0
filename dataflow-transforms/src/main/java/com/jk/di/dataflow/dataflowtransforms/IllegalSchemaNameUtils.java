package com.jk.di.dataflow.dataflowtransforms;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.data.Schema;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IllegalSchemaNameUtils {

  public static final String ILLEGAL_SCHEMA_NAME_CHARACTERS_REGEX = "^[0-9]|[^a-zA-Z_0-9]";
  public static final String ILLEGAL_SCHEMA_FIELD_NAME_CHARACTERS_REGEX = "^[0-9]|[^A-Z0-9a-z_]";

  private static final String DELIMITER = "_MD5_";
  private static final String HEX_STRING_REGEX = "(u[0-9a-f]{4})+";

  private static final Pattern HEX_STRING_PATTERN = Pattern.compile(HEX_STRING_REGEX);

  private static final Pattern ILLEGAL_SCHEMA_NAME_PATTERN =
      Pattern.compile(ILLEGAL_SCHEMA_NAME_CHARACTERS_REGEX);

  private static final Pattern ILLEGAL_SCHEMA_FIELD_NAME_PATTERN =
      Pattern.compile(ILLEGAL_SCHEMA_FIELD_NAME_CHARACTERS_REGEX);

  public static ImmutablePair<String, Schema> getValidSchema(String schemaName, Schema schema) {
    if (ILLEGAL_SCHEMA_FIELD_NAME_PATTERN.matcher(schemaName).find()) {
      return new ImmutablePair<>(toHex(schemaName), schema);
    } else {
      return new ImmutablePair<>(schemaName, schema);
    }
  }

  public static String getValidName(String name) {
    if (ILLEGAL_SCHEMA_FIELD_NAME_PATTERN.matcher(name).find()) {
      return UUID.randomUUID().toString();
    } else {
      return name;
    }
  }

  public static String getSchemaName(String rawSchemaName) {
    if (rawSchemaName != null) {
      return rawSchemaName.split(DELIMITER)[0];
    } else {
      return null;
    }
  }

  public static String toHex(String s) {
    char[] chars = s.toCharArray();
    return IntStream.range(0, chars.length)
        .mapToObj(i -> chars[i])
        .map(c -> "u" + Integer.toHexString(c | 0x10000).substring(1))
        .collect(Collectors.joining(""));
  }

  public static String fromHex(String str) {
    StringBuilder result = new StringBuilder();
    Arrays.asList(str.split("u"))
        .forEach(
            s -> {
              if (!s.isEmpty()) {
                result.append((char) Integer.parseInt(s, 16));
              }
            });
    return result.toString();
  }

  public static String getColumnName(Field field) {
    Optional<String> parameterName =
        Optional.ofNullable(field.schema().parameters()).map(m -> m.get("name"));
    if (parameterName.isPresent()) {
      return parameterName.get();
    } else {
      if (HEX_STRING_PATTERN.matcher(field.name()).matches()) {
        return fromHex(field.name());
      } else {
        return field.name();
      }
    }
  }
}
