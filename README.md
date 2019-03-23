# kafka-producer-consumer
This is sample project for kafka producer-consumer example

**Required Tech-spec :**
1. Java (v1.8 or later)
2. Apache Kafka (v2.12)
3. Eclipse 
4. Maven 

**Pre-requisite:**
This is not a detailed tutorial on Apache Kafka. One should know basics of Apache Kafka and Zookeeper functioning along with Java8 before refering this repo.

## Installing Apache Kafka on you Mac machine
I have refer following tutorial to install and start the Apache Kafka

  https://www.tutorialkart.com/apache-kafka/install-apache-kafka-on-mac/

## Some basic Apache Kafka key commands

1.  Starting ZooKeeper Server   

```bin/zookeeper-server-start.sh config/zookeeper.properties```

2.  Starting Apache Kafka  

```bin/kafka-server-start.sh config/server.properties```

3. Command to get topic list from Apache Kafka    

```bin/kafka-topics.sh --zookeeper localhost:2181 --list ```  
or  

```bin/kafka-topics.sh --list --zookeeper localhost:2181```  

4. Command to create topic in Apache Kafka  

```bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 3 --topic  text-topic```

5. Command to delete topic from kafka

```bin/kafka-topics.sh --delete --zookeeper localhost:2181 --topic topic-1  ```

## For more you can refer  
https://kafka.apache.org/quickstart  AND https://kafka.apache.org/intro.html

![alt Kafka Architecture](https://www.tutorialspoint.com/apache_kafka/images/cluster_architecture.jpg)

![alt Kafka Topic Partition Layout](http://cloudurable.com/images/kafka-architecture-topic-partition-layout-offsets.png)

![alt Kafka Data Replication](http://cloudurable.com/images/kafka-architecture-topics-replication-to-partition-0.png)

## Good Article on Apache Kafka Leader-follower leader election on failover

https://bravenewgeek.com/tag/leader-election/

https://sookocheff.com/post/kafka/kafka-in-a-nutshell/

## Building kafka-producer-consumer project  
```mvn clean install```

## Running kafka-producer-consumer project
```mvn exec:java```

After running the project, you can easily see below console log if everything goes fine as per above instruction.

```
0 [com.makhir.kafka.main.KafkaExample.main()] INFO com.makhir.kafka.main.KafkaExample - Starting consumer timer task to poll messages.
1 [com.makhir.kafka.main.KafkaExample.main()] INFO com.makhir.kafka.main.KafkaExample - Starting producer timer task to post messages.
1005 [Timer-1] INFO com.makhir.kafka.producer.ProducerTask - Started the producer task for posting a messages.
1005 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerTask - Started the consumer task for polling messages from kafka topic.
1007 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Enter: pollMessages
1007 [Timer-1] INFO com.makhir.kafka.producer.ProducerClient - Enter: postMessageToKafka.
1007 [Timer-1] INFO com.makhir.kafka.producer.ProducerClient - Setting up kafka producer.
1007 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Setting up kafka consumer properties.
1011 [Timer-1] INFO com.makhir.kafka.producer.ProducerClient - Returning kafka producer.
1030 [Timer-1] INFO org.apache.kafka.clients.producer.ProducerConfig - ProducerConfig values: 
	acks = 1
	batch.size = 16384
	bootstrap.servers = [localhost:9092]
	buffer.memory = 33554432
	client.id = prducer-client
	compression.type = none
	connections.max.idle.ms = 540000
	enable.idempotence = false
	interceptor.classes = []
	key.serializer = class org.apache.kafka.common.serialization.StringSerializer
	linger.ms = 0
	max.block.ms = 60000
	max.in.flight.requests.per.connection = 5
	max.request.size = 1048576
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partitioner.class = class org.apache.kafka.clients.producer.internals.DefaultPartitioner
	receive.buffer.bytes = 32768
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retries = 0
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	transaction.timeout.ms = 60000
	transactional.id = null
	value.serializer = class org.apache.kafka.common.serialization.StringSerializer

1030 [Timer-0] INFO org.apache.kafka.clients.consumer.ConsumerConfig - ConsumerConfig values: 
	auto.commit.interval.ms = 5000
	auto.offset.reset = earliest
	bootstrap.servers = [localhost:9092]
	check.crcs = true
	client.id = consumer-client
	connections.max.idle.ms = 540000
	default.api.timeout.ms = 60000
	enable.auto.commit = false
	exclude.internal.topics = true
	fetch.max.bytes = 52428800
	fetch.max.wait.ms = 500
	fetch.min.bytes = 1
	group.id = consumer-group
	heartbeat.interval.ms = 3000
	interceptor.classes = []
	internal.leave.group.on.close = true
	isolation.level = read_uncommitted
	key.deserializer = class org.apache.kafka.common.serialization.StringDeserializer
	max.partition.fetch.bytes = 1048576
	max.poll.interval.ms = 300000
	max.poll.records = 10
	metadata.max.age.ms = 300000
	metric.reporters = []
	metrics.num.samples = 2
	metrics.recording.level = INFO
	metrics.sample.window.ms = 30000
	partition.assignment.strategy = [class org.apache.kafka.clients.consumer.RangeAssignor]
	receive.buffer.bytes = 65536
	reconnect.backoff.max.ms = 1000
	reconnect.backoff.ms = 50
	request.timeout.ms = 30000
	retry.backoff.ms = 100
	sasl.client.callback.handler.class = null
	sasl.jaas.config = null
	sasl.kerberos.kinit.cmd = /usr/bin/kinit
	sasl.kerberos.min.time.before.relogin = 60000
	sasl.kerberos.service.name = null
	sasl.kerberos.ticket.renew.jitter = 0.05
	sasl.kerberos.ticket.renew.window.factor = 0.8
	sasl.login.callback.handler.class = null
	sasl.login.class = null
	sasl.login.refresh.buffer.seconds = 300
	sasl.login.refresh.min.period.seconds = 60
	sasl.login.refresh.window.factor = 0.8
	sasl.login.refresh.window.jitter = 0.05
	sasl.mechanism = GSSAPI
	security.protocol = PLAINTEXT
	send.buffer.bytes = 131072
	session.timeout.ms = 10000
	ssl.cipher.suites = null
	ssl.enabled.protocols = [TLSv1.2, TLSv1.1, TLSv1]
	ssl.endpoint.identification.algorithm = https
	ssl.key.password = null
	ssl.keymanager.algorithm = SunX509
	ssl.keystore.location = null
	ssl.keystore.password = null
	ssl.keystore.type = JKS
	ssl.protocol = TLS
	ssl.provider = null
	ssl.secure.random.implementation = null
	ssl.trustmanager.algorithm = PKIX
	ssl.truststore.location = null
	ssl.truststore.password = null
	ssl.truststore.type = JKS
	value.deserializer = class org.apache.kafka.common.serialization.StringDeserializer

1113 [Timer-1] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version : 2.0.0
1113 [Timer-1] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId : 3402a8361b734732
1125 [Timer-0] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka version : 2.0.0
1125 [Timer-0] INFO org.apache.kafka.common.utils.AppInfoParser - Kafka commitId : 3402a8361b734732
1126 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Returning kafka consumer.
1246 [kafka-producer-network-thread | prducer-client] INFO org.apache.kafka.clients.Metadata - Cluster ID: rsGeGAirSguScYvcFcEfWQ
1246 [Timer-0] INFO org.apache.kafka.clients.Metadata - Cluster ID: rsGeGAirSguScYvcFcEfWQ
1247 [Timer-0] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-client, groupId=consumer-group] Discovered group coordinator localhost:9092 (id: 2147483647 rack: null)
1248 [Timer-0] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-client, groupId=consumer-group] Revoking previously assigned partitions []
1248 [Timer-0] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-client, groupId=consumer-group] (Re-)joining group
1342 [Timer-1] INFO com.makhir.kafka.producer.ProducerClient - Producer: Sent Message :: Key: ba73b67a-c884-4970-8283-fa503b08bb0e0, partition: 0, offset : 21004
1345 [Timer-0] INFO org.apache.kafka.clients.consumer.internals.AbstractCoordinator - [Consumer clientId=consumer-client, groupId=consumer-group] Successfully joined group with generation 45
1347 [Timer-0] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-client, groupId=consumer-group] Setting newly assigned partitions [text-topic-0]
1357 [Timer-1] INFO com.makhir.kafka.producer.ProducerClient - Producer: Sent Message :: Key: b4fd64f0-b37f-43f7-a31c-5d19342f19fa1, partition: 0, offset : 21005
1371 [Timer-1] INFO com.makhir.kafka.producer.ProducerClient - Producer: Sent Message :: Key: 5a926235-3bda-49f8-8dbf-7fb534f0528b2, partition: 0, offset : 21006
1386 [Timer-1] INFO com.makhir.kafka.producer.ProducerClient - Producer: Sent Message :: Key: 7467fe13-8019-48f9-bcb7-86ec1401384b3, partition: 0, offset : 21007
1402 [Timer-1] INFO com.makhir.kafka.producer.ProducerClient - Producer: Sent Message :: Key: 66b2ea4f-ab8d-437e-b0bb-c106d205c96e4, partition: 0, offset : 21008
1405 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message Key : ba73b67a-c884-4970-8283-fa503b08bb0e0
1405 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message text : This is message no. 0
1405 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message partition : 0
1405 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message offset : 21004
1405 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - -------------------------------------------
1405 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message Key : b4fd64f0-b37f-43f7-a31c-5d19342f19fa1
1405 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message text : This is message no. 1
1405 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message partition : 0
1405 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message offset : 21005
1405 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - -------------------------------------------
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message Key : 5a926235-3bda-49f8-8dbf-7fb534f0528b2
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message text : This is message no. 2
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message partition : 0
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message offset : 21006
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - -------------------------------------------
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message Key : 7467fe13-8019-48f9-bcb7-86ec1401384b3
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message text : This is message no. 3
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message partition : 0
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message offset : 21007
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - -------------------------------------------
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message Key : 66b2ea4f-ab8d-437e-b0bb-c106d205c96e4
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message text : This is message no. 4
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message partition : 0
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message offset : 21008
1410 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - -------------------------------------------
1414 [Timer-1] INFO com.makhir.kafka.producer.ProducerClient - Producer: Sent Message :: Key: ec807d8f-ce9e-4082-a394-4c2aa39322e05, partition: 0, offset : 21009
1417 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message Key : ec807d8f-ce9e-4082-a394-4c2aa39322e05
1417 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message text : This is message no. 5
1417 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message partition : 0
1417 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - Consumer: Message offset : 21009
1417 [Timer-0] INFO com.makhir.kafka.consumer.ConsumerClient - -------------------------------------------
```

That's it. Hope this will help you to understand basics of kafka producer, consumer concepts.

If you have anything to share I appriciate it. Thank you..!!
