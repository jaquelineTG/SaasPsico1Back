package com.example.psicoApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;

    @Column(nullable = false)
    private String telefono;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    private String ocupacion;
    @Enumerated(EnumType.STRING)
        private tipo_terapia tipo_terapia;

    private String numero_emergencia;
    // 👇 Relación con Psicólogo
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public enum Sexo { MASCULINO, FEMENINO, OTRO }
    public enum tipo_terapia { INDIVIDUAL, PAREJA, FAMILIAR,GRUPAL, INFANTIL, ESPECIALIZADA }
}
