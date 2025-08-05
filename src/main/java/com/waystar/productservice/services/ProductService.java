package com.waystar.productservice.services;

import com.waystar.productservice.exceptions.CategoryNotFoundException;
import com.waystar.productservice.exceptions.ProductNotFoundException;
import com.waystar.productservice.model.Product;
import lombok.Data;

import java.util.List;

public interface ProductService {
    Product getProduct(Long productId) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product) throws CategoryNotFoundException;

    void deleteProduct(Long ProductId);
}
