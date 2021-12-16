package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.Stock;

import javax.persistence.*;

public class StockDto {
    @Id
    private int id;
    private int quantity;

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

}
