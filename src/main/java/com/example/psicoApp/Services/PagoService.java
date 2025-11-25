package com.example.psicoApp.Services;

import com.example.psicoApp.DTOs.CitaPacienteDTO;
import com.example.psicoApp.DTOs.PagoDTO;
import com.example.psicoApp.DTOs.PagoPacienteDTO;
import com.example.psicoApp.Repositories.PacienteRepository;
import com.example.psicoApp.Repositories.PagoRepository;
import com.example.psicoApp.Repositories.UsuarioRepository;
import com.example.psicoApp.Security.JWT.JwtService;
import com.example.psicoApp.models.Cita;
import com.example.psicoApp.models.Paciente;
import com.example.psicoApp.models.Pago;
import com.example.psicoApp.models.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PagoService {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PagoRepository pagoRepository;

    public void save(PagoPacienteDTO request, HttpServletRequest httpRequest) {
        String token = httpRequest.getHeader("Authorization").replace("Bearer ", "");
        String username = jwtService.getUsernameFromToken(token); // Método para extraer el username del token
        Usuario user = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        Paciente paciente = pacienteRepository.findById(request.getIdPaciente())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));


        Pago pago = Pago.builder()
                .usuario(user)
                .paciente(paciente)
                .monto(request.getMonto())
                .metodo(request.getMetodo())
                .fecha(request.getFecha())

                .build();

        pagoRepository.save(pago);
    }

    public List<PagoDTO> getPagos(HttpServletRequest request) {

        String token = request.getHeader("Authorization").replace("Bearer ", "");
        String username = jwtService.getUsernameFromToken(token);
        Usuario user = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Traer TODOS los pagos
        List<Pago> pagos = pagoRepository.findAll();

        // Convertir Pago → PagoDTO
        return pagos.stream()
                .map(p -> new PagoDTO(
                        p.getId(),
                        p.getUsuario().getId(),
                        p.getPaciente().getId(),
                        p.getMonto(),
                        p.getFecha(),
                        p.getMetodo()
                ))
                .collect(Collectors.toList());
    }


    public List<PagoPacienteDTO> getPagosPacientes(HttpServletRequest request) {

        String token = request.getHeader("Authorization").replace("Bearer ", "");
        String username = jwtService.getUsernameFromToken(token);
        Usuario user = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Traer TODOS los pagos
        List<Pago> pagos = pagoRepository.findAll();

        // Convertir Pago → PagoDTO
        return pagos.stream()
                .map(c -> {
                    Paciente p = c.getPaciente();
                    return PagoPacienteDTO.builder()
                            .idPaciente(p.getId())
                            .nombre(p.getNombre())
                            .apellido(p.getApellido())
                            .monto(c.getMonto())
                            .fecha(LocalDate.now())
                            .metodo(c.getMetodo())
                            .build();
                })
                .collect(Collectors.toList());
    }
}