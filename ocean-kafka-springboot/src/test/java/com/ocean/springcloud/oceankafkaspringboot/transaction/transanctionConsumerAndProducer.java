package com.ocean.springcloud.oceankafkaspringboot.transaction;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.*;

/**
 * @author: chao
 * @description:
 * @create: 2020-11-18 13:04
 */
@Slf4j
public class transanctionConsumerAndProducer {
    public static final String brokerList = "192.168.3.213:9092,192.168.3.214:9092";


    /**
     * 配置消费者端的属性
     * @return
     */
    public static Properties getConsumerProperties(){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,brokerList);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,Boolean.FALSE);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"groupId");
        return properties;
    }

    public static Properties getProducerProperties(){
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,brokerList);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,"transactionId");
        return properties;
    }

    public static void main(String[] args) {
        //初始化消费者和生产者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(getConsumerProperties());
        consumer.subscribe(Collections.singletonList("topic-source"));

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(getProducerProperties());
        //初始化事务
        producer.initTransactions();
        while (true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            if (!records.isEmpty()){
                Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
                //开启事务
                producer.beginTransaction();
                try {
                    records.partitions().forEach(partition -> {
                        List<ConsumerRecord<String, String>> partitionRecords = records.records(partition);
                        partitionRecords.forEach(record ->{
                            // do some logical processing 开始你的业务逻辑代码
                            ProducerRecord<String, String> producerRecord = new ProducerRecord<>("topic-sink", record.key(), record.value());
                            //消费-生产模型
                            producer.send(producerRecord);

                        });
                        long lastConsumerdOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
                        offsets.put(partition,new OffsetAndMetadata(lastConsumerdOffset-1));
                    });
                    //提交消费位移
                    producer.sendOffsetsToTransaction(offsets,"groupId");
                    //提交事务
                    producer.commitTransaction();

                }catch (Exception e){
                    // log the exception
                    log.error("消费消息异常",e);
                    //中止事务
                    producer.abortTransaction();

                }
            }


        }
    }
}
