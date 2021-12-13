package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import com.example.demo.repository.OrderDetailRepo;
import com.example.demo.repository.OrderRepo;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private ProductRepo productRepo;

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
        Date date = new Date(new java.util.Date().getTime());
        order.setOrderDate(date);
        return orderMapper.toDto(orderRepo.save(order));
    }

    @Override
    public List<OrderDetailDto> listOrderDetail() {
        return orderDetailMapper.toDtoList(orderDetailRepo.findAll());
    }

    @Override
    public OrderDetailDto getOrderDetailById(int id) {
        return orderDetailMapper.toDto(orderDetailRepo.getById(id));
    }

    @Override
    public OrderDetailDto createOrderDetail(OrderDto orderDto, int productId) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(orderMapper.toEntity(orderDto));
        orderDetail.setProduct((productRepo.getById(productId)));
        orderDetail.setTotal(productRepo.getById(productId).getPrice());
        return orderDetailMapper.toDto(orderDetailRepo.save(orderDetail));
    }

    @Override
    public OrderDetailDto updateOrderDetail(OrderDetailDto orderDetailDto, int id) {
        OrderDetail orderDetail = orderDetailMapper.toEntity(orderDetailDto);
        orderDetail.setId(id);
        return orderDetailMapper.toDto(orderDetailRepo.save(orderDetail));
    }
}
