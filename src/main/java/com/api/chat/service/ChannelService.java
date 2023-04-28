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

    public List<Channel> getChannels() {
        return channelRepository.findAll();
    }

    public Channel getChannelById(@PathVariable Long channelId) {
        return channelRepository.findChannelById(channelId);
    }

//    public Channel createChannel(Channel channelObject) {
//        return channelRepository.save(channelObject);
//    }
}

