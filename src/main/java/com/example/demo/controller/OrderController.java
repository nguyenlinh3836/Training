package com.example.demo.controller;

import com.example.demo.dto.OrderDetailDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity listOrder() {
        return ResponseEntity.ok(orderService.listAllOrder());
//          return ResponseEntity.ok(orderService.getAllOrder());
    }
    @GetMapping(value = "/orderDetail")
    public ResponseEntity orderDetailList(){
        return ResponseEntity.ok(orderDetailService.listOrderDetail());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getOrderById(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PostMapping(value = "/{productId}")
    public ResponseEntity createOrder(@RequestBody OrderDto orderDto, @PathVariable int productId) {
        OrderDto orderCreate = orderService.createOrder(orderDto);
        orderDetailService.createOrderDetail(orderCreate,productId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateOrder(@RequestBody OrderDto orderDto, @PathVariable int id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.updateOrder(orderDto, id));
    }

}
