package com.theanh.securityproject;

import com.theanh.securityproject.entity.Role;
import com.theanh.securityproject.entity.User;
import com.theanh.securityproject.repository.RoleRepository;
import com.theanh.securityproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityprojectApplication implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SecurityprojectApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (roleRepository.count() <= 0) {
            roleRepository.save(
                    Role
                            .builder()
                            .name("USER")
                            .displayName("Người dùng")
                            .build()
            );
            roleRepository.save(
                    Role
                            .builder()
                            .name("ADMIN")
                            .displayName("Quản lý")
                            .build()
            );
        }

        if (userRepository.findByEmail("admin@theanh.com").isEmpty()) {
            Role role = roleRepository.findByName("ADMIN").orElseThrow(() -> new RuntimeException("Role not found"));
            userRepository.save(
                    User.builder()
                            .firstName("admin")
                            .lastName("theanh")
                            .email("admin@theanh.com")
                            .password(passwordEncoder.encode("admin"))
                            .roles(List.of(role))
                            .build()
            );
        }

        if (userRepository.findByEmail("user0@theanh.com").isEmpty()) {
            Role role = roleRepository.findByName("USER").orElseThrow(() -> new RuntimeException("Role not found"));
            for (int i = 0; i < 1000; i++) {
                userRepository.save(
                        User.builder()
                                .firstName("user" + i)
                                .lastName("theanh")
                                .email("user" + i + "@theanh.com")
                                .password(passwordEncoder.encode("user" + i))
                                .roles(List.of(role))
                                .build()
                );
            }
        }
    }
}
