package com.api.chat.service;

import com.api.chat.exception.InformationExistException;
import com.api.chat.exception.InformationNotFoundException;
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
     *
     * @param channelId id of a channel where we add user
     * @param userId    id a user that we are adding to a channel
     * @return created UserChannel object
     * @throws InformationExistException if user aredy exists in current channel
     */
    public UserChannel addUserToChannel(Long channelId, Long userId) {

        if (checkUserInChannel(userId, channelId)) {
            throw new InformationExistException("User with id " + userId + " is already exist in channel " + channelId);
        }
        UserChannel userChannel = new UserChannel(userRepository.findUserById(userId), channelRepository.findChannelById(channelId));
        return userChannelRepository.save(userChannel);
    }

    /**
     * Checks in user is a member of a channel
     * @param userId user to check
     * @param channelId channel to check
     * @return true if user in the channel, false in not
     */
    public Boolean checkUserInChannel(Long userId, Long channelId) {
        UserChannel userChannel = userChannelRepository.findUserChannelByUserIdAndChannelId(userId, channelId);
        if (userChannel == null) {
            return false;
        } else return true;
    }

    public UserChannel deleteUserFromChannel(Long channelId) {
        UserChannel userChannel = userChannelRepository.findUserChannelByUserIdAndChannelId(UserService.getCurrentLoggedInUser().getId(), channelId);
        if(userChannel==null){
            throw new InformationNotFoundException("User with id " + UserService.getCurrentLoggedInUser().getId() + " is not connected to channel" + channelId);
        }
        userChannelRepository.delete(userChannel);
        return userChannel;
    }
}
