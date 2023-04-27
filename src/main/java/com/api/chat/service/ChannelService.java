package com.api.chat.service;

import com.api.chat.repository.ChannelRepository;
import org.springframework.stereotype.Service;

@Service
public class ChannelService {
    private ChannelRepository channelRepository;

    public void setChannelRepository(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }
}
