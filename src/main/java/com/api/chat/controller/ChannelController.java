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

    // http://localhost:8888/channels/
    @GetMapping(path = "/")
    public List<Channel> getChannels() {
        return channelService.getChannels();
    }

    // http://localhost:8888/channels/1/
    @GetMapping(path = "/{channelId}/")
    public Channel getChannelById(@PathVariable Long channelId) {
        return channelService.getChannelById(channelId);
    }

    //http://localhost:8888/channels/
    @PostMapping(path = "/")
    public Channel createChannel(@RequestBody Channel channel) {
        return channelService.createChannel(channel);
    }

    //http://localhost:8888/channels/1/user/1
    @PostMapping(path = "/{channelId}/user/{userId}")
    public UserChannel addUserToChannel(@PathVariable Long channelId, @PathVariable Long userId) {
        return channelService.addUserToChannel(channelId, userId);
    }

    //http://localhost:8888/channels/1
    @PutMapping(path = "/{channelId}")
    public Channel updateChannel(@PathVariable Long channelId, @RequestBody Channel channel) {
        return channelService.updateChannel(channelId, channel);
    }

    // http://localhost:8888/channels/1
    @DeleteMapping(path = "/{channelId}")
    public UserChannel deleteUserFromChannel(@PathVariable Long channelId) {
        return userChannelService.deleteUserFromChannel(channelId);
    }
}
