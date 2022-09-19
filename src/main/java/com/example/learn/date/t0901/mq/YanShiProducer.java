package com.example.learn.date.t0901.mq;

import com.example.learn.common.BizConstant;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * YanShiProducer
 *
 * @author wcy
 * @date 2022/9/1
 */
public class YanShiProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("pg-0901");
        producer.setNamesrvAddr(BizConstant.NAME_SERVER);

        producer.start();
        int totalMessagesToSend = 10;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message(BizConstant.TOPIC, ("Hello2 scheduled message " + i).getBytes());
            // 设置延时等级3,这个消息将在10s之后发送(现在只支持固定的几个时间,详看delayTimeLevel)
            message.setDelayTimeLevel(4);
            // 发送消息
            producer.send(message);
        }
        // 关闭生产者
        producer.shutdown();

    }
}
