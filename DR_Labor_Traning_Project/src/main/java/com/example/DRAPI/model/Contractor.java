package com.example.DRAPI.model;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="contractor")
public class Contractor implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	String username;
	@NotBlank
	@Size(min=8, message="password must contains 8 character")	
	String password;
	
	String email;
	
	@OneToMany(mappedBy= "contractor",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Timecard> timecard;
	
	
	public Contractor() {
		
	}
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Contractor [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}

}
