package com.api.chat.controller;

import com.api.chat.model.Channel;
import com.api.chat.model.Message;
import com.api.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/channel")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(path = "/{channelId}/message")
    public List<Message> getMessages(@PathVariable Long channelId) {
        return messageService.getMessages(channelId);
    }
}
