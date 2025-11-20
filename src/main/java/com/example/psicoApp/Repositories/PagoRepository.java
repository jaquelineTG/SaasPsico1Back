package com.example.psicoApp.Repositories;

import com.example.psicoApp.models.Cita;
import com.example.psicoApp.models.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago,Long> {
}
