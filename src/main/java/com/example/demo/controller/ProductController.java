package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.StockDto;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import com.example.demo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private StockService stockService;


    @GetMapping
    public ResponseEntity listProduct() {
        return ResponseEntity.ok(productService.listAllProduct());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getProductById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity insertProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.insertProduct(productDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateProduct(@RequestBody ProductDto productDto, @PathVariable int id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.updateProduct(productDto, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product has been delete");
    }

    @GetMapping(value = "/stock")
    public ResponseEntity getListStock() {
        return ResponseEntity.ok(stockService.getStockAll());
    }

    @PostMapping(value = "/stock/{productId}")
    public ResponseEntity addStock(@RequestBody StockDto stockDto, @PathVariable int productId) {
        return ResponseEntity.ok(stockService.createStock(stockDto, productId));
    }
}
