package com.example.demo.dto;

import javax.persistence.Id;
import java.util.Set;

public class OrderDetailDto {
    @Id
    private int id;
    private double total;
    private ProductDto product;
    private OrderDto order;

    public OrderDetailDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }
}
