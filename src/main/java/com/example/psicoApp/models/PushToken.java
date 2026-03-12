package com.example.psicoApp.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;


@Entity
@Table(name = "push_tokens")
@Data
public class PushToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "expo_token", unique = true, nullable = false)
    private String expoToken;

    private Boolean activo = true;

    @CreationTimestamp
    private LocalDateTime createdAt;
}

