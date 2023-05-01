package com.api.chat.repository;

import com.api.chat.model.Channel;
import com.api.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findMessageByChannelId(Long channelId);
    Message findMessageById(Long messageId);
}
