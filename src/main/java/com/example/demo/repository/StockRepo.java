package com.example.demo.repository;

import com.example.demo.model.Product;
import com.example.demo.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock,Integer> {
    Stock getByProduct(Product product);
}
