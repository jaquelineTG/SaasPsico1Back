package com.example.psicoApp.Repositories;

import com.example.psicoApp.models.PushToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PushTokenRepository
        extends JpaRepository<PushToken, Long> {

    Optional<PushToken> findByExpoToken(String expoToken);

    List<PushToken> findByUsuarioIdAndActivoTrue(Long usuarioId);
}

