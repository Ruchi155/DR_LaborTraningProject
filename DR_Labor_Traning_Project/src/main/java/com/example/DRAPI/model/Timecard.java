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
@Table(name="timecards")
public class Timecard implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String siteCode;
	
	private String contractor;
	
	private double totalHours;
	
	private double totalAmount;
	
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Admin admin;
	

	@ManyToOne
	@JoinColumn(name = "contractor_id")
	private Contractor contract;
		public Timecard() {
		
	}

	public Timecard(String siteCode, String contractor, double totalHours, double totalAmount) {
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

	public String getContractor() {
		return contractor;
	}

	public void setContractor(String contractor) {
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Contractor getContract() {
		return contract;
	}

	public void setContract(Contractor contract) {
		this.contract = contract;
	}
	
	@Override
	public String toString() {
		return "Timecard [id=" + id + ", siteCode=" + siteCode + ", contractor=" + contractor + ", totalHours="
				+ totalHours + ", totalAmount=" + totalAmount + ", admin=" + admin + ", contract=" + contract + "]";
	}


	
	
	
}
