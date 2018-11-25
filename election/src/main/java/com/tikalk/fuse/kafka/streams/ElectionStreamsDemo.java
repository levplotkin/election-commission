package com.tikalk.fuse.kafka.streams;

import com.tikalk.fuse.kafka.streams.models.Vote;
import com.tikalk.fuse.kafka.streams.serdes.JsonPOJODeserializer;
import com.tikalk.fuse.kafka.streams.serdes.JsonPOJOSerde;
import com.tikalk.fuse.kafka.streams.serdes.JsonPOJOSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serdes.LongSerde;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


import static java.util.Collections.singletonMap;
import static org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.COMMIT_INTERVAL_MS_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG;

public class ElectionStreamsDemo {



    public static void main(String args[]) throws InterruptedException {


        Properties config = new Properties();
        config.put( StreamsConfig.APPLICATION_ID_CONFIG, "my-first-tweet-ks1" );
        config.put( StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092" );
        config.put( StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName() );
        config.put( StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, JsonPOJOSerde.class.getName());
        config.put( "JsonPOJOClass", Vote.class);





        StreamsBuilder builder = new StreamsBuilder();

        KStream<String, Vote> stream = builder.stream("vote");
        stream.foreach((k, v) -> System.out.println(  "key -> " + k + " value ->" + v ));

        KafkaStreams streams = new KafkaStreams(builder.build(),config);
        streams.start();



//        StreamsBuilder builder = new StreamsBuilder();
//        KStream<String, Vote> stream = builder.stream("vote", Consumed.with(Serdes.String(), voteSerde));
//
//        stream.foreach((k, v) -> System.out.println(  "key -> " + k + " value ->" + v ));
//
//        KafkaStreams streams = new KafkaStreams(builder.build(), props);
//        streams.start();

        Thread.sleep(100000000);
//        streams.close();
    }



}