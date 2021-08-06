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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name="timecards")
public class Timecard implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 3, max = 13, message="Need to have a site code between lengths 3 and 13")
	private String siteCode;
	
	@ManyToOne()
	@JoinColumn(name = "contractor_id")
	private User contractor;
	
	@Min(value = 1, message ="Needs to be  at least one hour a day")
	@Max(value = 24, message ="Can't be for more than 24 hours per day")
	private double totalHoursJob;
	
	@Positive(message="Needs to be positive")
	private double totalAmountjob;
	
	@Min(value = 1, message ="Needs to be  at least one hour a day")
	@Max(value = 24, message ="Can't be for more than 24 hours per day")
	private double totalHoursMachine;
	
	@Positive(message="Needs to be positive")
	private double totalAmountMachine;
	
	
	private boolean approved;
	

	@ManyToOne
	@JoinColumn(name="machine_id")
	private Machine machine;
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;

	private String machineString;
	
	private String jobString;

	public Timecard() {
		
	}


	public Timecard(String siteCode, User contractor, double totalHoursJob, double totalAmountjob,
			double totalHoursMachine, double totalAmountMachine, boolean approved, Machine machine, Job job) {
		super();
		this.siteCode = siteCode;
		this.contractor = contractor;
		this.totalHoursJob = totalHoursJob;
		this.totalAmountjob = totalAmountjob;
		this.totalHoursMachine = totalHoursMachine;
		this.totalAmountMachine = totalAmountMachine;
		this.approved = approved;
		this.machine = machine;
		this.job = job;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public String getMachineString() {
		return machineString;
	}
	public void setMachineString(String machineString) {
		this.machineString = machineString;
	}
	public String getJobString() {
		return jobString;
	}
	public void setJobString(String jobString) {
		this.jobString = jobString;
	}
	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public User getContractor() {
		return contractor;
	}

	public void setContractor(User contractor) {
		this.contractor = contractor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Timecard [siteCode=" + siteCode + ", contractor=" + contractor + "]";
	}
	public Machine getMachine() {
		return machine;
	}
	public double getTotalHoursJob() {
		return totalHoursJob;
	}
	public void setTotalHoursJob(double totalHoursJob) {
		this.totalHoursJob = totalHoursJob;
	}
	public double getTotalAmountjob() {
		return totalAmountjob;
	}
	public void setTotalAmountjob(double totalAmountjob) {
		this.totalAmountjob = totalAmountjob;
	}
	public double getTotalHoursMachine() {
		return totalHoursMachine;
	}
	public void setTotalHoursMachine(double totalHoursMachine) {
		this.totalHoursMachine = totalHoursMachine;
	}
	public double getTotalAmountMachine() {
		return totalAmountMachine;
	}
	public void setTotalAmountMachine(double totalAmountMachine) {
		this.totalAmountMachine = totalAmountMachine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}



	
	
	
}
