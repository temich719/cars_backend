package com.example.cars_backend.service;

import com.example.cars_backend.dto.UserDto;
import com.example.cars_backend.dto.UserWithoutPasswordDto;
import com.example.cars_backend.exception.ConvertImageToBytesException;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface UserService {

    void createUser(UserDto userDto, MultipartFile avatarImage) throws ConvertImageToBytesException;

    UserWithoutPasswordDto getUserById(UUID id);

    void addCarToFavorites(UUID userId, UUID carId);

    void deleteCarFromFavorites(UUID userId, UUID carId);

}
