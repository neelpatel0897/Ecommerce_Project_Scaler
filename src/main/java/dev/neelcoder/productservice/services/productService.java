package dev.neelcoder.productservice.services;

import dev.neelcoder.productservice.dtos.GenericProductDto;
import dev.neelcoder.productservice.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface productService {
    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductById(Long id);

    GenericProductDto updateProductById(@RequestBody GenericProductDto product,Long id);
}