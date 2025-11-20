package com.example.psicoApp.DTOs;


import com.example.psicoApp.models.Pago;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PagoPacienteDTO {
    private Long idPaciente;
    private Double monto;
    private LocalDate fecha;
    private Pago.Metodo metodo;
}
