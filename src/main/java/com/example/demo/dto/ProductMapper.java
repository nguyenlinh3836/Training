package com.example.demo.dto;


import com.example.demo.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {StockMapper.class})
public interface ProductMapper extends EntityMapper<ProductDto, Product> {
}
