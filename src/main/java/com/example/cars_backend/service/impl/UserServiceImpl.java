package com.example.cars_backend.service.impl;

import com.example.cars_backend.dto.SaveImageMessage;
import com.example.cars_backend.dto.UserDto;
import com.example.cars_backend.dto.UserWithoutPasswordDto;
import com.example.cars_backend.entity.User;
import com.example.cars_backend.exception.ConvertImageToBytesException;
import com.example.cars_backend.repository.UserRepository;
import com.example.cars_backend.service.UserService;
import com.example.cars_backend.util.mapper.Mapper;
import com.example.cars_backend.util.mapper.impl.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

import static com.example.cars_backend.constants.GlobalConstants.*;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapper<User, UserDto> userMapper;
    private final RabbitTemplate rabbitTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createUser(UserDto userDto, MultipartFile avatarImage) throws ConvertImageToBytesException {
        try {
            rabbitTemplate.convertAndSend(IMAGES_EXCHANGE_NAME, IMAGES_ROUTING_KEY, new SaveImageMessage(userDto.getAvatarPath(), avatarImage.getBytes()));
            //todo password hashing
            userRepository.save(userMapper.mapToEntity(userDto));
        } catch (IOException e) {
            throw new ConvertImageToBytesException("Can't convert given image to byte array!");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public UserWithoutPasswordDto getUserById(UUID id) {
        return UserMapper.mapFromUserToUserWithoutPasswordDto(
                userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can't find user with id = " + id))
        );
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addCarToFavorites(UUID userId, UUID carId) {
        userRepository.addCarToFavorites(userId, carId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteCarFromFavorites(UUID userId, UUID carId) {
        userRepository.deleteCarFromFavorites(userId, carId);
    }
}
