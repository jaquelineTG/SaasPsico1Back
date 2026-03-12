package com.example.psicoApp.Services;

import com.example.psicoApp.Repositories.PushTokenRepository;
import com.example.psicoApp.models.PushToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PushTokenService {

    private final PushTokenRepository repository;

    public void saveToken(Long usuarioId, String token) {
        repository.findByExpoToken(token)
                .ifPresentOrElse(
                        existing -> {
                            existing.setActivo(true);
                            repository.save(existing);
                        },
                        () -> {
                            PushToken pt = new PushToken();
                            pt.setUsuarioId(usuarioId);
                            pt.setExpoToken(token);
                            pt.setActivo(true);
                            repository.save(pt);
                        }
                );
    }
}
