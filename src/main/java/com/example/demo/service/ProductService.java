package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProduct();
    Product getProductById(int id);
    Product insertProduct(Product product);
    void updateProduct(Product product);
    void delete(int id);
}
