package com.example.demo.service;

import com.example.demo.dto.OrderDetailDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.model.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> listAllOrder();
    List<Order> getAllOrder();
    OrderDto getOrderById(int id);
    void createOrder(OrderDto orderDto,int productId);
    OrderDto updateOrder(OrderDto orderDto,int id);
    List<OrderDetailDto> listOrderDetail();
    OrderDetailDto getOrderDetailById(int id);
    OrderDetailDto updateOrderDetail(OrderDetailDto orderDetailDto,int id);
}
