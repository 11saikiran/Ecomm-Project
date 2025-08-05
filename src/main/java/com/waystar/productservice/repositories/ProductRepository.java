package com.waystar.productservice.repositories;

import com.waystar.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Product save(Product product);
}
