package com.example.psicoApp.Controllers;

import com.example.psicoApp.DTOs.PushTokenRequest;
import com.example.psicoApp.Services.NotificationService;
import com.example.psicoApp.Services.PushTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final PushTokenService pushTokenService;
    private final NotificationService notificationService;

    // Guardar el token desde el frontend
    @PostMapping("/push-token")
    public ResponseEntity<Void> savePushToken(
            @RequestBody PushTokenRequest request
    ) {
        pushTokenService.saveToken(
                request.getUsuarioId(),
                request.getExpoToken()
        );
        return ResponseEntity.ok().build();
    }

    //  ENDPOINT DE PRUEBA (PASO 10)
    @GetMapping("/test/{usuarioId}")
    public ResponseEntity<Void> testPush(
            @PathVariable Long usuarioId
    ) {
        notificationService.sendTestNotification(usuarioId);
        return ResponseEntity.ok().build();
    }
}

