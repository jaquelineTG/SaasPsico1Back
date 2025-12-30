package com.example.psicoApp.DTOs;

import com.example.psicoApp.models.Paciente;
import com.example.psicoApp.models.Pago;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {

    private Long idPago;
    private Long usuarioId;
    private Long pacienteId;
    private BigDecimal monto;
    private String fecha;
    private Pago.Metodo metodo;
}
