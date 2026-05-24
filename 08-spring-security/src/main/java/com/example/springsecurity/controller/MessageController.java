package com.example.springsecurity.controller;

import com.example.dto.MessageDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class MessageController {

    @PostMapping("/message")
    public MessageDto postMessage(@RequestBody MessageDto messageDto){
        System.out.println(messageDto.getMsg());

        return messageDto;

    }

}
