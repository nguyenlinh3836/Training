package com.example.demo.dto;

import com.example.demo.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring",  nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MapperDto {
    Product convertToEntity(ProductDto productDto);
    ProductDto convertToDto(Product product);
    List<ProductDto> convertToListDto(List<Product> products);
}
