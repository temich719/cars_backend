package com.example.cars_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private UUID id;
    private String name;
    private String surname;
    private String avatarPath;
    private String login;
    private String phone;
    private List<CarDto> favoriteCars;

}
