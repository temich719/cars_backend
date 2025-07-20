package com.example.cars_backend.service.impl;

import com.example.cars_backend.dto.CarDto;
import com.example.cars_backend.entity.Car;
import com.example.cars_backend.repository.CarRepository;
import com.example.cars_backend.service.CarService;
import com.example.cars_backend.util.mapper.Mapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final Mapper<Car, CarDto> carMapper;

    @Transactional(readOnly = true)
    @Override
    public CarDto getCarById(UUID id) {
        return carMapper.mapToDto(carRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can't find car with id = " + id)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<CarDto> getCars(int page, int size) {
        return carRepository.getCarsPage(page * size, size).stream().map(carMapper::mapToDto).collect(Collectors.toList());
    }
}
