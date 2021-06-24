package com.jk.di.dataflow.dataflowtransforms;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;

import java.util.Map;

/**
 * @author chao
 * @description
 * @create 2021-06-09 20:37
 */
public class JavaCompileConfig extends AbstractConfig {

    /**
     * Creates a new {@link JavaCompileConfig} instance.
     *
     * @param originals the originals configuration.
     */
    public JavaCompileConfig(final Map<String, ?> originals) {
        super(configDef(), originals);
    }

    public static ConfigDef configDef() {
        return new ConfigDef();
    }
}
