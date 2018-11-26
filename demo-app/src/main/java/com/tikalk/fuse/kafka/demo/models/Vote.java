package com.tikalk.fuse.kafka.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    private String uuid;
    private Integer candidateId;
    private String region;
}
