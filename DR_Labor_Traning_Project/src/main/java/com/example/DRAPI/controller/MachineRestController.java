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
import com.example.DRAPI.service.MachineServiceImpl;

@RestController
@RequestMapping("machineAPI")
public class MachineRestController {
	
	@Autowired
	private MachineServiceImpl service;
	
	@GetMapping("/all")
	public List<Machine> getAllMachines(){
		return service.getAllMachines();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Machine> getMachineById(@PathVariable int id){
		try {
			Machine m = service.getMachineById(id);
			return new ResponseEntity<Machine>(m,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Machine>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/MachineCode/{code}")
	public ResponseEntity<Machine> getMachineByCode(@PathVariable String code){
		try {
			Machine m = service.getMachineByCode(code);
			return new ResponseEntity<Machine>(m,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Machine>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/add")
	public void add(@RequestBody Machine m) {
		service.createMachine(m);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Machine> updateMachineByID(@PathVariable int id, @RequestBody Machine m){
		try {
			service.updateMachine(id, m);
			return new ResponseEntity<Machine>(m,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Machine>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.deleteMachineById(id);
	}
	
	
	
}
