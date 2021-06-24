package com.jk.di.dataflow.dataflowtransforms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jk.di.dataflow.dataflowtransforms.codeengine.rules.JavaCompiledCustomizedCodeEngine;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.ConnectRecord;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.data.SchemaAndValue;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.errors.DataException;
import org.codehaus.jettison.json.JSONObject;

import java.net.URL;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

/**
 * @author chao
 * @description
 * @create 2021-06-09 20:35
 */
@Slf4j
public abstract class JavaCompileTransform<R extends ConnectRecord<R>> extends BaseTransformation<R> {

    private JavaCompileConfig config;


    private static final String PURPOSE = "field insertion";


    /**
     * 对数据进行处理操作
     *
     * @param inputSchema
     * @param inputValue
     * @return
     */
    protected SchemaAndValue process(final Schema inputSchema, final Object inputValue) {
        //TODO 暂时只针对value做处理，没有对key做处理
        if (inputSchema == null && inputValue == null) {
            return new SchemaAndValue(null, null);
        }
        log.info("当前获取的schema信息:{},inputValue数据:{}", inputSchema, inputValue);
        try {
            String s = new ObjectMapper().writeValueAsString(inputValue);
            log.info("JavaCompileTransform转换后的数据信息:{}", s);
        } catch (JsonProcessingException e) {
            log.error("当前transcorms转换异常", e);
        }

        return new SchemaAndValue(inputSchema, inputValue);
    }


    @Override
    protected SchemaAndValue processStruct(R record, Schema inputSchema, Struct input) {
        //TODO 暂时只针对value做处理，没有对key做处理
        if (inputSchema == null && input == null) {
            return new SchemaAndValue(null, null);
        }
        log.info("当前获取的schema信息:{},inputValue数据:{}", inputSchema, input);
        try {
            JSONObject jsonObject = SinkRecordSerializer.parseStruct(input);
            String classPath = "http://192.168.3.201:5000/download/code_engines/java/143/2985/Sid_2985_f0a72ef72985defd29854ecf2985903129852155508b8611.class";
            URL url = new URL(classPath);
            String path = URLDecoder.decode(
                    classPath.substring(classPath.lastIndexOf("/") + 1).split("\\.")[0], "utf-8");
            JavaCompiledCustomizedCodeEngine jsonProcess = new JavaCompiledCustomizedCodeEngine(url, path);
            List<JSONObject> process = jsonProcess.process(jsonObject, null);
            log.info("编译脚本执行的数据调整后的内容为:{}",process);
//            final byte[] buffer = this.converter.fromConnectData("dummy", inputSchema, input);
//            String name = new String(buffer, Charsets.UTF_8);

            /** ----------- c sdadadad -------------------------------*/
            final Struct value = requireStruct(record.value(), PURPOSE);
            log.info("record中的内容为:{}",record.value());

            log.info("JavaCompileTransform转换后的数据信息:{}", jsonObject.toString());

        } catch (Exception e) {
            log.error("当前transcorms转换异常", e);
        }

        return new SchemaAndValue(inputSchema, input);
    }


    public static Struct requireStruct(Object value, String purpose) {
        if (!(value instanceof Struct)) {
            throw new DataException("Only Struct objects supported for [" + purpose + "], found: " + nullSafeClassName(value));
        }
        return (Struct) value;
    }

    private static String nullSafeClassName(Object x) {
        return x == null ? "null" : x.getClass().getName();
    }



    @Override
    public ConfigDef config() {
        return JavaCompileConfig.configDef();
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {
        config = new JavaCompileConfig(configs);
    }

    public static class Key<R extends ConnectRecord<R>> extends JavaCompileTransform<R> {

        /**
         * {@inheritDoc}
         */
        @Override
        public R apply(R r) {
            final SchemaAndValue transformed = process(r, r.keySchema(), r.key());
            return r.newRecord(
                    r.topic(),
                    r.kafkaPartition(),
                    transformed.schema(),
                    transformed.value(),
                    r.valueSchema(),
                    r.value(),
                    r.timestamp()
            );
        }
    }

    public static class Value<R extends ConnectRecord<R>> extends JavaCompileTransform<R> {

        /**
         * {@inheritDoc}
         */
        @Override
        public R apply(R r) {
            final SchemaAndValue transformed = process(r, r.valueSchema(), r.value());
            return r.newRecord(
                    r.topic(),
                    r.kafkaPartition(),
                    r.keySchema(),
                    r.key(),
                    transformed.schema(),
                    transformed.value(),
                    r.timestamp()
            );
        }
    }
}
