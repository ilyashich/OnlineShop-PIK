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

    public List<Basket> getCurrentBaskets() {
        return this.basketRepository.findAllCurrent();
    }

    public List<Basket> getBoughtBaskets() {
        return this.basketRepository.findAllBought();
    }

    public List<Basket> showBasket(User user) {
        return this.basketRepository.showBasket(user.getLogin());
    }

    public List<Basket> addProduct(User user, String productName){
        return this.basketRepository.addProduct(user.getLogin(), productName);
    }

    public List<Basket> deleteProduct(User user, String productName){
        return this.basketRepository.deleteProduct(user.getLogin(), productName);
    }

    public List<Basket> buyBasket(User user) {
        return this.basketRepository.buyBasket(user.getLogin());
    }

}
