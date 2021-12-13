package com.example.demo.service;

import com.example.demo.dto.OrderDetailDto;
import com.example.demo.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    List<OrderDetailDto> listOrderDetail();
    OrderDetailDto getOrderDetailById(int id);
    OrderDetailDto createOrderDetail(OrderDto orderDto,int productId);
    OrderDetailDto updateOrderDetail(OrderDetailDto orderDetailDto,int id);

}
