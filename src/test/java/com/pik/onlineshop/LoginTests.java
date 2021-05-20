package com.pik.onlineshop;

import com.pik.onlineshop.authentication.LoginController;
import com.pik.onlineshop.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LoginTests {

    @Test
    @DisplayName("Get user by login and password")
    void getUserByLoginAndPassword() {
        User user1 = new User("Adam", "qwerty");
        LoginController logCont = new LoginController();
        User user2 = logCont.getUserByLoginAndPassword("Adam", "qwerty");
        Assertions.assertEquals(user1.getLogin(), user2.getLogin());
        Assertions.assertEquals(user1.getPassword(), user2.getPassword());
    }

    @Test
    @DisplayName("Get nonexistent user by login and password")
    void getNonexistentUserByLoginAndPassword() {
        LoginController logCont = new LoginController();
        User user = logCont.getUserByLoginAndPassword("Malcolm", "qwerty");
        Assertions.assertNull(user);
    }

    @Test
    @DisplayName("Set login and password")
    void setLoginAndPassword() {
        User user = new User();
        user.setLogin("Adam");
        user.setPassword("qwerty");
        Assertions.assertEquals(user.getLogin(), "Adam");
        Assertions.assertEquals(user.getPassword(), "qwerty");
    }
}
