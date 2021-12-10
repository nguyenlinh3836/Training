package com.example.demo.service;

import com.example.demo.dto.MapperDto;
import com.example.demo.dto.ProductDto;
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
    private MapperDto mapperDto;

    @Override
    public List<ProductDto> listAllProduct() {
        return mapperDto.convertToListDto(productRepo.findAll());
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.getById(id);
    }

    @Override
    public Product insertProduct(ProductDto productDto) {
        Product product = mapperDto.convertToEntity(productDto);
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(ProductDto productDto, int id) {
        Product product = mapperDto.convertToEntity(productDto);
        product.setProductId(id);
        return productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        Product product = productRepo.getById(id);
        productRepo.delete(product);
    }
}
