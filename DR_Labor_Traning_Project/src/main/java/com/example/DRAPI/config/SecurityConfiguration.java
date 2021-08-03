package com.example.DRAPI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.example.DRAPI.controller.LoginSuccessHandler;
import com.example.DRAPI.service.UserServiceImpl;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserServiceImpl uService;
	
	@Autowired private LoginSuccessHandler loginSuccessHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		  http
		  	.csrf().disable()
		  	.authorizeRequests()
		  		.antMatchers("/registration**","/js","/css","/img","/webjars/**").permitAll()
		  		.antMatchers("/admin/**").hasAuthority("Admin")
		  		.antMatchers("/contractor/**").hasAuthority("Contractor")
//		  		.anyRequest().authenticated()
//		  		.antMatchers("/contractor").access("hasRole('Admin')")
//		  		.antMatchers("/admin").access("hasRole('Contractor')")
		  		.and()
		  	.formLogin()

		  		.loginPage("/login")
		  		.permitAll()
		  		.successHandler(loginSuccessHandler)
		 		.and()

		 	.logout()
		 		.invalidateHttpSession(true)
		 		.clearAuthentication(true)
		 		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		 		.logoutSuccessUrl("/login?logout")
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
