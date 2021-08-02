package com.example.DRAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="MachineEntrys")
public class MachineEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Machine machine;
	
	private double hrsWorked;
	
	@ManyToOne()
    @JoinColumn(name="card_id")
	private Timecard card;
	
	public MachineEntry() {
		
	}
	public MachineEntry(Machine machine, double hrsWorked) {
		super();
		this.machine = machine;
		this.hrsWorked = hrsWorked;
	}
	public Machine getMachine() {
		return machine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	public double getHrsWorked() {
		return hrsWorked;
	}
	public void setHrsWorked(double hrsWorked) {
		this.hrsWorked = hrsWorked;
	}
	
	
}
