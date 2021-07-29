package com.example.DRAPI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.DRAPI.service.AdminServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationAdmin extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AdminServiceImpl aService;

	// providing access to some type of urls for reg ,login, css, jss,html images etc
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
		auth.setUserDetailsService(aService);
		// you can add more servics here...
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	{
		auth.authenticationProvider(authencationProvider());
	}
}
