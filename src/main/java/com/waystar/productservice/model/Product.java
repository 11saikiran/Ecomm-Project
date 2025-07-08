package com.waystar.productservice.model;

import lombok.Data;

@Data
public class Product extends BaseModel   {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;

}
