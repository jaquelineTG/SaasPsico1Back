package com.example.psicoApp.DTOs;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class CitaPacienteDTO {
    private Long paciente_id;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;

    private LocalTime hora_inicio;
    private LocalTime hora_final;
}
