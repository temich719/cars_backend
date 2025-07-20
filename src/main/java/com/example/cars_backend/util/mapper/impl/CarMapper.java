package com.example.cars_backend.util.mapper.impl;

import com.example.cars_backend.dto.CarDto;
import com.example.cars_backend.entity.Car;
import com.example.cars_backend.util.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements Mapper<Car, CarDto> {

    @Override
    public Car mapToEntity(CarDto carDto) {
        return new Car(
                carDto.getName(),
                carDto.getPrice(),
                carDto.getDescription(),
                carDto.getImagePaths()
        );
    }

    @Override
    public CarDto mapToDto(Car car) {
        return new CarDto(
                car.getId(),
                car.getName(),
                car.getPrice(),
                car.getDescription(),
                car.getImagePaths()
        );
    }
}
