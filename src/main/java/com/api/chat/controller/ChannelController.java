package com.api.chat.controller;

import com.api.chat.model.Channel;
import com.api.chat.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ChannelController {
    private ChannelService channelService;
    //Connecting service to controller
    @Autowired
    public void setChannelService(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping(path = "/channel")
    public List<Channel> getChannels() {
        return channelService.getChannels();
    }

    @PostMapping(path = "/channel")
    public Channel createChannel(@RequestBody Channel channel) {
        return channelService.createChannel(channel);
    }

}
