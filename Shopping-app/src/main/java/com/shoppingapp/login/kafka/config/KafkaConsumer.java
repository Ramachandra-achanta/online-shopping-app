package com.shoppingapp.login.kafka.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics="ProductsOrderAndStatus",groupId = "shoppingProductData")
	public void consume(String message) {
		 LOGGER.info(String.format("Message received -> %s", message));
	}
}
