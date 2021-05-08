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
        return users;
    }

    @GetMapping("/users/{login}/{password}")
    public User getUserByLoginAndPassword(@PathVariable("login") String login, @PathVariable("password") String password) {
        for (User user: users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
