package com.example.DRAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DRAPI.model.Admin;
import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	AdminRepo adminrepo;
	
	/*
	@Override
	public Admin get(int i) {
		return adminrepo.findById(i).get();
	}
	
	*/
}

	

	

	

