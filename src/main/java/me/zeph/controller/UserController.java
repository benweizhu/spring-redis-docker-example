package me.zeph.controller;

import me.zeph.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping(value = "/user/{id}")
    public User findUserById(@PathVariable("id") String id) {
        return new User("1234567890");
    }
}
