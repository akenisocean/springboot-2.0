package com.ocean.springcloud.oceankafkaspringboot.producer;

import com.ocean.springcloud.oceankafkaspringboot.config.TopicCreateConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: chao
 * @description: kafka生产端
 * @create: 2020-10-16 15:57
 */
@Component
@AllArgsConstructor
@Slf4j
public class KafkaProducer {

    final KafkaTemplate<String,String> kafkaTemplate;

    private static final Integer defaultPatition = 0;

//    final CustomKafkaProducerListenerHandler customKafkaProducerListenerHandler;



//    @PostConstruct
    public void init(){
//        kafkaTemplate.setProducerListener(customKafkaProducerListenerHandler);
    }




    /**
     * 发送信息入kafka
     * @param message
     */
    public void sendMessage(String message) {
        log.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TopicCreateConfig.TOPIC, message);
    }


    /**
     * 发送错误信息入kafka
     * @param message
     */
    public void sendErrorMessage(String message) {
        log.info(String.format("#### -> Producing error message -> %s", message));
        String defaultKey = "jack";
//        AtomicInteger partition  = new AtomicInteger(0);
//        if (message.startsWith("foo")){
//            partition.set(1);
//        }
        this.kafkaTemplate.send(TopicCreateConfig.ERROR_TOPIC,defaultKey, message);
    }


}
