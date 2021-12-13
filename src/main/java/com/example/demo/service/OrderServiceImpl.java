package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import com.example.demo.repository.OrderDetailRepo;
import com.example.demo.repository.OrderRepo;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDto> listAllOrder() {
        return orderMapper.toDtoList(orderRepo.findAll());
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    @Override
    public OrderDto getOrderById(int id) {
        return orderMapper.toDto(orderRepo.getById(id));
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        return orderMapper.toDto(orderRepo.save(order));
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto, int id) {
        Order order = orderMapper.toEntity(orderDto);
        order.setId(id);
        return orderMapper.toDto(orderRepo.save(order));
    }
}
