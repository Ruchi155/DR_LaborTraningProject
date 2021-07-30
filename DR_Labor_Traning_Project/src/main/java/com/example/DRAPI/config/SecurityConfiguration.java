package com.example.DRAPI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.DRAPI.service.UserServiceImpl;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserServiceImpl uService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		  http
		  	.authorizeRequests()
		  		.antMatchers("/registration**","/js","/css","/img","/webjars/**").permitAll()
		  		.anyRequest().authenticated()
		  		.and()
		  	.formLogin()
		  		.loginPage("/login")
		  		.permitAll()
		 		.and()
		 	.logout()
		 		.permitAll();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authencationProvider()
	{
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(uService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	{
		auth.authenticationProvider(authencationProvider());
	}
}
