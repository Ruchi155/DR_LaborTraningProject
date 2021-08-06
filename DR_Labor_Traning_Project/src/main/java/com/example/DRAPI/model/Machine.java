package com.example.DRAPI.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="machines")
public class Machine implements Serializable
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 3, max = 13, message="Need to have a machine code between lengths 3 and 13")
	private String machineCode;
	
	@Min(value = 5, message ="Description needs to be at least 5 characters long")
	@Max(value = 20, message ="Description needs to be less than 20 characters long")
	private String description;
	
	private double hourlyRent;
	
	@Min(value = 1, message ="Needs to be available at least one hour a day")
	@Max(value = 24, message ="Can't be available for more than 24 hours per day")
	private double maxHoursPerDay;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "machine", fetch = FetchType.LAZY)
	private Set<Timecard> timecards;

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



	@Override
	public String toString() {
		return "Machine [machineCode=" + machineCode + ", description=" + description + ", hourlyRent="
				+ hourlyRent + ", maxHoursPerDay=" + maxHoursPerDay + "]";
	}
	public Set<Timecard> getTimecards() {
		return timecards;
	}
	public void setTimecards(Set<Timecard> timecards) {
		this.timecards = timecards;
	}


	
	

}
