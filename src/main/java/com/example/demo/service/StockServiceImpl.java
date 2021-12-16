package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductMapper;
import com.example.demo.dto.StockDto;
import com.example.demo.dto.StockMapper;
import com.example.demo.model.Product;
import com.example.demo.model.Stock;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepo stockRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public List<StockDto> getStockAll() {
        return stockMapper.toDtoList(stockRepo.findAll());
    }

    @Override
    public StockDto getByProductId(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        return stockMapper.toDto(stockRepo.getByProduct(product));
    }

    @Override
    @Transactional
    public StockDto createStock(StockDto stockDto, int productId) {
        Stock stock = stockMapper.toEntity(stockDto);
        stock.setProduct(productRepo.getById(productId));
        return stockMapper.toDto(stockRepo.save(stock));
    }

    @Override
    @Transactional
    public StockDto updateStock(StockDto stockDto, int id) {
        Stock stock = stockMapper.toEntity(stockDto);
        stock.setId(id);
        return stockMapper.toDto(stockRepo.save(stock));
    }

    @Override
    @Transactional
    public void deleteStock(int id) {
        stockRepo.delete(stockRepo.getById(id));
    }
}
