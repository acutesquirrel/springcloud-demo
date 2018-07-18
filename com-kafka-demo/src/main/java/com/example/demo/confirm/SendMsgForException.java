package com.example.demo.confirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/send")
public class SendMsgForException {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/kafka/{topic}/{json}")
    public void sendExceptionMsg(@PathVariable("topic")String topic, @PathVariable("json")String json){
        System.out.println("topic:"+topic+"json:"+json);
        kafkaTemplate.send(topic,json);
    }


}
