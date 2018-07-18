package com.example.demo.test;


import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableKafka
public class KafkaProducerConfig {


	private String brokerAddress="192.168.142.128:9092,192.168.142.129:9092,192.168.142.130:9092";

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	@Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.brokerAddress);
		props.put(ProducerConfig.RETRIES_CONFIG, 5);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, 10485760);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 134217728);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}


	@Bean
	public KafkaProducerListener producerListener(){
		return  new KafkaProducerListener();
	}
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		KafkaTemplate kafkaTemplate = new KafkaTemplate(producerFactory(),true);
		kafkaTemplate.setProducerListener(producerListener());
		return kafkaTemplate;
	}

}