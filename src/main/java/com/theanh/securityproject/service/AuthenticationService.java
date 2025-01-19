package com.theanh.securityproject.service;

import com.theanh.securityproject.dto.request.LoginRequest;
import com.theanh.securityproject.dto.request.RegistrationRequest;
import com.theanh.securityproject.dto.response.LoginResponse;

public interface AuthenticationService {
    void register(RegistrationRequest request);
    LoginResponse login(LoginRequest request);
}
