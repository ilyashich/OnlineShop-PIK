package com.pik.onlineshop.product;

import com.pik.onlineshop.user.User;
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

    public void deleteProduct(Product oldProduct)
    {
        this.productRepository.delete(oldProduct);
    }

    public List<Product> getRecommendations(User user) {
        return this.productRepository.getRecommendations(user.getLogin());
    }

    public List<String> getCategories() {
        return this.productRepository.getCategories();
    }
}

