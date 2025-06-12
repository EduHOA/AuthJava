package com.edu.atividade.controller;

import com.edu.atividade.dto.JwtResponseDto;
import com.edu.atividade.dto.UserLoginDto;
import com.edu.atividade.dto.UserRegistrationDto;
import com.edu.atividade.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<JwtResponseDto> register(@Valid @RequestBody UserRegistrationDto registrationDto) {
        return ResponseEntity.ok(authService.register(registrationDto));
    }

    @PostMapping("/register/admin")
    public ResponseEntity<JwtResponseDto> registerAdmin(@Valid @RequestBody UserRegistrationDto registrationDto) {
        return ResponseEntity.ok(authService.registerAdmin(registrationDto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@Valid @RequestBody UserLoginDto loginDto) {
        return ResponseEntity.ok(authService.login(loginDto));
    }
} 