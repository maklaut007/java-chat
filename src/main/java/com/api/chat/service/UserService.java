package com.api.chat.service;

import com.api.chat.model.Channel;
import com.api.chat.model.User;
import com.api.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long user) {
        return userRepository.findById(user).get();
    }

    public User createUser(User user) { // !!! check if already exists
        return userRepository.save(user);
    }
}
