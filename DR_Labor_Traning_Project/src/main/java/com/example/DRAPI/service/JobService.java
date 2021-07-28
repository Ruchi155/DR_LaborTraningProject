package com.example.DRAPI.service;

import java.util.List;

import com.example.DRAPI.model.Job;

public interface JobService {
	public void updateJob(int id, Job j);
	public Job getJobById(int id);
	public Job getJobByCode(String code);
	public void createJob(Job j);
	public void deleteJobById(int id);
	public List<Job> getAllJobs();
	public void SaveJob(Job j);
	public Job get(int id);
}
