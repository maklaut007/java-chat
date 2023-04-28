package com.api.chat.service;

import com.api.chat.model.Channel;
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

    /**
     * Returns list of channels
     * @return all channels
     */
    public List<Channel> getChannels() {
        return channelRepository.findAll();
    }

    /**
     * @param channelId id of channel we are looking for
     * @return channel with id channelId
     */
    public Channel getChannelById(@PathVariable Long channelId) {
        return channelRepository.findChannelById(channelId);
    }

    /**
     * Adds provided channel to the list of channels
     * @param channelObject body file from request
     * @return created channel
     */
    public Channel createChannel(Channel channelObject) {
        return channelRepository.save(channelObject);
    }

    public List<Channel> findUserChannels(Long userId){
        return channelRepository.findChannelsByUserId(userId);
    }
    // Update channel name
    // Remove channel

}

