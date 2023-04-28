package com.api.chat.service;

import com.api.chat.model.Channel;
import com.api.chat.model.Message;
import com.api.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    // Connect repository to service
    private MessageRepository messageRepository;
    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    // Get all messages from category
    /**
     * Returns list of messages
     * @param channelId id of channel that contains messages
     * @return all messages
     */
    public List<Message> getMessages(Long channelId) {
        return messageRepository.findMessageByChannelId(channelId);
    }
    // Get message from category by Id
    // Delete message from category by Id
    // Edit message
}
