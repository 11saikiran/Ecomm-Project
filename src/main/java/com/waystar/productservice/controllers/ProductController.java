package com.waystar.productservice.controllers;


import com.waystar.productservice.model.Product;
import com.waystar.productservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long productId) {
        return productService.getProduct(productId);
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
