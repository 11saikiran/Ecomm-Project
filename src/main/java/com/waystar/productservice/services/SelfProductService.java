package com.waystar.productservice.services;

import com.waystar.productservice.exceptions.ProductNotFoundException;
import com.waystar.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SelfProductService implements ProductService{

    @Override
    public Product getProduct(Long productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long ProductId) {

    }
}
