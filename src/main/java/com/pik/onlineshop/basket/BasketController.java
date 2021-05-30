package com.pik.onlineshop.basket;

import com.pik.onlineshop.customer.Customer;
import com.pik.onlineshop.user.User;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showbasket")
    public Basket showBasket(@SessionAttribute("User") User user){
        return basketService.showBasket(user);
    }

    @GetMapping("/addtobasket")
    public Basket addProduct(@SessionAttribute("User") User user, String productName){
        return basketService.addProduct(user, productName);
    }

    @GetMapping("/deletefrombasket")
    public Basket deleteProduct(@SessionAttribute("User") User user, String productName){
        return basketService.deleteProduct(user, productName);
    }

}
