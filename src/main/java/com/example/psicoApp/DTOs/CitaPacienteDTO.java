package com.example.psicoApp.DTOs;

import com.example.psicoApp.models.Paciente;
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
    private Paciente.tipo_terapia tipo_terapia;

    private LocalTime hora_inicio;
    private LocalTime hora_final;
    private LocalDate fecha;
}
