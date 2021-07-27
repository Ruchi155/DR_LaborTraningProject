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

import com.example.DRAPI.model.Machine;
import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.service.TimecardServiceImpl;

@RestController
@RequestMapping("timecardAPI")
public class TimecardRestController {
	
	@Autowired
	private TimecardServiceImpl service;
	
	@GetMapping("/all")
	public List<Timecard> getAllTimeCard(){
		return service.getAllTimecards();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Timecard> getMachineById(@PathVariable int id){
		try {
			Timecard t = service.getTimecardById(id);
			return new ResponseEntity<Timecard>(t,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Timecard>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/SiteCode/{code}")
	public ResponseEntity<Timecard> getMachineByCode(@PathVariable String code){
		try {
			Timecard t = service.getTimecardByCode(code);
			return new ResponseEntity<Timecard>(t,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Timecard>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Timecard t) {
		service.createTimecard(t);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Timecard> updateMachineByID(@PathVariable int id, @RequestBody Timecard t){
		try {
			service.updateTimecard(id, t);
			return new ResponseEntity<Timecard>(t,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Timecard>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.deleteTimecardById(id);
	}
	
	
	
	
}
