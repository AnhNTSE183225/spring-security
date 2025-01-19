package com.theanh.securityproject.dto.request;

import java.time.LocalDate;

public record RegistrationRequest(
        String email,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String password
) {
}
