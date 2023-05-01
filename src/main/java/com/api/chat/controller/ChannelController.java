package com.api.chat.controller;

import com.api.chat.model.Channel;
import com.api.chat.model.UserChannel;
import com.api.chat.service.ChannelService;
import com.api.chat.service.UserChannelService;
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

    private UserChannelService userChannelService;

    @Autowired
    public void setUserChannelService(UserChannelService userChannelService) {
        this.userChannelService = userChannelService;
    }

    @GetMapping(path = "/")
    public List<Channel> getChannels() {
        return channelService.getChannels();
    }

    @GetMapping(path = "/{channelId}/")
    public Channel getChannelById(@PathVariable Long channelId) {
        return channelService.getChannelById(channelId);
    }

    @PostMapping(path = "/")
    public Channel createChannel(@RequestBody Channel channel) {
        return channelService.createChannel(channel);
    }

    @PostMapping(path = "/{channelId}/user/{userId}")
    public UserChannel addUserToChannel(@PathVariable Long channelId, @PathVariable Long userId) {
        return channelService.addUserToChannel(channelId, userId);
    }
    @PutMapping(path = "/{channelId}")
    public Channel updateChannel(@PathVariable Long channelId, @RequestBody Channel channel) {
        return channelService.updateChannel(channelId, channel);
    }

}
