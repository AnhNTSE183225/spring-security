package com.theanh.securityproject.controller;

import com.theanh.securityproject.dto.request.LoginRequest;
import com.theanh.securityproject.dto.request.RegistrationRequest;
import com.theanh.securityproject.dto.response.ApiResponse;
import com.theanh.securityproject.dto.response.LoginResponse;
import com.theanh.securityproject.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(
            @RequestBody RegistrationRequest request
    ) {
        authenticationService.register(request);
        return ResponseEntity
                .status(CREATED)
                .body(
                        ApiResponse.<Void>builder()
                                .statusCode(CREATED.value())
                                .success(true)
                                .data(null)
                                .message(CREATED.getReasonPhrase())
                                .build()
                );
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity
                .status(OK)
                .body(
                        ApiResponse.<LoginResponse>builder()
                                .statusCode(OK.value())
                                .success(true)
                                .data(authenticationService.login(request))
                                .message("Login successful")
                                .build()
                );
    }

}
