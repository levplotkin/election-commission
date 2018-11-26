package com.tikalk.fuse.kafka.demo.engine;

import com.tikalk.fuse.kafka.demo.models.Vote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VoteProducer {

    private static final Logger logger = LoggerFactory.getLogger(VoteProducer.class);

    @Value("${kafka.vote.topic}")
    private String voteTopic;

    private final KafkaTemplate<String, Vote> kafkaTemplate;

    @Autowired
    public VoteProducer(KafkaTemplate<String, Vote> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void submitVote(Vote vote) {

        vote.setUuid(UUID.randomUUID().toString());

        String topic = voteTopic + "-" + vote.getRegion().toUpperCase();
        Message<Vote> message = MessageBuilder.withPayload(vote)
                .setHeader(KafkaHeaders.MESSAGE_KEY, "kuku")
                .setHeader(KafkaHeaders.TOPIC, topic+vote.getRegion().toUpperCase())
                .build();

        this.kafkaTemplate.send(message);

        logger.info(String.format("#### -> send -> %s, to topic %s", vote,topic ));
    }
}
