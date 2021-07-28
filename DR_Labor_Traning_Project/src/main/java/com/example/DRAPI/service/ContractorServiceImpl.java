package com.example.DRAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DRAPI.model.Admin;
import com.example.DRAPI.model.Contractor;
import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.repo.ContractorRepo;
import com.example.DRAPI.repo.TimecardRepo;

@Service
public class ContractorServiceImpl implements ContractorService
{

	@Autowired 
	ContractorRepo contractorrepo;
	
	@Override
	public Contractor getContractorById(Long id) 
	{
		return contractorrepo.findById(id).get();
	}
}
