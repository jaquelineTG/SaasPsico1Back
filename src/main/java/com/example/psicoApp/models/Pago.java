package com.example.psicoApp.models;



import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pagos")
public class     Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Usuario usuario;

    @Column(precision = 10, scale = 2, nullable = false)
    private Double monto;

    @Enumerated(EnumType.STRING)
    private Metodo metodo;

    @Column(name = "fecha", nullable = false, updatable = false)
    private LocalDate fecha;

    public enum Metodo { EFECTIVO, TRANSFERENCIA, TARJETA }

    @PrePersist
    public void prePersist() {
        if (fecha == null) fecha = LocalDate.now();
    }
}

