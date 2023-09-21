package dev.neelcoder.productservice.services;

import dev.neelcoder.productservice.exceptions.NotFoundException;
import dev.neelcoder.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dev.neelcoder.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import dev.neelcoder.productservice.dtos.GenericProductDto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Primary
@Service("FakeStroreProductService")
public class FakeStroreProductService implements productService {
    
    FakeStoreProductServiceClient fakeStoreProductServiceClient;
    /**
     *
     *
     */
    public FakeStroreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient =fakeStoreProductServiceClient;
    }

    private GenericProductDto convertFakeStroreProductintoGenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product=new GenericProductDto();

        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setId(fakeStoreProductDto.getId());

        return product;

    }



    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {

        return convertFakeStroreProductintoGenericProduct(fakeStoreProductServiceClient.getProductById(id));

    }


    public GenericProductDto createProduct(GenericProductDto product){

        return convertFakeStroreProductintoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        List<FakeStoreProductDto> fakeStoreProductDtoList= fakeStoreProductServiceClient.getAllProducts();

        List<GenericProductDto> genericProductDtoList=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtoList){
            genericProductDtoList.add(convertFakeStroreProductintoGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtoList;
    }

    @Override
    public GenericProductDto deleteProductById(Long id){

        return convertFakeStroreProductintoGenericProduct(fakeStoreProductServiceClient.deleteProductById(id));
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto product,Long id) {
       return convertFakeStroreProductintoGenericProduct(fakeStoreProductServiceClient.updateProductById(product, id));
    }
}