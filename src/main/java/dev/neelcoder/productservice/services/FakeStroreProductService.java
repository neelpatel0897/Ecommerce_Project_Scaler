package dev.neelcoder.productservice.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import dev.neelcoder.productservice.dtos.FakeStoreProductDto;
import dev.neelcoder.productservice.dtos.GenericProductDto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
@Setter
@Service("FakeStroreProductService")
public class FakeStroreProductService implements productService {
    
    // RestTemplate is the library which allowes you to call third party API and get a data and work on it
    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestURL="https://fakestoreapi.com/products/{id}";
    private String productsRequestBaseURL="https://fakestoreapi.com/products";
    /**
     *
     *
     */
    public FakeStroreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
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
    public GenericProductDto getProductById(Long id){
        RestTemplate restTemplate=restTemplateBuilder.build(); 
        ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity(specificProductRequestURL, FakeStoreProductDto.class,id);
        //response.getStatusCode()
        
        FakeStoreProductDto fakeStoreProductDto= response.getBody();



        return convertFakeStroreProductintoGenericProduct(fakeStoreProductDto);

        


    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product){
            RestTemplate restTemplate=restTemplateBuilder.build();
            ResponseEntity<GenericProductDto> respose=restTemplate.postForEntity(productsRequestBaseURL,product,GenericProductDto.class);
            return respose.getBody();
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> response=restTemplate.getForEntity(productsRequestBaseURL,FakeStoreProductDto[].class);

        List<GenericProductDto> answer=new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto: Arrays.stream(response.getBody()).toList()){

            answer.add(convertFakeStroreProductintoGenericProduct(fakeStoreProductDto));
        }

        return answer;
    }

    @Override
    public GenericProductDto deleteProductById(Long id){
        RestTemplate restTemplate=restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> response= restTemplate.execute(specificProductRequestURL, HttpMethod.DELETE, requestCallback, responseExtractor, id);


        FakeStoreProductDto fakeStoreProductDto= response.getBody();



        return convertFakeStroreProductintoGenericProduct(fakeStoreProductDto);
        }
}