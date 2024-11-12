package com.example.product_service.Controller;

import com.example.product_service.Model.Product;
import com.example.product_service.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product newProduct){
        return productService.addProduct(newProduct);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    //acting timeout for circuit breaker
    @GetMapping("/sleep")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct2(){
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return productService.getAllProduct();
    }
}
