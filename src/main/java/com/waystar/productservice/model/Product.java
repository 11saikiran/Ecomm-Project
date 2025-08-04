package com.waystar.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel   {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    @ManyToOne
    private Category category;

}
