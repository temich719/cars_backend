package com.example.cars_backend.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserDto {

    private UUID id;
    private String name;
    private String surname;
    private String avatarPath;
    private String login;
    private String password;
    private String phone;
    private List<CarDto> favoriteCars;

}
