package com.ocean.springcloud.oceanrabbitproducer.comsumer;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 监听器.
 *
 * @author chao.
 * @version v1.0
 * @since 2018 /2/24 9:36
 */
@Component
public class Receiver {
    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    /**
     * FANOUT广播队列监听一.
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception  这里异常需要处理
     */
    @RabbitListener(queues = {"FANOUT_QUEUE_A"})
    public void on(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.debug("FANOUT_QUEUE_A " + new String(message.getBody()));
    }

    /**
     * FANOUT广播队列监听二.
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception   这里异常需要处理
     */
    @RabbitListener(queues = {"FANOUT_QUEUE_B"})
    public void t(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.debug("FANOUT_QUEUE_B " + new String(message.getBody()));
    }

    /**
     * DIRECT模式.
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception  这里异常需要处理
     */
//    @RabbitListener(queues = {"DIRECT_QUEUE"})
    public void message(Message message, Channel channel) throws IOException, InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        String s = new String(message.getBody());
        String replace = s.replace("\"", "");
        if (replace.equals("abc")) {
//            int i  = 1/0;
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } else {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            if (0 == 0) {
//            throw new RuntimeException("接受数据处理错误了");
            }
//            channel.basicNack(message.getMessageProperties().getDeliveryTag(),true,false);
        }
        log.info("DIRECT_QUEUE接受到数据", message.toString());
        log.debug("DIRECT " + new String(message.getBody()));
    }

    /**
     * 监听替补队列 来验证死信.
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception  这里异常需要处理
     */
    @RabbitListener(queues = {"REDIRECT_QUEUE"})
    public void redirect(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.debug("dead message  10s 后 消费消息 {}", new String(message.getBody()));
    }

    public static void main(String[] args) {
        System.out.println(1 / 0);
    }
}
