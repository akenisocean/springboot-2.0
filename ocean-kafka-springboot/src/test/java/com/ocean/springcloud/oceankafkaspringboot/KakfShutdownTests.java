package com.ocean.springcloud.oceankafkaspringboot;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.common.Node;
import org.junit.jupiter.api.Test;

import java.util.Properties;

/**
 * @author: chao
 * @description:
 * @create: 2020-11-15 14:56
 */
public class KakfShutdownTests {


    @Test
    public void shudownBroker1(){
        Properties properties = new Properties();
        String brokerUrl = "192.168.3.213:9092";
        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG,brokerUrl);
        AdminClient adminClient = AdminClient.create(properties);
        Node node = new Node(-1, "192.168.3.213", 9092);
    }


}
