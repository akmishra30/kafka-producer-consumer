package com.makhir.kafka.consumer;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.makhir.kafka.main.KafkaConstant;

public class ConsumerClient {
	
	private static final Logger logger = LoggerFactory.getLogger(ConsumerClient.class);

	private KafkaConsumer<String, String> getKafkaConsumer() {

		logger.info("Setting up kafka consumer properties.");
		Properties kafkaProp = new Properties();

		kafkaProp.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.KAFKA_SERVER_URL);
		kafkaProp.put(ConsumerConfig.CLIENT_ID_CONFIG, KafkaConstant.KAFKA_CON_CLIENT_ID);
		kafkaProp.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstant.KAFKA_CON_GROUP_ID);
		kafkaProp.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		kafkaProp.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		kafkaProp.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, KafkaConstant.CON_MAX_POLL_COUNT);
		kafkaProp.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, KafkaConstant.CON_ENABLE_AUTO_COMMIT);
		kafkaProp.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, KafkaConstant.CON_OFFSET_RESET_EARLIER);

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(kafkaProp);
        consumer.subscribe(Collections.singletonList(KafkaConstant.KAFKA_TOPIC_NAME));
        logger.info("Returning kafka consumer.");
		return consumer;
	}
	
	/**
	 * This method poll messages from Kafka topic.
	 * */
	public void pollMessages() throws Exception{
		logger.info("Enter: pollMessages");
		
		KafkaConsumer<String, String> consumer = null;
		
		try {
			consumer = getKafkaConsumer();
			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(KafkaConstant.getConsumerPollingDuration());
				if(records.count() == 0)
					logger.info("There is no reocrd to consume from kafka.");
				else {
					records.forEach(record -> {
						logger.info("Consumer: Message Key : {}", record.key());
						logger.info("Consumer: Message text : {}", record.value());
						logger.info("Consumer: Message partition : {}", record.partition());
						logger.info("Consumer: Message offset : {}", record.offset());
						logger.info("-------------------------------------------");
					});
					//Commits the offset of message to kafka topic's partition.
					consumer.commitAsync(); 
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		finally{
			if(consumer != null)
				consumer.close();
			logger.info("Exit: pollMessages");
		}
	}
	
}
