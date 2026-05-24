package com.example.springrest.service;

import com.example.MessageService;
import com.example.dto.MessageDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageSendService {


    private final MessageService messageService;

    public void sendNotification(String text, String targetUrl) {
        // 1. Создаём DTO
        MessageDto dto = new MessageDto();
        dto.setMsg(text);   // нужен setter (или @Data)
        // 2. Вызываем send из библиотеки
        messageService.send(dto, targetUrl);
    }
}
