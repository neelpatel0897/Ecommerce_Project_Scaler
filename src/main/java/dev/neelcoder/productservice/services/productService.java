package dev.neelcoder.productservice.services;

import dev.neelcoder.productservice.dtos.GenericProductDto;
import dev.neelcoder.productservice.models.Product;

public interface productService {
    GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);

    
}