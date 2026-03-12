package com.example.psicoApp.Services;

import com.example.psicoApp.Repositories.PushTokenRepository;
import com.example.psicoApp.models.PushToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final PushTokenRepository repository;
    private final ExpoPushService expoPushService;

    public void sendTestNotification(Long usuarioId) {

        List<PushToken> tokens =
                repository.findByUsuarioIdAndActivoTrue(usuarioId);

        for (PushToken t : tokens) {
            expoPushService.send(
                    t.getExpoToken(),
                    "Notificación de prueba",
                    "¡Las notificaciones funcionan 🎉!"
            );
        }
    }
}

