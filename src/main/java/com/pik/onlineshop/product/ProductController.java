package com.pik.onlineshop.product;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") //to test with separate frontend project
@RestController
@RequestMapping("/")
public class ProductController {
    private final ProductService productService;
    ArrayList<Product> products = new ArrayList<>(Arrays.asList(new Product("JBL"),
            new Product("Sony"), new Product("Panasonic")));


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        //return products;
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public boolean addProduct(@RequestBody Product newProduct) {
        productService.add(newProduct);
        return true;
    }
}