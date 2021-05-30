package com.pik.onlineshop.basket;

import com.pik.onlineshop.customer.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.pik.onlineshop.user.User;

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

    public Basket showBasket(User user) {
        return this.basketRepository.showBasket(user.getLogin());
    }
}
