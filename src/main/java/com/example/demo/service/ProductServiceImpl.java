package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductMapper;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<ProductDto> listAllProduct() {
        return productMapper.toDtoList(productRepo.findAll());
    }

    @Override
    public ProductDto getProductById(int id) {
        return productMapper.toDto(productRepo.getById(id));

    }

    @Override
    public ProductDto insertProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productRepo.save(product));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, int id) {
        Product product = productMapper.toEntity(productDto);
        product.setProductId(id);
        return productMapper.toDto(productRepo.save(product));
    }

    @Override
    public void delete(int id) {
        Product product = productRepo.getById(id);
        productRepo.delete(product);
    }
}
