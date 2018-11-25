package com.tikalk.fuse.kafka.demo.controllers;

import com.tikalk.fuse.kafka.demo.engine.VoteProducer;
import com.tikalk.fuse.kafka.demo.models.Vote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
public class VoteController {

    private final VoteProducer producer;

    @Autowired
    VoteController(VoteProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/vote")
    public void sendMessageToKafkaTopicVote(@RequestBody Vote vote) {
        this.producer.submitVote(vote);
    }

}
