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

    /**
     * Add selected user to channel with id provided in Url
     * @param channel object of a channel where we add user
     * @param user object a user that we are adding to a channel
     * @return created UserChannel object
     */
    public UserChannel addUserToChannel(Channel channel, User user){
        // !!! Check if user-channel already exists
        UserChannel userChannel = new UserChannel(user, channel);
        return userChannelRepository.save(userChannel);
    }
    /**
     * Add selected channel to user with id provided in Url
     * @param user object of a user that we are adding to a channel
     * @param channel object id of a channel where we add user
     * @return created UserChannel object
     */
    public UserChannel addChannelToUser(User user, Channel channel){
        return addUserToChannel(channel, user);
    }
}
