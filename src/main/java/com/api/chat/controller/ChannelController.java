package com.api.chat.controller;

import com.api.chat.exception.InformationNotFoundException;
import com.api.chat.model.Channel;
import com.api.chat.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/channels")
public class ChannelController {

    //Connecting service to controller
    private ChannelService channelService;
    @Autowired
    public void setChannelService(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping(path = "/")
    public List<Channel> getChannels() {
        return channelService.getChannels();
    }

    @GetMapping(path = "/{channelId}")
    public Channel getChannelById(@PathVariable Long channelId) {
        Channel channel = channelService.getChannelById(channelId);
        if(channel == null){
            throw new InformationNotFoundException("no channel with id "+ channelId + " not found");
        }
        return channelService.getChannelById(channelId);
    }

    @PostMapping(path = "/")
    public Channel createChannel(@RequestBody Channel channel) {
        return channelService.createChannel(channel);
    }

}
