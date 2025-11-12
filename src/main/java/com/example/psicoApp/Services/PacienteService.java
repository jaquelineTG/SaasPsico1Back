package com.example.psicoApp.Services;


import com.example.psicoApp.DTOs.CitaPacienteDTO;
import com.example.psicoApp.DTOs.PacienteDTO;
import com.example.psicoApp.Repositories.PacienteRepository;
import com.example.psicoApp.Repositories.UsuarioRepository;
import com.example.psicoApp.Security.JWT.JwtService;
import com.example.psicoApp.models.Cita;
import com.example.psicoApp.models.Paciente;
import com.example.psicoApp.models.Usuario;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void save(PacienteDTO request, HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader("Authorization").replace("Bearer ", "");
        String username = jwtService.getUsernameFromToken(token); // Método para extraer el username del token
        Usuario user = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        Paciente paciente = Paciente.builder()
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .direccion(request.getDireccion())
                .ocupacion(request.getOcupacion())
                .fecha_nacimiento(request.getFecha_nacimiento())
                .sexo(request.getSexo())
                .telefono(request.getTelefono())
                .tipo_terapia(request.getTipo_terapia())
                .numero_emergencia(request.getNumero_emergencia())
                .usuario(user)
                .build();

        pacienteRepository.save(paciente);
    }


    public List<PacienteDTO> getPacientes(HttpServletRequest request) {
        // 1. Sacar el token que viene en el header de la petición
        String token = request.getHeader("Authorization").replace("Bearer ", "");

        // 2. Con el token, obtener el username (lo hace JwtService)
        String email = jwtService.getUsernameFromToken(token);

        // 3. Buscar al usuario en la base de datos
        Usuario user = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // 4. Buscar todos los pacientes de ese usuario (consulta en DB)
        return pacienteRepository.findAllByUsuario(user).stream()

                // 5. Convertir cada entidad Paciente a PacienteDTO
                .map(p -> PacienteDTO.builder()
                        .paciente_id(p.getId())
                        .nombre(p.getNombre())
                        .apellido(p.getApellido())
                        .telefono(p.getTelefono())
                        .sexo(p.getSexo())
                        .tipo_terapia(p.getTipo_terapia())
                        .direccion(p.getDireccion())
                        .ocupacion(p.getOcupacion())
                        .usuario_id(p.getUsuario().getId())
                        .fecha_nacimiento(p.getFecha_nacimiento())
                        .build())
                .toList();
    }


}

