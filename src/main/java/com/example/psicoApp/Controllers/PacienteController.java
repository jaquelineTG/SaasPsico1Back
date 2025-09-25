package com.example.psicoApp.Controllers;

import com.example.psicoApp.DTOs.PacienteDTO;
import com.example.psicoApp.Services.PacienteService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    @PostMapping(value = "savePaciente")
    public ResponseEntity<String> save(@RequestBody PacienteDTO request, HttpServletRequest httpRequest) {
        pacienteService.save(request,httpRequest);
        return ResponseEntity.ok("Producto guardado exitosamente en el carrito.");
    }
    @GetMapping(value = "getPacientes")
    public ResponseEntity<List<PacienteDTO>> getCartItems(HttpServletRequest request) {
        List<PacienteDTO> pacientes = pacienteService.getPacientes(request);
        return ResponseEntity.ok(pacientes);
    }
}
