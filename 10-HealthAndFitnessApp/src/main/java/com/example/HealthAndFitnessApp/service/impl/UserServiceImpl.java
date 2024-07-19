package com.example.HealthAndFitnessApp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.HealthAndFitnessApp.commonresponse.CommonResponse;
import com.example.HealthAndFitnessApp.dto.UserDto;
import com.example.HealthAndFitnessApp.model.User;
import com.example.HealthAndFitnessApp.repository.IUserRepository;
import com.example.HealthAndFitnessApp.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public CommonResponse add(UserDto userDto) {
        try {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            user.setId(UUID.randomUUID()); // Generate a new UUID for the user
            User savedUser = userRepository.save(user);
            UserDto savedUserDto = new UserDto();
            BeanUtils.copyProperties(savedUser, savedUserDto);
            return new CommonResponse("User added successfully", "201", savedUserDto);
        } catch (Exception e) {
            return new CommonResponse("Error adding user: " + e.getMessage(), "500");
        }
    }

    @Override
    public CommonResponse findById(UUID id) {
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(user, userDto);
                return new CommonResponse("User found", "200", userDto);
            } else {
                return new CommonResponse("User not found", "404");
            }
        } catch (Exception e) {
            return new CommonResponse("Error finding user: " + e.getMessage(), "500");
        }
    }

    @Override
    public CommonResponse findAll() {
        try {
            List<User> users = userRepository.findAll();
            List<UserDto> userDtos = users.stream()
                    .map(user -> {
                        UserDto userDto = new UserDto();
                        BeanUtils.copyProperties(user, userDto);
                        return userDto;
                    })
                    .collect(Collectors.toList());
            return new CommonResponse("All users retrieved successfully", "200", userDtos);
        } catch (Exception e) {
            return new CommonResponse("Error retrieving users: " + e.getMessage(), "500");
        }
    }

    @Override
    public CommonResponse update(UUID id, UserDto userDto) {
        try {
            Optional<User> existingUserOptional = userRepository.findById(id);
            if (existingUserOptional.isPresent()) {
                User existingUser = existingUserOptional.get();
                BeanUtils.copyProperties(userDto, existingUser);
                existingUser.setId(id); // Ensure the ID is not changed
                User updatedUser = userRepository.save(existingUser);
                UserDto updatedUserDto = new UserDto();
                BeanUtils.copyProperties(updatedUser, updatedUserDto);
                return new CommonResponse("User updated successfully", "200", updatedUserDto);
            } else {
                return new CommonResponse("User not found", "404");
            }
        } catch (Exception e) {
            return new CommonResponse("Error updating user: " + e.getMessage(), "500");
        }
    }

    @Override
    public CommonResponse delete(UUID id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return new CommonResponse("User deleted successfully", "200");
            } else {
                return new CommonResponse("User not found", "404");
            }
        } catch (Exception e) {
            return new CommonResponse("Error deleting user: " + e.getMessage(), "500");
        }
    }
}
