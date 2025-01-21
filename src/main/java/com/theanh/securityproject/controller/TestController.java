package com.theanh.securityproject.controller;

import com.theanh.securityproject.dto.UserDto;
import com.theanh.securityproject.dto.response.ApiResponse;
import com.theanh.securityproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    @GetMapping("/get-message")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponse<Void>> getMessage() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<Void>builder()
                                .statusCode(HttpStatus.OK.value())
                                .success(true)
                                .data(null)
                                .message("Message received")
                                .build()
                );
    }

    @GetMapping("/get-all-users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ApiResponse.<List<UserDto>>builder()
                                .statusCode(HttpStatus.OK.value())
                                .success(true)
                                .data(userService.findAll())
                                .message("Get All Users")
                                .build()
                );
    }
}
