package com.example.product_service.Service;

import com.example.product_service.Model.Product;
import com.example.product_service.Repo.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product newProduct){
        Product p=productRepo.save(newProduct);
        log.info("new product added");
        return p;
    }
    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

}
