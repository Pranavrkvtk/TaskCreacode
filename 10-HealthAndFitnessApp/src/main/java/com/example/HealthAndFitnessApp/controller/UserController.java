package com.example.HealthAndFitnessApp.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.HealthAndFitnessApp.commonresponse.CommonResponse;
import com.example.HealthAndFitnessApp.dto.UserDto;
import com.example.HealthAndFitnessApp.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<CommonResponse> addUser(@RequestBody UserDto userDto) {
        CommonResponse response = userService.add(userDto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(Integer.parseInt(response.getStatuscode())));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getUserById(@PathVariable UUID id) {
        CommonResponse response = userService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(Integer.parseInt(response.getStatuscode())));
    }

    @GetMapping
    public ResponseEntity<CommonResponse> getAllUsers() {
        CommonResponse response = userService.findAll();
        return new ResponseEntity<>(response, HttpStatus.valueOf(Integer.parseInt(response.getStatuscode())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateUser(@PathVariable UUID id, @RequestBody UserDto userDto) {
        CommonResponse response = userService.update(id, userDto);
        return new ResponseEntity<>(response, HttpStatus.valueOf(Integer.parseInt(response.getStatuscode())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteUser(@PathVariable UUID id) {
        CommonResponse response = userService.delete(id);
        return new ResponseEntity<>(response, HttpStatus.valueOf(Integer.parseInt(response.getStatuscode())));
    }
}
