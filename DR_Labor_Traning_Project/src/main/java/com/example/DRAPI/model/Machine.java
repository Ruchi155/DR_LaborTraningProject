package com.example.DRAPI.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="machines")
public class Machine implements Serializable
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String machineCode;
	
	private String description;
	
	private double hourlyRent;
	
	private double maxHoursPerDay;
	
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;
	

	@ManyToOne
	@JoinColumn(name = "contractor_id")
	private Contractor contractor;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	} 
	

	@Override
	public String toString() {
		return "Machine [id=" + id + ", machineCode=" + machineCode + ", description=" + description + ", hourlyRent="
				+ hourlyRent + ", maxHoursPerDay=" + maxHoursPerDay + ", admin=" + admin + ", contractor=" + contractor
				+ "]";
	}


	
	

}
