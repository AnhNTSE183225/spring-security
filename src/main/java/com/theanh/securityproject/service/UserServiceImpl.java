package com.theanh.securityproject.service;

import com.theanh.securityproject.dto.UserDto;
import com.theanh.securityproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(user -> UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .dateOfBirth(user.getDateOfBirth())
                .roles(
                        user.getRoles().stream().map(
                                        role -> UserDto.Role.builder()
                                                .name(role.getName())
                                                .build()
                                )
                                .toList()
                )
                .build()).toList();
    }
}
