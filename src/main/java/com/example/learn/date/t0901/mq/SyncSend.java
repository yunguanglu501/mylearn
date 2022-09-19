package com.example.learn.date.t0901.mq;

import com.example.learn.common.BizConstant;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * SyncSend
 *
 * @author wcy
 * @date 2022/9/1
 */
public class SyncSend {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("pg-0901");
        producer.setNamesrvAddr(BizConstant.NAME_SERVER);

        producer.start();

        Message message = new Message("topic-0901", "tagA", "k13","我是中国人13".getBytes(StandardCharsets.UTF_8));
        SendResult send = producer.send(message);
        System.out.println("send = " + send);

        producer.shutdown();

    }
}
