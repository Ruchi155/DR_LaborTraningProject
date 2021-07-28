package com.example.DRAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DRAPI.model.Job;
import com.example.DRAPI.model.Machine;
import com.example.DRAPI.repo.MachineRepo;

@Service
public class MachineServiceImpl implements MachineService{

	@Autowired 
	MachineRepo repo;
	
	@Override
	public void updateMachine(int id, Machine m) {
		Machine temp = repo.getById(id);
		temp.setDescription(m.getDescription());
		temp.setHourlyRent(m.getHourlyRent());
		temp.setMachineCode(m.getMachineCode());
		temp.setMaxHoursPerDay(m.getMaxHoursPerDay());
		repo.save(temp);
	}

	@Override
	public Machine getMachineById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Machine getMachineByCode(String code) {
		return repo.findMachineByCode(code);
	}

	@Override
	public void createMachine(Machine m) {
		repo.save(m);
	}

	@Override
	public void deleteMachineById(int id) {
		repo.delete(repo.getById(id));
	}

	@Override
	public List<Machine> getAllMachines() {
		return repo.findAll();
	}

}
