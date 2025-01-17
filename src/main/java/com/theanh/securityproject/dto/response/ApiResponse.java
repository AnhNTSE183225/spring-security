package com.theanh.securityproject.dto.response;

public record ApiResponse<T>(
        Integer statusCode,
        Boolean success,
        T data,
        String message
) {
}
