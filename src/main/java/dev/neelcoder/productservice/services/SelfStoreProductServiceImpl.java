package dev.neelcoder.productservice.services;

import org.springframework.stereotype.Service;

import dev.neelcoder.productservice.dtos.GenericProductDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto product,Long id) {
        return null;
    }
}