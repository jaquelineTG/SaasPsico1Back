package com.example.psicoApp.Services;


import com.example.psicoApp.DTOs.PacienteDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {
    public void save(PacienteDTO request, HttpServletRequest httpRequest) {

    }

    public List<PacienteDTO> getPacientes(HttpServletRequest request) {
        return List.of();
    }
}
