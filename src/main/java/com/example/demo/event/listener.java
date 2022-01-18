package com.example.demo.event;

import com.example.demo.dto.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class listener {
    @KafkaListener(topics = "orderTopic",groupId = "group-id")
    @GetMapping("/kafka")
    public void publish(StockDto stockDto){
        System.out.println("New Entry: "
                + stockDto);
    }
}
