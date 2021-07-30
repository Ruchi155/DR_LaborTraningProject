package com.example.DRAPI.web.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Email;

public class ContractorRegistrationDto {
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	@Email()
	private String email;
	
	@Email
    @NotEmpty
    private String confirmEmail;

    @AssertTrue
    private Boolean terms;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

	public Boolean getTerms() {
		return terms;
	}

	public void setTerms(Boolean terms) {
		this.terms = terms;
	}
}
