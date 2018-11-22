package com.tikalk.fuse.kafka.streams.engine;

import com.tikalk.fuse.kafka.streams.models.Vote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(id = "votes-container", topics = "${kafka.vote.topic}", groupId = "${kafka.consumer.group-id}")
public class VoteTopicListener {

    private final Logger logger = LoggerFactory.getLogger(VoteTopicListener.class);

    @KafkaHandler
    public void listen(Vote vote) {
        logger.info(vote.toString());
    }
}
