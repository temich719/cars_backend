package com.example.cars_backend.service.impl;

import com.example.cars_backend.dto.CarDto;
import com.example.cars_backend.repository.CarRepository;
import com.example.cars_backend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public CarDto getCarById(UUID id) {
        return null;
    }

    @Override
    public List<CarDto> getCars(int page, int size) {
        return null;
    }
}
