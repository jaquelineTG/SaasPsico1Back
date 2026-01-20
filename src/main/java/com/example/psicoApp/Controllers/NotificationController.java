package com.example.psicoApp.Controllers;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final PushTokenService pushTokenService;
    private final NotificationService notificationService;

    // 1️⃣ Guardar el token desde el frontend
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

    // 2️⃣ ENDPOINT DE PRUEBA (PASO 10)
    @GetMapping("/test/{usuarioId}")
    public ResponseEntity<Void> testPush(
            @PathVariable Long usuarioId
    ) {
        notificationService.sendTestNotification(usuarioId);
        return ResponseEntity.ok().build();
    }
}

