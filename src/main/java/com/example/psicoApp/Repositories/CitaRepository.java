package com.example.psicoApp.Repositories;

import com.example.psicoApp.models.Cita;
import com.example.psicoApp.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita,Long> {
    List<Cita> findByUsuarioAndFecha(Usuario user, LocalDate fecha);
}
