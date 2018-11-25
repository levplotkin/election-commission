package com.tikalk.fuse.kafka.streams.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    private String uuid;
    private Integer choice;
    private Map<String, String> metaData;
}
