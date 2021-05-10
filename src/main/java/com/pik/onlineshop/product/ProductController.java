package com.pik.onlineshop.product;

import com.pik.onlineshop.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@CrossOrigin(origins = "http://localhost:3000") //to test with separate frontend project
@RestController
@RequestMapping("/")
public class ProductController {
    ArrayList<Product> products = new ArrayList<>(Arrays.asList(new Product("JBL"),
            new Product("Sony"), new Product("Panasonic")));

    @GetMapping("/products")
    public ArrayList<Product> getProducts() {
        return products;
    }
}