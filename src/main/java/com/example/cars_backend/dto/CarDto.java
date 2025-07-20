package com.example.cars_backend.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CarDto {

    private UUID id;
    private String name;
    private double price;
    private String description;
    private String imagePaths;

}
