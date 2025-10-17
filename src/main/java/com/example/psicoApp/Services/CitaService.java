package com.example.psicoApp.Services;

import com.example.psicoApp.DTOs.CitaDTO;
import com.example.psicoApp.DTOs.CitaPacienteDTO;
import com.example.psicoApp.DTOs.PacienteDTO;

import com.example.psicoApp.Repositories.CitaRepository;
import com.example.psicoApp.Repositories.PacienteRepository;
import com.example.psicoApp.Repositories.UsuarioRepository;
import com.example.psicoApp.Security.JWT.JwtService;
import com.example.psicoApp.models.Cita;
import com.example.psicoApp.models.Paciente;
import com.example.psicoApp.models.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    public void save(CitaDTO request, HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader("Authorization").replace("Bearer ", "");
        String username = jwtService.getUsernameFromToken(token); // Método para extraer el username del token
        Usuario user = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        Paciente paciente = pacienteRepository.findById(request.getPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));


        Cita cita = Cita.builder()
                .usuario(user)
                .paciente(paciente)
                .estado(request.getEstado())
                .fecha(request.getFecha())
                .hora_inicio(request.getHoraInicio())
                .hora_final(request.getHoraFinal())
                .notas(request.getNotas())
                .build();

        citaRepository.save(cita);
    }


    public List<CitaPacienteDTO> getCitasPorDia(LocalDate fecha, HttpServletRequest httpRequest) {
        // opcional: validar el usuario desde el token (si quieres que solo vea sus citas)
        String token = httpRequest.getHeader("Authorization").replace("Bearer ", "");
        String username = jwtService.getUsernameFromToken(token);
        Usuario user = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // rango del día
        LocalDateTime startOfDay = fecha.atStartOfDay();
        LocalDateTime endOfDay = fecha.atTime(LocalTime.MAX);

        List<Cita> citas = citaRepository.findByUsuarioAndFechaBetween(user, startOfDay, endOfDay);

        // mapear a DTOs de pacientes
        return citas.stream()
                .map(c -> {
                    Paciente p = c.getPaciente();
                    return CitaPacienteDTO.builder()
                            .paciente_id(p.getId())
                            .nombre(p.getNombre())
                            .apellido(p.getApellido())
                            .fecha_nacimiento(p.getFecha_nacimiento())
                            .hora_inicio(c.getHora_inicio())
                            .hora_final(c.getHora_final())
                            .build();
                })
                .collect(Collectors.toList());


    }
}
