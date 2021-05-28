package com.pik.onlineshop.basket;

import com.pik.onlineshop.customer.Customer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") //to test with separate frontend project
@RestController
@RequestMapping("/")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/baskets")
    public List<Basket> getProducts() {
        return basketService.getAllBaskets();
    }
}
