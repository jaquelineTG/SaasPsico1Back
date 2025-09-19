package com.example.psicoApp.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private String telefono;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    private String ocupacion;

    public enum Sexo { MASCULINO, FEMENINO, OTRO }
}
