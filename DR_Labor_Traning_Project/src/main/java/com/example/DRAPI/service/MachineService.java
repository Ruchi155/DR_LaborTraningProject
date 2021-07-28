package com.example.DRAPI.service;

import java.util.List;

import com.example.DRAPI.model.Job;
import com.example.DRAPI.model.Machine;

public interface MachineService {
	public void updateMachine(int id, Machine m);
	public Machine getMachineById(int id);
	public Machine getMachineByCode(String code);
	public void createMachine(Machine m);
	public void deleteMachineById(int id);
	public List<Machine> getAllMachines();
	public void SaveMachine(Machine m);
	public Machine get(int id);
}
