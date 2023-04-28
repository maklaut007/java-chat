package com.api.chat.service;

import com.api.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    // Get all messages from category
    // Get message from category by Id
    // Delete message from category by Id
    // Edit message
}
