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

    // Add access to channel service
    private ChannelService channelService;

    @Autowired
    public void setChannelService(ChannelService channelService) {
        this.channelService = channelService;
    }

    /**
     * Returns list of messages in channel
     *
     * @param channelId id of channel that contains messages
     * @return all messages
     */
    public List<Message> getMessages(Long channelId) {
        return messageRepository.findMessageByChannelId(channelId);
    }

    /**
     * Adds new message to channel
     * @param channelId id of channel that contains messages
     * @return message object
     */
    public Message createMessage(Long channelId, Message message) {
        Channel channel = channelService.getChannelById(channelId);
        if (channel != null) {
            System.out.println(message);
            message.setChannel(channel);
            return messageRepository.save(message);
        } else {
            System.out.println("Error in create message");
            // throw error
        }
        return messageRepository.save(message); // delete later
    }
    // Get message from category by Id
    // Delete message from category by Id
    // Edit message
}
