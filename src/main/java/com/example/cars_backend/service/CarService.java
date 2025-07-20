package com.example.cars_backend.service;

import com.example.cars_backend.dto.CarDto;

import java.util.List;
import java.util.UUID;

public interface CarService {

    CarDto getCarById(UUID id);

    List<CarDto> getCars(int page, int size);

}
