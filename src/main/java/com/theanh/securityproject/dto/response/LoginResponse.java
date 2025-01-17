package com.theanh.securityproject.dto.response;

public record LoginResponse(
        String accessToken,
        String refreshToken
) {
}
