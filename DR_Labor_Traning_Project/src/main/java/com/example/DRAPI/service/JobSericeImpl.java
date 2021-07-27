package com.example.DRAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DRAPI.model.Job;
import com.example.DRAPI.repo.JobRepo;

@Service
public class JobSericeImpl implements JobService {

	@Autowired
	JobRepo repo;
	
	@Override
	public void updateJob(int id, Job j) {
		Job temp = repo.getById(id);
		temp.setHourlyRate(j.getHourlyRate());
		temp.setDescription(j.getDescription());
		temp.setJobCode(j.getJobCode());
		temp.setMaxHoursPerDay(j.getMaxHoursPerDay());
	}

	@Override
	public Job getJobById(int id) {
		return repo.getById(id);
	}

	@Override
	public Job getJobByCode(String code) {
		return repo.findJobByCode(code);
	}

	@Override
	public void createJob(Job j) {
		repo.save(j);
	}

	@Override
	public void deleteJobById(int id) {
		repo.delete(repo.getById(id));
	}

}
