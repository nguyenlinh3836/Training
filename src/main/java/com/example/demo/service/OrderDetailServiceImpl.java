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

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepo orderDetailRepo;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<OrderDetailDto> listOrderDetail() {
        return orderDetailMapper.toDtoList(orderDetailRepo.findAll())  ;
    }

    @Override
    public OrderDetailDto getOrderDetailById(int id) {
        return orderDetailMapper.toDto(orderDetailRepo.getById(id));
    }

    @Override
    public OrderDetailDto createOrderDetail(OrderDto orderDto,int productId) {
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
