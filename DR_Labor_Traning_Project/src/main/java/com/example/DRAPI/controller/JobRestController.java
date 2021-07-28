package com.example.DRAPI.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DRAPI.model.Job;
import com.example.DRAPI.service.JobServiceImpl;

@RestController
@RequestMapping("jobAPI")
public class JobRestController {
	
	@Autowired
	private JobServiceImpl service;
	
	@GetMapping("/all")
	public List<Job> getAllJobs(){
		return service.getAllJobs();
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable int id){
		try {
			Job j = service.getJobById(id);
			return new ResponseEntity<Job>(j,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/JobCode/{code}")
	public ResponseEntity<Job> getJobByJobCode(@PathVariable String code){
		try {
			Job j = service.getJobByCode(code);
			return new ResponseEntity<Job>(j,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/add")
	public void add(@RequestBody Job j) {
		service.createJob(j);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Job> updateJobByID(@PathVariable int id, @RequestBody Job j){
		
		try {
			service.updateJob(id, j);
			return new ResponseEntity<Job>(j,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.deleteJobById(id);
	}
}
