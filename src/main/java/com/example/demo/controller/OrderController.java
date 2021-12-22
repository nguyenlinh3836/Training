package com.example.demo.controller;

import com.example.demo.client.StockFeignClient;
import com.example.demo.dto.*;
import com.example.demo.model.OrderDetail;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private StockFeignClient stockFeignClient;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @GetMapping
    public ResponseEntity listOrder() {
        return ResponseEntity.ok(orderService.listOrderDetail());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity orderDetailList(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderDetailById(id));
    }

    @PostMapping(value = "/{productId}")
    public ResponseEntity createOrder(@RequestBody OrderDto orderDto, @PathVariable int productId) {
        orderService.createOrder(orderDto, productId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Your order has been created !");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateOrder(@RequestBody OrderDto orderDto, @PathVariable int id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.updateOrder(orderDto, id));
    }
    @PostMapping(value = "/done/{id}")
    public ResponseEntity orderDone(@PathVariable int id){
        OrderDto orderDto = orderService.orderDone(id);
        List<OrderDetailDto> orderDetailDtos = orderService.getByOrder(orderDto);
        List<StockDto> stockDtos = new ArrayList<>();
        for (OrderDetailDto orderDetail : orderDetailDtos ){
            int productId = orderDetail.getProduct().getId();
            StockDto stockDto = stockFeignClient.getByProductId(productId);
            stockDto.setQuantity(stockDto.getQuantity() - orderDto.getQuantity());
            stockDtos.add(stockDto);
        }
        stockFeignClient.saveAllStock(stockDtos);
        return ResponseEntity.ok("Thank for your purchase !");
    }

}
