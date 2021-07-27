package com.example.DRAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DRAPI.repo.AdminRepo;

@Service
public class AdminServiceImpl 
{
	@Autowired
	AdminRepo admin;

}
