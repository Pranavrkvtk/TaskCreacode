package com.example.Personal.Finance.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Personal.Finance.commonResponse.CommonResponse;
import com.example.Personal.Finance.model.User;
import com.example.Personal.Finance.repository.UserRepository;
import com.example.Personal.Finance.service.IUserService;

@Service
public class ServiceImpl implements IUserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public CommonResponse addUser(User user) {
        try {
            userRepository.save(user);
            return new CommonResponse("SUCCESS", "User added successfully.",user);
        } catch (Exception e) {
            return new CommonResponse("FAILURE", "Error adding user: " + e.getMessage());
        }
    }

    @Override
    public CommonResponse updateUser(User user) {
        try {
            if (userRepository.existsById(user.getId())) {
                userRepository.save(user);
                return new CommonResponse("SUCCESS", "User updated successfully.");
            } else {
                return new CommonResponse("FAILURE", "User not found.");
            }
        } catch (Exception e) {
            return new CommonResponse("FAILURE", "Error updating user: " + e.getMessage());
        }
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public CommonResponse deleteUser(UUID id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                return new CommonResponse("SUCCESS", "User deleted successfully.");
            } else {
                return new CommonResponse("FAILURE", "User not found.");
            }
        } catch (Exception e) {
            return new CommonResponse("FAILURE", "Error deleting user: " + e.getMessage());
}}}