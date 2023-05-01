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

    @GetMapping(path = "/{channelId}/messages/")
    public List<Message> getMessages(@PathVariable Long channelId) {
        return messageService.getMessages(channelId);
    }

    @PostMapping(path = "/{channelId}/messages/")
    public Message createMessage(@PathVariable Long channelId, @RequestBody Message message) {
        return messageService.createMessage(channelId, message);
    }
    @PutMapping(path = "/{channelId}/messages/{messageId}/")
    public Message updateMessage(@PathVariable Long channelId, @PathVariable Long messageId, @RequestBody Message message) {
        return messageService.updateMessage(channelId, messageId, message);
    }
    @DeleteMapping(path = "/{channelId}/messages/{messageId}/")
    public Message deleteMessage(@PathVariable Long channelId, @PathVariable Long messageId) {
        return messageService.deleteMessage(messageId);
    }
}
