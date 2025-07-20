package com.example.cars_backend.util.mapper.impl;

import com.example.cars_backend.dto.CarDto;
import com.example.cars_backend.dto.UserDto;
import com.example.cars_backend.entity.User;
import com.example.cars_backend.util.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    @Override
    public User mapToEntity(UserDto userDto) {
        return new User(
                userDto.getName(),
                userDto.getSurname(),
                userDto.getAvatarPath(),
                userDto.getLogin(),
                userDto.getPhone()
        );
    }

    @Override
    public UserDto mapToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getAvatarPath(),
                user.getLogin(),
                user.getPhone(),
                user.getFavoriteCars().stream().map(car -> new CarDto(
                        car.getId(),
                        car.getName(),
                        car.getPrice(),
                        car.getDescription(),
                        car.getImagePaths()
                )).collect(Collectors.toList())
        );
    }
}
