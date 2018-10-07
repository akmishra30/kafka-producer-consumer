package com.makhir.kafka.main;

import java.time.Duration;

/**
 * This is common kafka constants which are used in projects
 * 
 * */
public interface KafkaConstant {
	public static final String KAFKA_SERVER_URL = "localhost:9092"; // comma separated zookeper urls
	public static final String KAFKA_TOPIC_NAME = "text-topic";
	
	//Producer specific properties
	public static String KAFKA_PROD_CLIENT_ID = "prducer-client";
	
	
	//Consumer specific properties
	public static String KAFKA_CON_CLIENT_ID = "consumer-client";
	public static String KAFKA_CON_GROUP_ID = "consumer-group";
	public static String CON_OFFSET_RESET_LATEST = "latest";
    public static String CON_OFFSET_RESET_EARLIER = "earliest";
    
    /* If true the consumer's offset will be periodically committed in the background. Default id true*/
    public static String CON_ENABLE_AUTO_COMMIT = "false";
    
    /* timeout - The maximum time to block (must not be greater than Long.MAX_VALUE milliseconds) */
    public static long CON_MAX_BLOCK_TIME_MS = 1000;
    /* Use this setting to limit the total records returned from a single call to poll. 
     * This can make it easier to predict the maximum that must be handled within each poll interval. 
     * By tuning this value, you may be able to reduce the poll interval, 
     * which will reduce the impact of group re-balancing. */
    public static int CON_MAX_POLL_COUNT = 10;
	
    static Duration getConsumerPollingDuration(){
    	Duration duration = Duration.ofMillis(CON_MAX_BLOCK_TIME_MS);
    	return duration;
    }
    
}
