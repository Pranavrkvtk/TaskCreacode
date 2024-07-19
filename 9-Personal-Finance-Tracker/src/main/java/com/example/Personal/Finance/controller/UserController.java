package com.example.Personal.Finance.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Personal.Finance.commonResponse.CommonResponse;
import com.example.Personal.Finance.model.User;
import com.example.Personal.Finance.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<CommonResponse> addUser(@RequestBody User user) {
        CommonResponse response = userService.addUser(user);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommonResponse> updateUser(@PathVariable UUID id, @RequestBody User user) {
        user.setId(id);
        CommonResponse response = userService.updateUser(user);
        return ResponseEntity.ok(response);
    }

   

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteUser(@PathVariable UUID id) {
        CommonResponse response = userService.deleteUser(id);
        return ResponseEntity.ok(response);
    }}
