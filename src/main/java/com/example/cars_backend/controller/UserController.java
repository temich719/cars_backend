package com.example.cars_backend.controller;

import com.example.cars_backend.dto.RestResponse;
import com.example.cars_backend.dto.UserDto;
import com.example.cars_backend.exception.ConvertImageToBytesException;
import com.example.cars_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping(
            value = "/user",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public RestResponse createUser(@RequestPart("user") UserDto userDto,
                                   @RequestPart("avatar") MultipartFile avatarImage) throws ConvertImageToBytesException {
        userService.createUser(userDto, avatarImage);
        return new RestResponse("User successfully created!");
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(Map.of("user", userService.getUserById(id)));
    }

    //todo with @AuthenticationPrinciple two rest methods from service

}
