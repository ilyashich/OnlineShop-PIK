package com.pik.onlineshop.authentication;

import com.pik.onlineshop.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/")
public class LoginController {
    ArrayList<User> users = new ArrayList<>(Arrays.asList(new User("John", "123"),
            new User("Mark", "admin123"), new User("Adam", "qwerty")));

    @GetMapping("/users")
    public ArrayList<User> getUsers() {
        return users;
    }
}
