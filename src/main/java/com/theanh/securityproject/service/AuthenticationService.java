package com.theanh.securityproject.service;

import com.theanh.securityproject.dto.request.RegistrationRequest;

public interface AuthenticationService {
    void register(RegistrationRequest request);
}
