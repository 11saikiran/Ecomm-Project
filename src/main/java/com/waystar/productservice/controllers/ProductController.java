package com.waystar.productservice.controllers;


import com.waystar.productservice.exceptions.ProductNotFoundException;
import com.waystar.productservice.model.Product;
import com.waystar.productservice.services.ProductService;
import com.waystar.productservice.services.SelfProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    public ProductController(@Qualifier("SelfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {

        ResponseEntity<Product> responseEntity = new ResponseEntity<>
                                                    (productService.getProduct(productId), HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/")
    public List<Product> getAllProducts(){

        return  productService.getAllProducts();

    }
    @PostMapping("/create")
    public  Product createProduct(@RequestBody Product product) {
        return  new Product();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId){
        return null;
    }
}
