package com.api.chat.service;

import com.api.chat.model.Channel;
import com.api.chat.model.User;
import com.api.chat.model.UserChannel;
import com.api.chat.repository.UserChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserChannelService {

    UserChannelRepository userChannelRepository;
    @Autowired
    public void setUserChannelRepository(UserChannelRepository userChannelRepository) {
        this.userChannelRepository = userChannelRepository;
    }

    ChannelService channelService;
    @Autowired
    public void setChannelService(ChannelService channelService) {
        this.channelService = channelService;
    }

    /**
     * Add selected user to channel with id provided in Url
     * @param channelId id of a channel where we add user
     * @param user userObject of user that we are adding to a channel
     * @return created UserChannel object
     */
    public UserChannel addUserToChannel(Long channelId, User user){
        // Getting channel object
        Channel channel = channelService.getChannelById(channelId);
        //Creating object to add into repository
        UserChannel userChannel = new UserChannel(user, channel);
        return userChannelRepository.save(userChannel);
    }
}
