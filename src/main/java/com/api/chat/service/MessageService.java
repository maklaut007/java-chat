package com.api.chat.service;

import com.api.chat.exception.InformationNotFoundException;
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
    // Add access to UserChannel service
    private UserChannelService userChannelService;

    @Autowired
    public void setUserChannelService(UserChannelService userChannelService) {
        this.userChannelService = userChannelService;
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
        // if chanel doesn't exist for current user
        if (!userChannelService.checkUserInChannel(UserService.getCurrentLoggedInUser().getId(), channelId))
            throw new InformationNotFoundException("Channel with id " + channelId + " not found");
        return messageRepository.findMessageByChannelId(channelId);
    }

    /**
     * Adds new message to channel
     * @param channelId id of channel that contains messages
     * @param messageObject object of message from user
     * @return message object
     */
    public Message createMessage(Long channelId, Message messageObject) {
        if (!userChannelService.checkUserInChannel(UserService.getCurrentLoggedInUser().getId(), channelId))
            throw new InformationNotFoundException("Channel with id " + channelId + " not found");
        Channel channel = channelService.getChannelById(channelId);
        messageObject.setChannel(channel);
        messageObject.setUser(UserService.getCurrentLoggedInUser());
        return messageRepository.save(messageObject);
    }
    // Get message from category by Id
    // Delete message from category by Id
    // Edit message
}
