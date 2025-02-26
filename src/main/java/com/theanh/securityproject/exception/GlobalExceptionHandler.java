package com.theanh.securityproject.exception;

import com.theanh.securityproject.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<ApiResponse<String>> runtimeException(AuthorizationDeniedException e) {
        return ResponseEntity
                .status(FORBIDDEN)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(FORBIDDEN.value())
                                .success(false)
                                .message(e.getMessage())
                                .data(null)
                                .build()
                );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> runtimeException(RuntimeException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(
                        ApiResponse.<String>builder()
                                .statusCode(INTERNAL_SERVER_ERROR.value())
                                .success(false)
                                .message(e.getMessage())
                                .data(null)
                                .build()
                );
    }


}
