package com.pik.onlineshop.product;

import com.pik.onlineshop.user.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") //to test with separate frontend project
@RestController
@RequestMapping("/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product newProduct) {
        return productService.addProduct(newProduct);
    }

    @GetMapping("/products/{category}")
    public List<Product> getProductsInCategory(@PathVariable("category") String category) {
        return productService.getProductsInCategory(category);
    }

    @DeleteMapping("/products")
    public void deleteProduct(@RequestBody Product oldProduct)
    {
        productService.deleteProduct(oldProduct);
    }

    @GetMapping("/recommendations")
    public List<Product> getRecommendations(@SessionAttribute("User") User user) {
        return productService.getRecommendations(user);
    }
}

