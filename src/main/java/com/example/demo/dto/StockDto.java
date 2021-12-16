package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.Stock;

import javax.persistence.*;

public class StockDto {
    @Id
    private int id;
    private int quantity;
    private ProductDto productDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }
}
