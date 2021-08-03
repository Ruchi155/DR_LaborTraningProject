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
	private Contractor contractor;
	
	private double totalHoursJob;
	
<<<<<<< Updated upstream
=======
	private double totalHoursJob;
	
>>>>>>> Stashed changes
	private double totalAmountjob;
	
	private double totalHoursMachine;
	
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="timecards_machines", 
		joinColumns = {@JoinColumn(name = "timecard_id")},
		inverseJoinColumns = {@JoinColumn(name="machine_id")})
	private Set<Machine> machines;
=======
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;

	public Timecard() {
		
	}
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	public Timecard(String siteCode, Contractor contractor, double totalHours, double totalAmount) {
=======
=======
>>>>>>> Stashed changes


	public Timecard(String siteCode, User contractor, double totalHoursJob, double totalAmountjob,
			double totalHoursMachine, double totalAmountMachine, boolean approved, Machine machine, Job job) {
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
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

	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
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
<<<<<<< Updated upstream
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
=======
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
>>>>>>> Stashed changes
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
