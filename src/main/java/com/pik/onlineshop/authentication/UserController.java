package com.pik.onlineshop.authentication;

import com.pik.onlineshop.customer.CustomerRepository;
import com.pik.onlineshop.user.User;
import org.springframework.web.bind.annotation.*;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;

@CrossOrigin(origins = "http://localhost:3000") //to test with separate frontend project
@RestController
@SessionAttributes("User")
@RequestMapping("/")
public class UserController {
    UserRepository userRepository = new UserRepository();
    private final CustomerRepository customerRepository;
    ArrayList<User> users = new ArrayList<>(Arrays.asList(new User("John", "123"),
            new User("Mark", "admin123"), new User("Adam", "qwerty")));

    UserController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @ModelAttribute("User")
    public User setSessionUser() {
        return new User();
    }

    @GetMapping("/users")
    public ArrayList<User> getUsers() {
        return userRepository.getUsers();
    }

    @GetMapping("/users/{login}/{password}")
    public User getUserByLoginAndPassword(@PathVariable("login") String login, @PathVariable("password") String password) {
        for (User user: userRepository.getUsers()) {
            if (user.getLogin().equals(login) && userRepository.getEncoder().matches(password, user.getPassword())) {
                user.setPassword(password);

                // zapisanie loginu w sesji
                // user.getLogin();
                return user;
            }
        }
        return null;
    }

    @GetMapping("/sessiontest/{login}/{password}")
    public User setSessionUser(@PathVariable("login") String login, @PathVariable("password") String password,
                            @ModelAttribute("User") User sessionUser, final Model model) {
        for (User user: userRepository.getUsers()) {
            if (user.getLogin().equals(login) && userRepository.getEncoder().matches(password, user.getPassword())) {
                user.setPassword(password);

                // zapisanie loginu w sesji
                model.addAttribute("User", user);
            }
        }
        return null; // zwracanie czegoś innego niż null daje błąd
    }

    @GetMapping("/sessiontest")
    public User getSessionUser(@ModelAttribute("User") User sessionUser) {
        return sessionUser;
    }

    @PostMapping("/users")
    public boolean addUser(@RequestBody User newUser) {
        if (getUserByLogin(newUser.getLogin()) == null) {
            userRepository.addUser(newUser);
            //add customer to Neo4j
            customerRepository.addCustomer(newUser.getLogin());
            return true;
        }
        return false;
    }

    @GetMapping("/users/{login}")
    public User getUserByLogin(@PathVariable("login") String login) {
        for (User user: userRepository.getUsers()) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
