package com.theanh.securityproject.dto.response;

import lombok.Builder;

@Builder
public record ApiResponse<T>(
        Integer statusCode,
        Boolean success,
        T data,
        String message
) {
}
