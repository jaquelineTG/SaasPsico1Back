package com.example.psicoApp.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "configuracion_psicologo")
public class ConfiguracionPsicologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "psicologo_id", nullable = false)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Psicologo psicologo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Dia dia;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    public enum Dia { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO }
}
