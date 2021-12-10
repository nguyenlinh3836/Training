package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> listAllProduct();

    Product getProductById(int id);

    Product insertProduct(ProductDto productDto);

    Product updateProduct(ProductDto productDto, int id);

    void delete(int id);
}
