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
     *
     * @param channelId     id of channel that contains messages
     * @param messageObject object of message from user
     * @return message object
     */
    public Message createMessage(Long channelId, Message messageObject) {
        try {
            if (!userChannelService.checkUserInChannel(UserService.getCurrentLoggedInUser().getId(), channelId))
                throw new InformationNotFoundException("Channel with id " + channelId + " not found");
            Channel channel = channelService.getChannelById(channelId);
            messageObject.setChannel(channel);
            messageObject.setUser(UserService.getCurrentLoggedInUser());
            return messageRepository.save(messageObject);
        } catch (Exception e) {
            throw new InformationNotFoundException("Channel with id " + channelId + " not found");
        }

    }

    /**
     * Update message that user created
     *
     * @param channelId     channel where message is
     * @param messageId     id of the message
     * @param messageObject text of updated message
     * @return updated message
     * @throws InformationNotFoundException if user can't access the message
     */
    public Message updateMessage(Long channelId, Long messageId, Message messageObject) {
        Message message = messageRepository.findById(messageId).get();
        Boolean isUserInChannel = userChannelService.checkUserInChannel(UserService.getCurrentLoggedInUser().getId(), channelId);
        try {
            boolean isCreatedByUser = message.getUser().getId().equals(UserService.getCurrentLoggedInUser().getId());
            if (!isUserInChannel || !isCreatedByUser) {
                throw new InformationNotFoundException("Message with id " + messageId + " not found");
            }
            message.setText(messageObject.getText());
            return messageRepository.save(message);
        } catch (Exception e) {
            throw new InformationNotFoundException("Message with id " + messageId + " not found");
        }
    }

    public Message deleteMessage(Long messageId) {
        Message message = messageRepository.findMessageById(messageId);

        try {
            if (message == null) {
                throw new InformationNotFoundException("Message with id " + messageId + " not found");
            }

            boolean isCreatedByUser = message.getUser().getId().equals(UserService.getCurrentLoggedInUser().getId());
            if (!isCreatedByUser) {
                throw new InformationNotFoundException("Message with id " + messageId + " not found");
            }
            messageRepository.delete(message);
            return message;
        } catch (Exception e) {
            throw new InformationNotFoundException("Message with id " + messageId + " not found");
        }
    }

}
