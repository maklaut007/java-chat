package com.api.chat.repository;

import com.api.chat.model.UserChannel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserChannelRepository extends JpaRepository<UserChannel, Long> {
}
