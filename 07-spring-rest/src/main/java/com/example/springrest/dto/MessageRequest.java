package com.example.springrest.dto;

import lombok.Data;

@Data
public class MessageRequest {
    private String text;
    private String targetUrl;
}