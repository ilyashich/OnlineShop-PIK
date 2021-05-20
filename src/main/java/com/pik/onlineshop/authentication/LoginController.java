package com.pik.onlineshop.authentication;

import com.pik.onlineshop.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@CrossOrigin(origins = "http://localhost:3000") //to test with separate frontend project
@RestController
@RequestMapping("/")
public class LoginController {

    ArrayList<User> users = new ArrayList<>(Arrays.asList(new User("John", "123"),
            new User("Mark", "admin123"), new User("Adam", "qwerty")));


    @GetMapping("/users")
    public ArrayList<User> getUsers() {
        LoginJDBC loginJDBC = new LoginJDBC();
        loginJDBC.init();
        return loginJDBC.getUsers();
    }

    @GetMapping("/users/{login}/{password}")
    public User getUserByLoginAndPassword(@PathVariable("login") String login, @PathVariable("password") String password) {
        LoginJDBC loginJDBC = new LoginJDBC();
        loginJDBC.init();
        for (User user: users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

//    @GetMapping(path = "/basicauth")
//    public AuthenticationBean authenticate() {
//        //throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
//        return new AuthenticationBean("You are authenticated");
//    }
}
