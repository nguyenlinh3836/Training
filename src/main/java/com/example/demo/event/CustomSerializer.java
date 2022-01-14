package com.example.demo.event;

import com.example.demo.dto.StockDto;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

public class CustomSerializer implements Serializer<List<StockDto>> {
    @Override
    public byte[] serialize(String s, List<StockDto> stockDtos) {
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(stockDtos);
            objectStream.flush();
            objectStream.close();
            return byteStream.toByteArray();
        }
        catch (IOException e) {
            throw new IllegalStateException("Can't serialize object: " + stockDtos, e);
        }
    }
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public void close() {

    }
}

