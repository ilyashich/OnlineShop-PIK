package com.pik.onlineshop.product;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") //to test with separate frontend project
@RestController
@RequestMapping("/")
public class ProductController {
    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    ArrayList<Product> products = new ArrayList<>(Arrays.asList(new Product("JBL"),
            new Product("Sony"), new Product("Panasonic")));

    @GetMapping("/products")
    public List<Product> getProducts() {
        //return products;
        return productService.getAllProducts();
    }
}