package com.api.chat.service;

import com.api.chat.exception.InformationExistException;
import com.api.chat.exception.InformationForbidenException;
import com.api.chat.exception.InformationNotFoundException;
import com.api.chat.model.Channel;
import com.api.chat.model.User;
import com.api.chat.model.UserChannel;
import com.api.chat.repository.ChannelRepository;
import com.api.chat.repository.UserChannelRepository;
import com.api.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserChannelService {

    UserChannelRepository userChannelRepository;
    @Autowired
    public void setUserChannelRepository(UserChannelRepository userChannelRepository) {
        this.userChannelRepository = userChannelRepository;
    }

    UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    ChannelRepository channelRepository;
    @Autowired
    public void setChannelRepository(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    /**
     * Add selected user to channel
     * @param channelId id of a channel where we add user
     * @param userId id a user that we are adding to a channel
     * @return created UserChannel object
     * @throws InformationExistException if user aredy exists in current channel
     */
    public UserChannel addUserToChannel(Long channelId, Long userId){
        UserChannel userChannel = userChannelRepository.findUserChannelByUserIdAndChannelId(userId, channelId);
        if(userChannel != null){
            throw new InformationExistException("User with id " + userId + " is alredy exist in channel " + channelId);
        }
        userChannel = new UserChannel(userRepository.findUserById(userId),channelRepository.findChannelById(channelId));
        System.out.println("______________" + userChannel);
        return userChannelRepository.save(userChannel);
    }
}
