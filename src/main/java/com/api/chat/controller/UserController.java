package com.api.chat.controller;


import com.api.chat.model.User;
import com.api.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
class UserController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(path = "/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
