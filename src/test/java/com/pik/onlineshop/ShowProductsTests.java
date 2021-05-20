/*package com.pik.onlineshop;

import com.pik.onlineshop.product.Product;
import com.pik.onlineshop.product.ProductController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ShowProductsTests {
    @Test
    @DisplayName("Get products")
    void getProducts() {
        ArrayList<Product> products1 = new ArrayList<>(Arrays.asList(new Product("JBL"),
                new Product("Sony"), new Product("Panasonic")));
        ProductController pCont = new ProductController();
        Assertions.assertEquals(products1, pCont.getProducts());
    }
}*/