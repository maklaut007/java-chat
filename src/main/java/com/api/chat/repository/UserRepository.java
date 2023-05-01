package com.api.chat.repository;

import com.api.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

    User findUserById(Long userId);
}
