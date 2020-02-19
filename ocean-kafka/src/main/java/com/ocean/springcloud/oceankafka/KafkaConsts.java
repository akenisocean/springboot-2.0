package com.ocean.springcloud.oceankafka;

/**
 * @author: chao
 * @description:
 * @create: 2020-02-15 19:09
 */
public interface KafkaConsts {
    /**
     * 默认分区大小
     */
    Integer DEFAULT_PARTITION_NUM = 3;

    /**
     * Topic 名称
     */
    String TOPIC_TEST = "hello";
}
