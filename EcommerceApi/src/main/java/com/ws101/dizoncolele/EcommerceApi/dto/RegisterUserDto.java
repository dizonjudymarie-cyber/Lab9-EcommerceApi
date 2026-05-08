package com.ws101.dizoncolele.EcommerceApi.dto;

import jakarta.validation.constraints.*;

public record RegisterUserDto(

        @NotBlank(message = "Username is required")
        @Size(min = 8, max = 20, message = "Username must be 8–20 characters")
        String username,

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = 20, message = "Password must be 8–20 characters")
        String password,

        @NotBlank(message = "Role is required")
        String role
) {}