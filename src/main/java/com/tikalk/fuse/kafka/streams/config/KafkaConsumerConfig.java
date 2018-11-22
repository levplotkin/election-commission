package com.tikalk.fuse.kafka.streams.config;

import com.tikalk.fuse.kafka.streams.models.Vote;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value("${kafka.consumer.bootstrap-servers}")
    private String bootstrap_servers;

    @Value("${kafka.consumer.group-id}")
    private String group_id;

    @Value("${kafka.consumer.key-deserializer}")
    private String key_deserializer;

    @Value("${kafka.consumer.value-deserializer}")
    private String value_deserializer;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {

        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_servers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, group_id);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, key_deserializer);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, value_deserializer);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, Vote.class.getPackage().getName());

        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String>
    kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}