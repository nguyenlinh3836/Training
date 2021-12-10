package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Id;


@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProductDto {
    @Id
    private int productId;
    private String productName;

    public ProductDto() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
