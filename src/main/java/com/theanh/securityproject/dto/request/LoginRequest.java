package com.theanh.securityproject.dto.request;

public record LoginRequest(
        String email,
        String password
) {
}
