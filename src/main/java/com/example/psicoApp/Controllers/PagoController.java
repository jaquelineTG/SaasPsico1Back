package com.example.psicoApp.Controllers;

import com.example.psicoApp.DTOs.CitaDTO;
import com.example.psicoApp.DTOs.PacienteDTO;
import com.example.psicoApp.DTOs.PagoPacienteDTO;
import com.example.psicoApp.Services.CitaService;
import com.example.psicoApp.Services.PacienteService;
import com.example.psicoApp.Services.PagoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PagoController {
    @Autowired
    private PagoService pagoService;
    @Autowired
    private PacienteService pacienteService;


    @PostMapping(value = "savePago")
    public ResponseEntity<String> save(@RequestBody PagoPacienteDTO request, HttpServletRequest httpRequest) {
        pagoService.save(request,httpRequest);
        return ResponseEntity.ok("pago guardado exitosamente.");
    }



}
