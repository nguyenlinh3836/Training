package com.example.demo.controller;

import com.example.demo.client.StockFeignClient;
import com.example.demo.dto.*;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private StockFeignClient stockFeignClient;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private KafkaTemplate<String, List<StockDto>> kafkaTemplate;

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
            stockDto.setProductid(productId);
            stockDtos.add(stockDto);
        }
          kafkaTemplate.send("orderTopic",stockDtos);
//        stockFeignClient.saveAllStock(stockDtos);
        return ResponseEntity.ok("Thank for your purchase !");
    }
    @GetMapping(value = "/filterOrder")
    public ResponseEntity filterOrder(@RequestParam String name,@RequestParam int quantity){
        return ResponseEntity.ok(orderService.filterOrder(name,quantity));
    }

}
