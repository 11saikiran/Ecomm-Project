package com.waystar.productservice.dtos;

import com.waystar.productservice.model.Category;
import lombok.Data;

@Data
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;

}
