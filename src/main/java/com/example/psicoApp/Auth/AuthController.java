package com.example.psicoApp.Auth;




import com.example.psicoApp.Auth.DTO.LoginDTO;
import com.example.psicoApp.Auth.DTO.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO request){
        return ResponseEntity.ok(authService.login(request));


    }
    @PostMapping(value = "register")
    public ResponseEntity <AuthResponse> register(@RequestBody RegisterDTO request){
        return ResponseEntity.ok(authService.register(request));


    }
}
