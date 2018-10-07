package com.makhir.kafka.consumer;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Kafka consumer task for polling messages from kafka topic.
 * 
 * */
public class ConsumerTask extends TimerTask{

	private static final Logger logger = LoggerFactory.getLogger(ConsumerTask.class);
	
	@Override
	public void run() {
		logger.info("Started the consumer task for polling messages from kafka topic.");
		
		ConsumerClient client = new ConsumerClient();
		try {
			client.pollMessages();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
