package com.pik.onlineshop.authentication;

import com.pik.onlineshop.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@CrossOrigin(origins = "http://localhost:3000") //to test with separate frontend project
@RestController
@RequestMapping("/")
public class UserController {
    LoginJDBC loginJDBC = new LoginJDBC();
    ArrayList<User> users = new ArrayList<>(Arrays.asList(new User("John", "123"),
            new User("Mark", "admin123"), new User("Adam", "qwerty")));


    @GetMapping("/users")
    public ArrayList<User> getUsers() {
        return loginJDBC.getUsers();
    }

    @GetMapping("/users/{login}/{password}")
    public User getUserByLoginAndPassword(@PathVariable("login") String login, @PathVariable("password") String password) {
        for (User user: loginJDBC.getUsers()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                //loginJDBC.addUser(new User("Malcolm2", "qwertyu"));
                //loginJDBC.removeUser(new User("Malcolm2", "qwertyu"));
                return user;
            }
        }
        return null;
    }

    @PostMapping("/users")
    public boolean addUser(@RequestBody User newUser) {
        if (getUserByLogin(newUser.getLogin()) == null) {
            loginJDBC.addUser(newUser);
            return true;
        }
        return false;
    }

//    @GetMapping("/users/{login}/{password}")
//    public User getUserByLoginAndPassword(@PathVariable("login") String login, @PathVariable("password") String password) {
//        for (User user: users) {
//            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
//                return user;
//            }
//        }
//        return null;
//    }

    @GetMapping("/users/{login}")
    public User getUserByLogin(@PathVariable("login") String login) {
        for (User user: loginJDBC.getUsers()) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

}
