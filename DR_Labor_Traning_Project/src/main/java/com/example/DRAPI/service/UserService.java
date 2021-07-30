package com.example.DRAPI.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.DRAPI.model.User;
import com.example.DRAPI.web.dto.UserRegistrationDto;

public interface UserService  extends UserDetailsService{
	User findUserByEmail(String username);
	User save(UserRegistrationDto reg);
}
