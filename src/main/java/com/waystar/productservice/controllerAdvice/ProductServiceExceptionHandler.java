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
    public ResponseEntity<ProductNotFoundDto> handleRuntimeException(ProductNotFoundException e){

        ProductNotFoundDto productNotFoundDto = new ProductNotFoundDto();
        productNotFoundDto.setProductId(e.getProductId());
        productNotFoundDto.setMessage(e.getMessage());
        productNotFoundDto.setDetails("are");




        return new ResponseEntity<>(productNotFoundDto,HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException e){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(e.getMessage());
        exceptionDto.setDetails("This is a runtime exception");
        return new ResponseEntity<>(exceptionDto,HttpStatus.INTERNAL_SERVER_ERROR);
}}
