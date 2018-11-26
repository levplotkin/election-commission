package com.tikalk.fuse.kafka.streams.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    private String uuid;
    private Integer candidateId;
    private String region;

}
