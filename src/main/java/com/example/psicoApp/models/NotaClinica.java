package com.example.psicoApp.models;



import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notas_clinicas")
public class NotaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "psicologo_id", nullable = false)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Psicologo psicologo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cita_id")
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Cita cita;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contenido;

    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;

    @PrePersist
    public void prePersist() {
        if (creadoEn == null) creadoEn = LocalDateTime.now();
    }
}

