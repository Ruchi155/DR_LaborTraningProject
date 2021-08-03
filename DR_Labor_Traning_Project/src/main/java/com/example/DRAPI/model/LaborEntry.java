package com.example.DRAPI.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LaborEntrys")
public class LaborEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Job laborCode;
	private double hrsWorked;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="card_id")
	private Timecard card;
	
	public LaborEntry() {
		
	}
	public LaborEntry(Job laborCode, double hrsWorked) {
		super();
		this.laborCode = laborCode;
		this.hrsWorked = hrsWorked;
	}
	public Job getLaborCode() {
		return laborCode;
	}
	public void setLaborCode(Job laborCode) {
		this.laborCode = laborCode;
	}
	public double getHrsWorked() {
		return hrsWorked;
	}
	public void setHrsWorked(double hrsWorked) {
		this.hrsWorked = hrsWorked;
	}
	
	
}
