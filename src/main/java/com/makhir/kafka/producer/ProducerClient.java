package com.makhir.kafka.producer;

import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.makhir.kafka.main.KafkaConstant;

public class ProducerClient {
	
	private static final Logger logger = LoggerFactory.getLogger(ProducerClient.class);
	
	private KafkaProducer<String, String> getKafkaProducer() {
		logger.info("Setting up kafka producer.");
		Properties kafkaProp = new Properties();

		kafkaProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.KAFKA_SERVER_URL);
		kafkaProp.put(ProducerConfig.CLIENT_ID_CONFIG, KafkaConstant.KAFKA_PROD_CLIENT_ID);
		kafkaProp.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		kafkaProp.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		logger.info("Returning kafka producer.");
		
		return new KafkaProducer<>(kafkaProp);
	}
	
	public void postMessageToKafka() throws Exception {
		logger.info("Enter: postMessageToKafka.");
		KafkaProducer<String, String> producer = null;
		try {
			producer = getKafkaProducer();
			int count = 0;

			while (count < 100) {
				String uniqueId = UUID.randomUUID().toString() + count;

				ProducerRecord<String, String> record = new ProducerRecord<String, String>(
						KafkaConstant.KAFKA_TOPIC_NAME, uniqueId, "This is message no. " + count);
				RecordMetadata metaData = producer.send(record).get();
				//producer.send(record);
				logger.info("Producer: Sent Message :: Key: {}, partition: {}, offset : {}", new Object[]{uniqueId, metaData.partition(), metaData.offset()});
				//System.out.println("Message sent with unique id : " + uniqueId);
				count++;
				Thread.sleep(10);

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("There was a problem while posting message in kafka, {}", e.getMessage());
			throw e;
		}

		finally {
			if (producer != null) {
				producer.flush();
				producer.close();
			}
			
			logger.info("Exit: postMessageToKafka.");
		}
	
	}
	
}
