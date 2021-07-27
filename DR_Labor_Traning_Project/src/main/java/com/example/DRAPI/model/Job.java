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
@Table(name="jobs")
public class Job implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String jobCode;
	
	private String description;
	
	private double hourlyRate;
	
	private double maxHoursPerDay;
	
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;
	
	@ManyToOne
	@JoinColumn(name = "contractor_id")
	private Contractor contractor;
	
	
	
	public Job() {
		
	}

	public Job(String jobCode, String description, double hourlyRate, double maxHoursPerDay) {
		super();
		this.jobCode = jobCode;
		this.description = description;
		this.hourlyRate = hourlyRate;
		this.maxHoursPerDay = maxHoursPerDay;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
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
		return "Job [id=" + id + ", jobCode=" + jobCode + ", description=" + description + ", hourlyRate=" + hourlyRate
				+ ", maxHoursPerDay=" + maxHoursPerDay + ", admin=" + admin + ", contractor=" + contractor + "]";
	}

	
	
}
