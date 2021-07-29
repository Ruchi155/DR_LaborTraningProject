package com.example.DRAPI.web.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AdminRegistrationDto {
	 	@NotEmpty
	    private String name;

	    @NotEmpty
	    private String password;

	    @NotEmpty
	    private String confirmPassword;

	    @Email
	    @NotEmpty
	    private String email;

	    @Email
	    @NotEmpty
	    private String confirmEmail;
	    
	    @NotEmpty
	    private String username;
	    
	    @AssertTrue
	    private Boolean terms;

		public String getName() {
			return this.name;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
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

		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
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
