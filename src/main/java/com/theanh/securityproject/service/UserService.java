package com.theanh.securityproject.service;

import com.theanh.securityproject.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
}
