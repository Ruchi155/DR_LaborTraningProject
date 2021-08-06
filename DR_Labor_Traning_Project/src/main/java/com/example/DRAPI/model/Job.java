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
@Table(name="jobs")
public class Job implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 3, max = 13, message="Need to have a job code between lengths 3 and 13")
	private String jobCode;
	
	@Min(value = 5, message ="Description needs to be at least 5 characters long")
	@Max(value = 20, message ="Description needs to be less than 20 characters long")
	private String description;
	
	private double hourlyRate;
	
	@Min(value = 1, message ="Needs to be available at least one hour a day")
	@Max(value = 24, message ="Can't be available for more than 24 hours per day")
	private double maxHoursPerDay;

	@OneToMany(cascade=CascadeType.ALL,mappedBy = "job", fetch = FetchType.LAZY)
	private Set<Timecard> timecard;
	
	public Set<Timecard> getTimecard() {
		return timecard;
	}

	public void setTimecard(Set<Timecard> timecard) {
		this.timecard = timecard;
	}

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
	
	public void setId(int id){
		this.id = id;
	}
	@Override
	public String toString() {
		return "Job [jobCode=" + jobCode + ", description=" + description + ", hourlyRate=" + hourlyRate
				+ ", maxHoursPerDay=" + maxHoursPerDay + "]";
	}

	
	
}
