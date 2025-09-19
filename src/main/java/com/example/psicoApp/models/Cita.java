package com.example.psicoApp.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "citas", indexes = {
        @Index(name = "idx_cita_fecha", columnList = "fecha")
})
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "psicologo_id", nullable = false)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Psicologo psicologo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Paciente paciente;

    // Fecha y hora de la cita
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.PENDIENTE;

    @Column(columnDefinition = "TEXT")
    private String notas;

    public enum Estado { PENDIENTE, CONFIRMADA, CANCELADA, COMPLETADA }
}

