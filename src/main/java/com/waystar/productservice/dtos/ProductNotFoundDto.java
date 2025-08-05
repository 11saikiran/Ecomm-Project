package com.waystar.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundDto {
    private Long productId;
    private String message;
    private String details;
}
