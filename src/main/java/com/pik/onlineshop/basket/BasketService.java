package com.pik.onlineshop.basket;

import com.pik.onlineshop.customer.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public List<Basket> getAllBaskets() {
        return this.basketRepository.findAll();
    }
}
