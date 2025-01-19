package com.theanh.securityproject;

import com.theanh.securityproject.entity.Role;
import com.theanh.securityproject.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityprojectApplication implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(SecurityprojectApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if(roleRepository.count() > 0) {
            return;
        }

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
}
