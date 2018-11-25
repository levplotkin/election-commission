package com.tikalk.fuse.kafka.streams.serdes;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Created by sigals on 25/11/2018.
 */
public class JsonPOJOSerde<T> implements Serde<T> {
    private Serializer<T> serializer;
    private Deserializer<T> deserializer;

    public JsonPOJOSerde() {
        this.serializer = new JsonPOJOSerializer<>();
        this.deserializer = new JsonPOJODeserializer<>();
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public void close() {

    }

    @Override
    public Serializer<T> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<T> deserializer() {
        return deserializer;
    }
}
