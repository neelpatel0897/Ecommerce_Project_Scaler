package dev.neelcoder.productservice.services;

import dev.neelcoder.productservice.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface productService {
    GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductById(Long id);

    GenericProductDto updateProductById(@RequestBody GenericProductDto product,Long id);
}