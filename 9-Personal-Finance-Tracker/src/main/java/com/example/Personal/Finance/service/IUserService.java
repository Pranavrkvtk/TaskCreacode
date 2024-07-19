package com.example.Personal.Finance.service;

import java.util.List;
import java.util.UUID;

import org.apache.el.stream.Optional;

import com.example.Personal.Finance.commonResponse.CommonResponse;
import com.example.Personal.Finance.model.User;

public interface IUserService {


	CommonResponse addUser(User user);

	CommonResponse updateUser(User user);


	List<User> getAllUsers();

	CommonResponse deleteUser(UUID id);
}
