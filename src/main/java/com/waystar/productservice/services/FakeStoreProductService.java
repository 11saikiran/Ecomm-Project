package com.waystar.productservice.services;

import com.waystar.productservice.dtos.FakeStoreProductDto;
import com.waystar.productservice.exceptions.ProductNotFoundException;
import com.waystar.productservice.model.Category;
import com.waystar.productservice.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor

public class FakeStoreProductService implements  ProductService{
    RestTemplate restTemplate;
    @Override
    public Product getProduct(Long productId) throws ProductNotFoundException {

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity  = restTemplate.getForEntity
                                                            ("https://fakestoreapi.com/products/"+productId,FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();
        if (fakeStoreProductDto ==null){
            throw new ProductNotFoundException(productId, "Product with ID " + productId + " not found");
        }
          return convertFakeStoreProducctDtoToProduct(fakeStoreProductDto);

    }

    @Override
    public List<Product> getAllProducts() {

        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponseEntity  = restTemplate.getForEntity
                                                                ("https://fakestoreapi.com/products",FakeStoreProductDto[].class);

        FakeStoreProductDto[] fakeStoreProductDtos = fakeStoreProductDtoResponseEntity.getBody();
        List<Product> productlist = new ArrayList<>();
        if (fakeStoreProductDtos != null){
            for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos ){
                productlist.add(convertFakeStoreProducctDtoToProduct(fakeStoreProductDto));
            }
        }
        return productlist;


    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long ProductId) {

    }

    public Product convertFakeStoreProducctDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        if(fakeStoreProductDto==null){
            return null;
        }
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
