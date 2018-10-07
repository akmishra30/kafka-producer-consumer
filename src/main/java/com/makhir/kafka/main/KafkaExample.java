package com.makhir.kafka.main;

import java.util.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.makhir.kafka.consumer.ConsumerTask;
import com.makhir.kafka.producer.ProducerTask;

public class KafkaExample {
	private static final Logger logger = LoggerFactory.getLogger(KafkaExample.class);
	
	public static void main(String[] args) {
		//Scheduling for consumer message poll.
		logger.info("Starting consumer timer task to poll messages.");
		Timer consumerTimer = new Timer();
		consumerTimer.schedule(new ConsumerTask(), 1000);
		
		logger.info("Starting producer timer task to post messages.");
		Timer producerTimer = new Timer();
		producerTimer.schedule(new ProducerTask(), 1000, 10000);
	}
}
