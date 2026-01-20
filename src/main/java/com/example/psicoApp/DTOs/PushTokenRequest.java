package com.example.psicoApp.DTOs;

import lombok.Data;

@Data
public class PushTokenRequest {
    private Long usuarioId;
    private String expoToken;
}

