package com.example.demo.client;

import com.example.demo.dto.StockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "stockService",url = "http://localhost:8081/api/v1/stock")
public interface StockFeignClient {
    @GetMapping
    List<StockDto> stocks();
    @PostMapping(value = "/{productId}")
    StockDto addStock(StockDto stockDto, @PathVariable int productId);
    @PutMapping(value = "/{id}")
    StockDto updateStock(@PathVariable int id, @RequestBody StockDto stockDto);
    @GetMapping(value = "/{id}")
    StockDto getByProductId(@PathVariable int id);
    @PostMapping(value = "/saveAll")
    List<StockDto> saveAllStock(@RequestBody List<StockDto>stockDtos);

}
