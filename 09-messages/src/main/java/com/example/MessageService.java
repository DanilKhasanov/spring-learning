package com.example;

import com.example.dto.MessageDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@AllArgsConstructor
public class MessageService {

    private final RestClient restClient;



    public void send(MessageDto dto, String targetUrl) {
        restClient.post()
                .uri(targetUrl)
                .body(dto)
                .retrieve()
                .toBodilessEntity();
    }


}
