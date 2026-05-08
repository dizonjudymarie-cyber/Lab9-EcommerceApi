package com.ws101.dizoncolele.EcommerceApi.controller;

import com.ws101.dizoncolele.EcommerceApi.dto.RegisterUserDto;
import com.ws101.dizoncolele.EcommerceApi.model.User;
import com.ws101.dizoncolele.EcommerceApi.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public AuthController(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterUserDto dto) {

        User user = new User(
                dto.username(),
                encoder.encode(dto.password()),
                dto.role()
        );

        repo.save(user);

        return "User registered successfully";
    }
}