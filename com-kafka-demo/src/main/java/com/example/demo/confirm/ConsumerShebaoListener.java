package com.example.demo.confirm;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerShebaoListener {

    @KafkaListener(topics = "test.kafka")
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("1111111111111111");
        System.out.println("record-->:"+record.topic());
        System.out.println("record-->:"+record.value());

    }

}
