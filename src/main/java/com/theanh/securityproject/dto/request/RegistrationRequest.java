package com.theanh.securityproject.dto.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record RegistrationRequest(
        String email,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String password
) {
}
