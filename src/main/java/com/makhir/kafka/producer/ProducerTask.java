package com.makhir.kafka.producer;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerTask extends TimerTask{

	private static final Logger logger = LoggerFactory.getLogger(ProducerTask.class);
	
	@Override
	public void run() {
		logger.info("Started the producer task for posting a messages.");
		
		ProducerClient producerClient = new ProducerClient();
		try {
			producerClient.postMessageToKafka();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("There was a problem while posting a message, {}", e.getMessage());
		}
	}

}
