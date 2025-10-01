package com.example.psicoApp.Controllers;


import com.example.psicoApp.DTOs.CitaDTO;
import com.example.psicoApp.DTOs.CitaPacienteDTO;
import com.example.psicoApp.DTOs.PacienteDTO;
import com.example.psicoApp.Services.CitaService;
import com.example.psicoApp.Services.PacienteService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @PostMapping(value = "saveCita")
    public ResponseEntity<String> save(@RequestBody CitaDTO request, HttpServletRequest httpRequest) {
        citaService.save(request,httpRequest);
        return ResponseEntity.ok("cita guardada exitosamente.");
    }
    @GetMapping("getCitas/{fecha}")
    public List<CitaPacienteDTO> getCitasPorDia(@PathVariable String fecha, HttpServletRequest httpRequest) {
        return citaService.getCitasPorDia(LocalDate.parse(fecha), httpRequest);
    }


}
