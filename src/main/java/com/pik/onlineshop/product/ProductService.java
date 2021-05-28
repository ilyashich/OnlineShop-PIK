package com.pik.onlineshop.product;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product addProduct(Product newProduct) {
        return this.productRepository.save(newProduct);
    }

    public List<Product> getProductsInCategory(String category) {
        return this.productRepository.findInCategory(category);
    }
}

