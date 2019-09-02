package com.ocean.springclouid.oceanrabbitmqconsumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 季超
 * @create 2018-11-08 17:01
 * @desc
 **/
@Component
@Slf4j
public class RabbitListenerTest {

//    @RabbitListener(queues = {"orderQueue11"})
//    public void testProcess(Channel channel, @Header(name = "amqp_deliveryTag") long deliveryTag,
//                            @Header("amqp_redelivered") boolean redelivered, @Headers Map<String, String> head) throws IOException {
//        System.out.println("header"+head);
//
//        try {
//            channel.basicNack(deliveryTag,false,false);
//            System.out.println("成功了");
//        } catch (IOException e) {
//            log.error("consume confirm error!", e);
//            //这一步千万不要忘记，不会会导致消息未确认，消息到达连接的qos之后便不能再接收新消息
//            //一般重试肯定的有次数，这里简单的根据是否已经重发过来来决定重发。第二个参数表示是否重新分发
//            channel.basicReject(deliveryTag, !redelivered);
//            //这个方法我知道的是比上面多一个批量确认的参数
//            // channel.basicNack(deliveryTag, false,!redelivered);
//        }

//    }

}
