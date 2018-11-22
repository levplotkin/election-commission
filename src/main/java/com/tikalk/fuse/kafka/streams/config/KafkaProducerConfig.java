package com.tikalk.fuse.kafka.streams.config;

import com.tikalk.fuse.kafka.streams.models.Vote;
import org.apache.kafka.clients.producer.ProducerConfig;
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

    @Value("${kafka.producer.bootstrap-servers}")
    private String bootstrap_servers;

    @Value("${kafka.producer.key-serializer}")
    private String key_serializer;

    @Value("${kafka.producer.value-serializer}")
    private String value_serializer;

    @Bean
    public Map<String, Object> producerConfigs() {

        Map<String, Object> props = new HashMap<>();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_servers);
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, key_serializer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, value_serializer);

        return props;
    }

    @Bean
    public ProducerFactory<String, Vote> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Vote> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}