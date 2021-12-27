//package com.example.demo.controller;
//
//import com.example.demo.dto.ProductDto;
//import com.example.demo.dto.SupplierDto;
//import com.example.demo.service.SupplierService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api/v1/supplier")
//public class SupplierController {
//    @Autowired
//    private SupplierService supplierService;
//
//    @GetMapping
//    public ResponseEntity listSupplier() {
//        return ResponseEntity.ok(supplierService.listAllSupplier());
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity getProductById(@PathVariable int id) {
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(supplierService.getById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity insertSupplier(@RequestBody SupplierDto supplierDto) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.createSupplier(supplierDto));
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity updateSupplier(@RequestBody SupplierDto supplierDto, @PathVariable int id) {
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(supplierService.updateSupplier(supplierDto, id));
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity deleteSupplier(@PathVariable int id) {
//        supplierService.deleteSupllier(id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Supplier has been delete");
//    }
//
//
//}
