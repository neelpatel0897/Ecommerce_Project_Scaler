package dev.neelcoder.productservice.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.neelcoder.productservice.dtos.FakeStoreProductDto;
import dev.neelcoder.productservice.dtos.GenericProductDto;
import dev.neelcoder.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service("FakeStroreProductService")
public class FakeStroreProductService implements productService {
    
    // RestTemplate is the library which allowes you to call third party API and get a data and work on it
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestURL="https://fakestoreapi.com/products/{id}";
    private String createProductRequestURL="https://fakestoreapi.com/products";
    /**
     *
     */
    public FakeStroreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }


    @Override
    public GenericProductDto getProductById(Long id){
        RestTemplate restTemplate=restTemplateBuilder.build(); 
        ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity(getProductRequestURL, FakeStoreProductDto.class,id);
        //response.getStatusCode()
        
        FakeStoreProductDto fakeStoreProductDto= response.getBody();

        GenericProductDto product=new GenericProductDto();

        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setId(id);

        return product;

        


    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product){
            RestTemplate restTemplate=restTemplateBuilder.build();
            ResponseEntity<GenericProductDto> respose=restTemplate.postForEntity(createProductRequestURL,product,GenericProductDto.class);
            return respose.getBody();
    }


}