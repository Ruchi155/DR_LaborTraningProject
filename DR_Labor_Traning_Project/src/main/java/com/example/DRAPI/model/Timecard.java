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

@Entity
@Table(name="timecards")
public class Timecard implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String siteCode;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "contractor_id")
	private User contractor;
	
	private double totalHoursJob;
	
	private double totalAmountjob;
	
	private double totalHoursMachine;
	
	private double totalAmountMachine;
	private boolean approved;
	
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	@ManyToOne
	@JoinColumn(name="machine_id")
	private Machine machine;
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;

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
