package com.example.demo.service;

import com.example.demo.dto.OrderDetailDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;

import java.util.List;

public interface OrderService {
    List<OrderDto> listAllOrder();
    List<Order> getAllOrder();
    OrderDto getOrderById(int id);
    OrderDto createOrder(OrderDto orderDto,int productId);
    OrderDto updateOrder(OrderDto orderDto,int id);
    OrderDto orderDone(int id);
    List<OrderDetailDto> listOrderDetail();
    OrderDetailDto getOrderDetailById(int id);
    OrderDetailDto updateOrderDetail(OrderDetailDto orderDetailDto,int id);
    List<OrderDetailDto> getByOrder(OrderDto orderDto);
}
