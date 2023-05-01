package com.api.chat.controller;

import com.api.chat.model.request.LoginRequest;
import com.api.chat.model.User;
import com.api.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users/")
class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8888/users/
    @GetMapping(path = "/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    //http://localhost:8888/users/register/
    @PostMapping(path = "/register/")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    //http://localhost:8888/users/login/
    @PostMapping("/login/")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }

}
