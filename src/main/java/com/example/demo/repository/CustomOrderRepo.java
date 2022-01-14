package com.example.demo.repository;

import com.example.demo.model.Order;

import java.util.List;
import java.util.Set;

public interface CustomOrderRepo {
    List<Order> filterOrderByName(String name,Integer quantity);
}
