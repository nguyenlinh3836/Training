package com.example.demo.controller;

import com.example.demo.client.StockFeignClient;
import com.example.demo.dto.StockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/v1/stock")
public class StockController {
    @Autowired
    private StockFeignClient stockFeignClient;
    @GetMapping
    public ResponseEntity getStock(){
        return ResponseEntity.ok(stockFeignClient.stocks());
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity addStock(@RequestBody StockDto stockDto,@PathVariable int id){
        return ResponseEntity.ok(stockFeignClient.addStock(stockDto,id));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity updateStock(@PathVariable int id,@RequestBody StockDto stockDto){
        return ResponseEntity.ok(stockFeignClient.updateStock(id,stockDto));
    }
}
