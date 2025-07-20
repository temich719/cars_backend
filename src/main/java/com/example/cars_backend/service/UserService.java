package com.example.cars_backend.service;

import com.example.cars_backend.dto.UserDto;

import java.util.UUID;

public interface UserService {

    void createUser(UserDto userDto);

    void updateUser(UserDto userDto, UUID id);

    void deleteUser(UUID id);

    void getUserById(UUID id);

    void addCarToFavorites(UUID userId, UUID carId);

}
