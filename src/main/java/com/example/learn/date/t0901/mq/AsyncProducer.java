package com.example.learn.date.t0901.mq;

import com.alibaba.fastjson.JSON;
import com.example.learn.common.BizConstant;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * AsyncProducer
 *
 * @author wcy
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("pg-0902");
        producer.setNamesrvAddr(BizConstant.NAME_SERVER);

        producer.start();

        Message message = new Message("topic-0901", "tagD", "k4","我是中国人5".getBytes(StandardCharsets.UTF_8));
        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送成功 "+ JSON.toJSONString(sendResult));
            }

            @Override
            public void onException(Throwable e) {
                System.out.println("发送失败 " + e);
            }
        });

        // Thread.sleep(10L);
        // producer.shutdown();
    }
}
