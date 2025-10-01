package com.example.psicoApp.Demo.User;

import com.example.psicoApp.models.Paciente;
import com.example.psicoApp.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findById(Long id);
}
