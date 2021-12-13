package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.model.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> listAllOrder();
    List<Order> getAllOrder();
    OrderDto getOrderById(int id);
    OrderDto createOrder(OrderDto orderDto);
    OrderDto updateOrder(OrderDto orderDto,int id);
}
