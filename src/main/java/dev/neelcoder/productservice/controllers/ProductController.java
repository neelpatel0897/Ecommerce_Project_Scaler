package dev.neelcoder.productservice.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.neelcoder.productservice.dtos.GenericProductDto;
import dev.neelcoder.productservice.services.productService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //@Autowired not recommended
    //Field Injection
    private productService productService;

    //@Autowired (no need no write a keyWord Autowired)
    //this method is recommended
    public ProductController(@Qualifier("FakeStroreProductService")productService productService){
        this.productService=productService;
    }
    //Hello All

    //Setter injection
    //@Autowired
    /* public void setProductService(productService productService){
        this.productService=productService;
    }  this is also not recommended*/
   


    //GET/products
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    //localhost:8080/products/{id}
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id")Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        return productService.createProduct(product);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id")Long id){
        return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public void updateProductById(@PathVariable("id")Long id){

    }
}