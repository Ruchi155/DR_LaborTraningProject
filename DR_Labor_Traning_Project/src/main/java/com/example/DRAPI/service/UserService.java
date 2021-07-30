package com.example.DRAPI.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.DRAPI.model.Admin;
import com.example.DRAPI.model.Contractor;
import com.example.DRAPI.web.dto.AdminRegistrationDto;
import com.example.DRAPI.web.dto.ContractorRegistrationDto;

public interface UserService  extends UserDetailsService{
	Admin findAdminByUsername(String username);
	Contractor findContractorByUsername(String username);
	Admin save(AdminRegistrationDto reg);
	Contractor save(ContractorRegistrationDto reg);
}
