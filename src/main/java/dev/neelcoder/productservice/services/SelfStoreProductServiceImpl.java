package dev.neelcoder.productservice.services;

import org.springframework.stereotype.Service;

import dev.neelcoder.productservice.dtos.GenericProductDto;
import dev.neelcoder.productservice.models.Product;

@Service("SelfStoreProductServiceImpl")
public class SelfStoreProductServiceImpl implements productService {
    @Override
    public GenericProductDto getProductById(Long id){
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product){
        return null;
    }
}