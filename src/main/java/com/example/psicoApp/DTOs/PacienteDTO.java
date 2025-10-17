package com.example.psicoApp.DTOs;

import com.example.psicoApp.models.Paciente;
import com.example.psicoApp.models.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

    private Long paciente_id;
    private String nombre;
    private String apellido;
    private String telefono;
    private Paciente.Sexo sexo;
    private String direccion;
    private String ocupacion;
    private Paciente.tipo_terapia tipo_terapia;
    private String numero_emergencia;
    private long usuario_id;
    private LocalDate fecha_nacimiento;

}
