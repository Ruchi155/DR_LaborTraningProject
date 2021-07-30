package com.example.DRAPI.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.DRAPI.model.User;
import com.example.DRAPI.repo.UserRepo;
import com.example.DRAPI.web.dto.UserRegistrationDto;
import com.example.DRAPI.model.Role;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo uRepo;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public User findUserByEmail(String email) {
		return uRepo.findUserByEmail(email);
	}

	@Override
	public User save(UserRegistrationDto registration) {
		 User user = new User();
	        user.setFirstName(registration.getFirstName());
	        user.setLastName(registration.getLastName());
	        user.setEmail(registration.getEmail());
	        user.setPassword(passwordEncoder.encode(registration.getPassword()));
	        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
		return uRepo.save(user);
	}

	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = uRepo.findUserByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
