package com.example.psicoApp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "citas", indexes = {
        @Index(name = "idx_cita_fecha", columnList = "fecha")
})
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Paciente paciente;

    // Fecha de la cita
    private LocalDate  fecha;

    // Hora de inicio de la cita
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime hora_inicio;

    // Hora de finalización de la cita
    @Column(name = "hora_final", nullable = false)
    private LocalTime hora_final;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado = Estado.PENDIENTE;

    @Column(columnDefinition = "TEXT")
    private String notas;

    public enum Estado {
        PENDIENTE, CONFIRMADA, CANCELADA, COMPLETADA
    }
}
