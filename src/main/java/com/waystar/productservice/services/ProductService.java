package com.waystar.productservice.services;

import com.waystar.productservice.model.Product;
import lombok.Data;

import java.util.List;

public interface ProductService {
    Product getProduct(Long productId);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    void deleteProduct(Long ProductId);
}
