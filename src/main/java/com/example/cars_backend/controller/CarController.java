package com.example.cars_backend.controller;

import com.example.cars_backend.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCarById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(Map.of("car", carService.getCarById(id)));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCars(@RequestParam(defaultValue = "0", required = false) int page,
                                     @RequestParam(defaultValue = "10", required = false) int size) {
        return ResponseEntity.ok().body(Map.of("cars", carService.getCars(page, size)));
    }

}
