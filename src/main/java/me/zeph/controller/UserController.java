package me.zeph.controller;

import me.zeph.model.User;
import me.zeph.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{phoneNumber}", method = GET, produces = APPLICATION_JSON_VALUE)
    public User findUserByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return userService.findUserByPhoneNumber(phoneNumber);
    }

    @RequestMapping(value = "/user", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity(CREATED);
    }
}
