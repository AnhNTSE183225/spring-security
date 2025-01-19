package com.theanh.securityproject.dto.request;

import lombok.Builder;

@Builder
public record LoginRequest(
        String email,
        String password
) {
}
