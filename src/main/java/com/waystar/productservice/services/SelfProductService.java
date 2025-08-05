package com.waystar.productservice.services;

import com.waystar.productservice.exceptions.CategoryNotFoundException;
import com.waystar.productservice.exceptions.ProductNotFoundException;
import com.waystar.productservice.model.Category;
import com.waystar.productservice.model.Product;
import com.waystar.productservice.repositories.CategoryRepository;
import com.waystar.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProduct(Long productId) throws ProductNotFoundException {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId,"Product with ID " + productId + " not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException {

        Category category = product.getCategory();
        if (product.getCategory() == null) {
            throw new CategoryNotFoundException("Category not found for product creation");
        }
        Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());
        if (optionalCategory.isEmpty()){
            category = categoryRepository.save(category);

        }
        else{
            category = optionalCategory.get();
        }
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long ProductId) {

    }
}
