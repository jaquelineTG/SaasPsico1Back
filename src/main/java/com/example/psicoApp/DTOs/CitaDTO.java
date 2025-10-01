package com.example.psicoApp.DTOs;

import com.example.psicoApp.models.Cita;
import com.example.psicoApp.models.Paciente;
import com.example.psicoApp.models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitaDTO {
    private Long cita_id;
    private Usuario usuario;
    private Long paciente;
    private LocalDateTime fecha;
    private LocalTime hora_inicio;
    private LocalTime hora_final;
    private Paciente.Sexo sexo;
    private Cita.Estado estado;
    private String notas;
}
