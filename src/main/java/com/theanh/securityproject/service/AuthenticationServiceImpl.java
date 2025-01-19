package com.theanh.securityproject.service;

import com.theanh.securityproject.configuration.JwtService;
import com.theanh.securityproject.dto.request.LoginRequest;
import com.theanh.securityproject.dto.request.RegistrationRequest;
import com.theanh.securityproject.dto.response.LoginResponse;
import com.theanh.securityproject.entity.Role;
import com.theanh.securityproject.entity.User;
import com.theanh.securityproject.repository.RoleRepository;
import com.theanh.securityproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public void register(RegistrationRequest request) {
        Role role = roleRepository.findByName("USER").orElseThrow(() -> new RuntimeException("Role not found"));
        User user = User
                .builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .roles(List.of(role))
                .build();
        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        HashMap<String, Object> claims = new HashMap<>();
        User user;
        Object principal = authentication.getPrincipal();
        user = (User) principal;
        claims.put("fullName", user.getFullName());
        String jwtToken = jwtService.generateToken(user, claims);
        return LoginResponse
                .builder()
                .accessToken(jwtToken)
                .build();
    }

}
