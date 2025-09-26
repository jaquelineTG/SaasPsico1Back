package com.example.psicoApp.Repositories;

import com.example.psicoApp.DTOs.PacienteDTO;
import com.example.psicoApp.models.Paciente;
import com.example.psicoApp.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

    List<Paciente> findAllByUsuario(Usuario usuario);
}
