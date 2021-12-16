package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import com.example.demo.model.Product;
import com.example.demo.model.Stock;
import com.example.demo.repository.OrderDetailRepo;
import com.example.demo.repository.OrderRepo;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;

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
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private StockRepo stockRepo;

    @Override
    @Transactional
    public List<OrderDto> listAllOrder() {
        return orderMapper.toDtoList(orderRepo.findAll());
    }

    @Override
    @Transactional
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    @Override
    @Transactional
    public OrderDto getOrderById(int id) {
        return orderMapper.toDto(orderRepo.getById(id));
    }

    @Override
    @Transactional
    public OrderDto createOrder(OrderDto orderDto, int productId) {
        Order order = orderMapper.toEntity(orderDto);
        OrderDto orderDtoSave = orderMapper.toDto(orderRepo.save(order));
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
        orderDetail.setProduct((productRepo.getById(productId)));
        orderDetail.setTotal(productRepo.getById(productId).getPrice());
        orderDetailMapper.toDto(orderDetailRepo.save(orderDetail));
        Stock stock = stockRepo.getByProduct(productRepo.getById(productId));
        stock.setQuantity(stock.getQuantity() - order.getQuantity());
        stockRepo.save(stock);
        return orderDtoSave;
    }

    @Override
    @Transactional
    public OrderDto updateOrder(OrderDto orderDto, int id) {
        Order order = orderMapper.toEntity(orderDto);
        order.setId(id);
        Date date = new Date();
        order.setOrderDate(date);
        return orderMapper.toDto(orderRepo.save(order));
    }

    @Override
    @Transactional
    public List<OrderDetailDto> listOrderDetail() {
        return orderDetailMapper.toDtoList(orderDetailRepo.findAll());
    }

    @Override
    @Transactional
    public OrderDetailDto getOrderDetailById(int id) {
        return orderDetailMapper.toDto(orderDetailRepo.getById(id));
    }

    @Override
    @Transactional
    public OrderDetailDto updateOrderDetail(OrderDetailDto orderDetailDto, int id) {
        OrderDetail orderDetail = orderDetailMapper.toEntity(orderDetailDto);
        orderDetail.setId(id);
        return orderDetailMapper.toDto(orderDetailRepo.save(orderDetail));
    }
}
