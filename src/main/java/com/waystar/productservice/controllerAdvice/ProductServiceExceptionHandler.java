package com.waystar.productservice.controllerAdvice;

import com.waystar.productservice.dtos.ExceptionDto;
import com.waystar.productservice.dtos.ProductNotFoundDto;
import com.waystar.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundDto> handleRuntimeException(){
        ProductNotFoundDto productNotFoundDto = new ProductNotFoundDto();
        productNotFoundDto.setProductId(1);
        productNotFoundDto.setMessage("we");
        productNotFoundDto.setDetails("are");




        return new ResponseEntity<>(productNotFoundDto,HttpStatus.NOT_FOUND);

    }
}
