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
	
	@ManyToOne
	@JoinColumn(name = "contractor_id")
	private User contractor;
	
	private double totalHours;
	
	private double totalAmount;
	
	private boolean approved;
	
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="timecards_machines", 
		joinColumns = {@JoinColumn(name = "timecard_id")},
		inverseJoinColumns = {@JoinColumn(name="machine_id")})
	private Set<Machine> machines;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="timecards_jobs", 
		joinColumns = {@JoinColumn(name = "timecard_id")},
		inverseJoinColumns = {@JoinColumn(name="jobs_id")})
	private Set<Job> jobs;

	public Timecard() {
		
	}
	public Timecard(String siteCode, User contractor, double totalHours, double totalAmount) {
		super();
		this.siteCode = siteCode;
		this.contractor = contractor;
		this.totalHours = totalHours;
		this.totalAmount = totalAmount;
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

	public double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(double totalHours) {
		this.totalHours = totalHours;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Timecard [siteCode=" + siteCode + ", contractor=" + contractor + ", totalHours="
				+ totalHours + ", totalAmount=" + totalAmount + "]";
	}
	public Set<Machine> getMachines() {
		return machines;
	}
	public void setMachines(Set<Machine> machines) {
		this.machines = machines;
	}
	public Set<Job> getJobs() {
		return jobs;
	}
	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}


	
	
	
}
