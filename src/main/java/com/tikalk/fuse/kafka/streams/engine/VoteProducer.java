package com.tikalk.fuse.kafka.streams.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class VoteProducer {

    private static final Logger logger = LoggerFactory.getLogger(VoteProducer.class);
    private static final String TOPIC = "vote";

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public VoteProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void submitVote(String vote) {

        this.kafkaTemplate.send(TOPIC, vote);

        logger.info(String.format("#### -> send -> %s", vote));

    }
}
