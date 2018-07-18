package com.example.demo.test;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;


@SuppressWarnings("rawtypes")
public class KafkaProducerListener implements ProducerListener {
    
    /**
     * 发送消息成功后调用
     */
    @Override
    public void onSuccess(String topic, Integer partition, Object key,
                          Object value, RecordMetadata recordMetadata) {
        System.out.println("==========kafka发送数据成功（日志开始）==========");
        System.out.println("----------topic:"+topic);
        System.out.println("----------partition:"+partition);
        System.out.println("----------key:"+key);
        System.out.println("----------value:"+value);
        System.out.println("----------RecordMetadata:"+recordMetadata);
        System.out.println("~~~~~~~~~~kafka发送数据成功（日志结束）~~~~~~~~~~");
    }

    /**
     * 发送消息错误后调用
     */
    @Override
    public void onError(String topic, Integer partition, Object key,
                        Object value, Exception exception) {
        System.out.println("==========kafka发送数据错误（日志开始）==========");
        System.out.println("----------topic:"+topic);
        System.out.println("----------partition:"+partition);
        System.out.println("----------key:"+key);
        System.out.println("----------value:"+value);
        System.out.println("----------Exception:"+exception);
        System.out.println("~~~~~~~~~~kafka发送数据错误（日志结束）~~~~~~~~~~");
        exception.printStackTrace();
    }

    /**
     * 方法返回值代表是否启动kafkaProducer监听器
     */
    @Override
    public boolean isInterestedInSuccess() {
        System.out.println("///kafkaProducer监听器启动///");
        return true;
    }

}
