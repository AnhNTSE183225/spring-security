package com.theanh.securityproject.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record UserDto(
        Integer id,
        String email,
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        List<Role> roles
) {
    @Builder
    public record Role(
            String name
    ) {
    }
}
