package com.example.DRAPI.service;

import com.example.DRAPI.model.Job;

public interface JobService {
	public void updateJob(int id, Job j);
	public Job getJobById(int id);
	public Job getJobByCode(String code);
	public void createJob(Job j);
	public void deleteJobById(int id);
}
