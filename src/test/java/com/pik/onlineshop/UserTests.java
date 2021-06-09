package com.pik.onlineshop;

import com.pik.onlineshop.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserTests {

//    @Test
//    @DisplayName("Get user by login and password")
//    void getUserByLoginAndPassword() {
//        User user1 = new User("Adam", "qwerty");
//        UserController logCont = new UserController();
//        User user2 = logCont.getUserByLoginAndPassword("Adam", "qwerty");
//        Assertions.assertEquals(user1, user2);
//    }
//
//    @Test
//    @DisplayName("Get nonexistent user by login and password")
//    void getNonexistentUserByLoginAndPassword() {
//        UserController logCont = new UserController();
//        User user = logCont.getUserByLoginAndPassword("Dave", "qwerty123");
//        Assertions.assertNull(user);
//    }

    @Test
    @DisplayName("Set login and password")
    void setLoginAndPassword() {
        User user = new User();
        user.setLogin("Adam");
        user.setPassword("qwerty");
        Assertions.assertEquals(user.getLogin(), "Adam");
        Assertions.assertEquals(user.getPassword(), "qwerty");
    }

//    @Test
//    @DisplayName("Add user")
//    void addUser() {
//        ArrayList<User> users = new ArrayList<>(Arrays.asList(new User("John", "123"),
//                new User("Malcolm", "qwerty"), new User("Adam", "qwerty"),
//                new User("Dave", "passwd")));
//        UserController logCont = new UserController();
//        logCont.addUser(new User("Dave", "passwd"));
//        Assertions.assertEquals(users, logCont.getUsers());
//    }
}