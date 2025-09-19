package com.example.psicoApp.models;



import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Mensajes = plantillas que el psicólogo crea para enviar por WhatsApp.
 * Plantilla puede incluir {nombre}, {fecha}, {hora} que se reemplazarán al generar el texto.
 */
@Data
@Entity
@Table(name = "mensajes")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // plantilla con placeholders: {nombre}, {fecha}, {hora}
    @Column(columnDefinition = "TEXT", nullable = false)
    private String plantilla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "psicologo_id", nullable = false)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Psicologo psicologo;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @PrePersist
    public void prePersist() {
        if (creadoEn == null) creadoEn = LocalDateTime.now();
    }
}

