package com.theanh.securityproject.controller;

import com.theanh.securityproject.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @GetMapping("/get-message")
    public ResponseEntity<ApiResponse<Void>> getMessage() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new ApiResponse<>(
                                HttpStatus.OK.value(),
                                true,
                                null,
                                "Message received"
                        )
                );
    }

}
