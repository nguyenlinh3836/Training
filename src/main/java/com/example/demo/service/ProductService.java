package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<ProductDto> listAllProduct(int offset, int pageSize);

    ProductDto getProductById(int id);

    ProductDto insertProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto, int id);

    void delete(int id);
}
