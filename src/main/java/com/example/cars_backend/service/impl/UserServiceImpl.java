package com.example.cars_backend.service.impl;

import com.example.cars_backend.dto.UserDto;
import com.example.cars_backend.repository.UserRepository;
import com.example.cars_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(UserDto userDto) {

    }

    @Override
    public void updateUser(UserDto userDto, UUID id) {

    }

    @Override
    public void deleteUser(UUID id) {

    }

    @Override
    public void getUserById(UUID id) {

    }

    @Override
    public void addCarToFavorites(UUID userId, UUID carId) {

    }
}
