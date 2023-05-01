package com.api.chat.controller;

import com.api.chat.model.Channel;
import com.api.chat.model.Message;
import com.api.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/channels")
public class MessageController {
    private MessageService messageService;

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    //http://localhost:8888/channels/1/messages/
    @GetMapping(path = "/{channelId}/messages/")
    public List<Message> getMessages(@PathVariable Long channelId) {
        return messageService.getMessages(channelId);
    }

    //http://localhost:8888/channels/1/messages/
    @PostMapping(path = "/{channelId}/messages/")
    public Message createMessage(@PathVariable Long channelId, @RequestBody Message message) {
        return messageService.createMessage(channelId, message);
    }

    //http://localhost:8888/channels/1/messages/1
    @PutMapping(path = "/{channelId}/messages/{messageId}/")
    public Message updateMessage(@PathVariable Long channelId, @PathVariable Long messageId, @RequestBody Message message) {
        return messageService.updateMessage(channelId, messageId, message);
    }

    //http://localhost:8888/channels/1/messages/1
    @DeleteMapping(path = "/{channelId}/messages/{messageId}/")
    public Message deleteMessage(@PathVariable Long channelId, @PathVariable Long messageId) {
        return messageService.deleteMessage(messageId);
    }
}
