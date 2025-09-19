package com.example.psicoApp.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "psicologos", indexes = {
        @Index(name = "idx_psicologo_cedula", columnList = "cedula_profesional")
})
public class Psicologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación 1:1 con usuario (rol PSICOLOGO)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private Usuario usuario;

    @Column(name = "cedula_profesional", unique = true)
    private String cedulaProfesional;

    private String especialidad;

    @Column(columnDefinition = "TEXT")
    private String experiencia;
}

