package com.pik.onlineshop.basket;

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
    public List<Basket> getAllBaskets() {
        return basketService.getAllBaskets();
    }

    @GetMapping("/currentbaskets")
    public List<Basket> getCurrentBaskets() {
        return basketService.getCurrentBaskets();
    }

    @GetMapping("/boughtbaskets")
    public List<Basket> getBoughtBaskets() {
        return basketService.getBoughtBaskets();
    }

    @GetMapping("/showbasket")
    public List<Basket> showBasket(@SessionAttribute("User") User user){
        return basketService.showBasket(user);
    }

    @PostMapping("/addtobasket/{productName}")
    public List<Basket> addProduct(@SessionAttribute("User") User user, @PathVariable("productName") String productName){
        return basketService.addProduct(user, productName);
    }

    @DeleteMapping("/deletefrombasket/{productName}")
    public List<Basket> deleteProduct(@SessionAttribute("User") User user, @PathVariable("productName") String productName){
        return basketService.deleteProduct(user, productName);
    }

    @GetMapping("/buy")
    public List<Basket> buyBasket(@SessionAttribute("User") User user){
        return basketService.buyBasket(user);
    }

}
