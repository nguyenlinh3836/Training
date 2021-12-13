package com.example.demo.controller;

import com.example.demo.dto.OrderDto;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity listOrder() {
        return ResponseEntity.ok(orderService.listOrderDetail());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity orderDetailList(@PathVariable int id){
       return ResponseEntity.ok(orderService.getOrderDetailById(id));
    }

    @PostMapping(value = "/{productId}")
    public ResponseEntity createOrder(@RequestBody OrderDto orderDto, @PathVariable int productId) {
        orderService.createOrder(orderDto,productId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Your order has been created !");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateOrder(@RequestBody OrderDto orderDto, @PathVariable int id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.updateOrder(orderDto, id));
    }

}
