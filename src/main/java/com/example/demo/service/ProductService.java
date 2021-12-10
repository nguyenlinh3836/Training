package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> listAllProduct();

    ProductDto getProductById(int id);

    ProductDto insertProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto, int id);

    void delete(int id);
}
