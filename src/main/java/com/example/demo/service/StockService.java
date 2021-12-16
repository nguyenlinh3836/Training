package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.StockDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {
    List<StockDto> getStockAll();

    StockDto getByProductId(ProductDto productDto);

    StockDto createStock(StockDto stockDto,int productId);

    StockDto updateStock(StockDto stockDto, int id);

    void deleteStock(int id);
}
