package com.example.cars_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDto {

    private UUID id;
    private String name;
    private double price;
    private String description;
    private String imagePaths;

}
