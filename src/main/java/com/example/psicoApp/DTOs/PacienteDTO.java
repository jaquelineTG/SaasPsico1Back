package com.example.psicoApp.DTOs;

import com.example.psicoApp.models.Paciente;
import com.example.psicoApp.models.Usuario;

import java.time.LocalDate;

public class PacienteDTO {

    private Integer paciente_id;
    private String nombre;
    private String apellido;
    private String telefono;
    private Paciente.Sexo sexo;
    private String direccion;
    private String ocupacion;
    private Usuario usuario_id;
}
