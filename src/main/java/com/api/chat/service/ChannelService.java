package com.api.chat.service;

import com.api.chat.exception.InformationNotFoundException;
import com.api.chat.model.Channel;
import com.api.chat.model.UserChannel;
import com.api.chat.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ChannelService {
    private ChannelRepository channelRepository;

    @Autowired
    public void setChannelRepository(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    private UserChannelService userChannelService;

    @Autowired
    public void setUserChannelService(UserChannelService userChannelService) {
        this.userChannelService = userChannelService;
    }

    /**
     * Returns list of channels that are belong to current user
     *
     * @return all channels
     */
    public List<Channel> getChannels() {
        return channelRepository.findChannelsByUserId(UserService.getCurrentLoggedInUser().getId());
    }

    /**
     * Returns channel by id if user is in this channel
     *
     * @param channelId id of channel we are looking for
     * @return channel with id channelId
     */
    public Channel getChannelById(@PathVariable Long channelId) {
        Channel channel = channelRepository.findChannelByIdAndUserId(channelId, UserService.getCurrentLoggedInUser().getId());
        if (channel == null)
            throw new InformationNotFoundException("Channel with id " + channelId + " not found");
        return channel;
    }

    /**
     * Adds provided channel to the list of channels
     * @param channelObject body file from request
     * @return created channel
     */
    public Channel createChannel(Channel channelObject) {
        Channel channel = channelRepository.save(channelObject);
        userChannelService.addUserToChannel(channel.getId(), UserService.getCurrentLoggedInUser().getId());
        return channel;
    }

    /**
     * Adds user to new channel. Works only if Current user in this channel
     * @param channelId channel if where to add user
     * @param userId id of user to add
     * @return
     */
    public UserChannel addUserToChannel(Long channelId, Long userId) {
        return userChannelService.addUserToChannel(channelId, userId);
    }
    // Update channel name
    // Remove channel

}

