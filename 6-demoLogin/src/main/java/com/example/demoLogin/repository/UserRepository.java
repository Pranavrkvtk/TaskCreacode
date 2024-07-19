package com.example.demoLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoLogin.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
