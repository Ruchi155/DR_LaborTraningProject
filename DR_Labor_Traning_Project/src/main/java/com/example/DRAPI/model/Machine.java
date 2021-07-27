package com.example.DRAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="machines")
public class Machine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String machineCode;
	
	private String description;
	
	private double hourlyRent;
	
	private double maxHoursPerDay;
	
	public Machine() {
		
	}

	public Machine(String machineCode, String description, double hourlyRent, double maxHoursPerDay) {
		super();
		this.machineCode = machineCode;
		this.description = description;
		this.hourlyRent = hourlyRent;
		this.maxHoursPerDay = maxHoursPerDay;
	}

	public String getMachineCode() {
		return machineCode;
	}

	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHourlyRent() {
		return hourlyRent;
	}

	public void setHourlyRent(double hourlyRent) {
		this.hourlyRent = hourlyRent;
	}

	public double getMaxHoursPerDay() {
		return maxHoursPerDay;
	}

	public void setMaxHoursPerDay(double maxHoursPerDay) {
		this.maxHoursPerDay = maxHoursPerDay;
	} 
	
	

}