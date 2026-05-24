package com.example.springrest.controller;

import com.example.springrest.dto.MessageRequest;
import com.example.springrest.service.MessageSendService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {
    private final MessageSendService messageService;

    @PostMapping("/api/message")
    public void sendMessage(@RequestBody MessageRequest request) {
        messageService.sendNotification(request.getText(), request.getTargetUrl());
    }


}
