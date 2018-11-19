package com.tikalk.fuse.kafka.streams.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(id = "votes-container", topics = "vote", groupId = "group_id")
public class VoteTopicListener {

    private final Logger logger = LoggerFactory.getLogger(VoteTopicListener.class);

    @KafkaHandler
    public void listen(String foo) {
        logger.info(foo);
    }
}
