package com.example.DRAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.DRAPI.model.Admin;
import com.example.DRAPI.model.Contractor;
import com.example.DRAPI.repo.AdminRepo;
import com.example.DRAPI.repo.ContractorRepo;
import com.example.DRAPI.web.dto.AdminRegistrationDto;
import com.example.DRAPI.web.dto.ContractorRegistrationDto;
import org.springframework.security.core.userdetails.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private AdminRepo aRepo;
	
	@Autowired
	private ContractorRepo cRepo;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Admin findAdminByUsername(String username) {
		return aRepo.findAdminByUsername(username);
	}
	
	@Override
	public Contractor findContractorByUsername(String username) {
		return cRepo.findContractorByUsername(username);
	}
	
	@Override
	public Admin save(AdminRegistrationDto reg) {
		Admin a = new Admin();
		a.setEmail(reg.getEmail());
		a.setName(reg.getName());
		a.setPassword(passwordEncoder.encode(reg.getPassword()));
		a.setUsername(reg.getUsername());
		return a;
	}
	
	@Override
	public Contractor save(ContractorRegistrationDto reg) {
		Contractor c = new Contractor();
		c.setEmail(reg.getConfirmEmail());
		c.setName(reg.getName());
		c.setPassword(passwordEncoder.encode(reg.getPassword()));
		c.setUsername(reg.getUsername());
		return c;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin a = aRepo.findAdminByUsername(username);
		Contractor c;
		if(a == null) {
			c = cRepo.findContractorByUsername(username);
			if(c== null) {
				throw new UsernameNotFoundException("Invalid username or password.");
			} else {
				return new User(c.getEmail(),
		                c.getPassword(), null);
			}
		} else {
			return new User(a.getUsername(),a.getPassword(),null);
		}
	}

}
