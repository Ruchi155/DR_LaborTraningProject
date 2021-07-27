package com.example.DRAPI.model;
import com.example.DRAPI.model.*;
import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name ="admin")
public class Admin implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	@Size(min=7,max=50)
	String username;
	
	@NotBlank
	String password;
	
	@NotBlank
	@Email(message = "Please enter a valid e-mail address")
	String email;
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Job> job;
	
	@OneToMany(mappedBy="admin",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Machine> machine;
	
	@OneToMany(mappedBy= "admin",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Timecard> timecard;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Set<Job> getJobs() {
		return job;
	}
	public void setJobs(Set<Job> job) {
		this.job = job;
	}
	public Set<Machine> getMachines() {
		return machine;
	}
	public void setMachines(Set<Machine> machine) {
		this.machine = machine;
	}
	public Set<Timecard> getTimecard() {
		return timecard;
	}
	public void setTimecard(Set<Timecard> timecard) {
		this.timecard = timecard;
	}
	
	public Set<Job> getJob() {
		return job;
	}
	public void setJob(Set<Job> job) {
		this.job = job;
	}
	public Set<Machine> getMachine() {
		return machine;
	}
	public void setMachine(Set<Machine> machine) {
		this.machine = machine;
	}
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", job="
				+ job + ", machine=" + machine + ", timecard=" + timecard + "]";
	}
	

}
