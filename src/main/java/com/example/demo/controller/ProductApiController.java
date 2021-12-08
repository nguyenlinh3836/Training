package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.BaseResponse;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductApiController {
    @Autowired
    ProductService productService;

    @GetMapping
    public BaseResponse listProduct(){
        BaseResponse res = new BaseResponse();
        res.data = productService.listAllProduct();
        return res;
    }
    @PostMapping
    public BaseResponse insertProduct(@RequestBody Product product){
        BaseResponse res = new BaseResponse();
        res.data = productService.insertProduct(product);
        return res;
    }

    @PutMapping(value = "{id}")
    public BaseResponse updateProduct(@RequestBody ProductDto productDto, @PathVariable int id){
        BaseResponse res = new BaseResponse();
        Product product = new Product();
        product.setProduct_id(id);
        product.setProduct_name(productDto.getProduct_name());
        res.data = productService.updateProduct(product);
        return res;
    }
    @DeleteMapping( value = "{id}")
    public BaseResponse deleteProduct(@PathVariable int id){
        BaseResponse res = new BaseResponse();
        productService.delete(id);
        res.data = "Product has been deleted";
        return res;
    }
}
