package dev.neelcoder.productservice.services;

import dev.neelcoder.productservice.dtos.GenericProductDto;

import java.util.List;

public interface productService {
    GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductById(Long id);
}