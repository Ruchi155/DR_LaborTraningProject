package com.example.DRAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DRAPI.model.Admin;
import com.example.DRAPI.service.UserServiceImpl;
import com.example.DRAPI.web.dto.AdminRegistrationDto;
import com.example.DRAPI.web.dto.ContractorRegistrationDto;
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	@Autowired
	private UserServiceImpl uService;
	
	@ModelAttribute("admin")
	public AdminRegistrationDto adminRegistration() {
		return new AdminRegistrationDto();
	}
	@ModelAttribute("contractor")
	public ContractorRegistrationDto contractorRegistration() {
		return new ContractorRegistrationDto();
	}
	
//	@ModelAttribute("")
	@GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }
	
	@PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid AdminRegistrationDto userDto,
                                      BindingResult result){

        Admin existing = uService.findAdminByUsername(userDto.getUsername());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration";
        }

        uService.save(userDto);
        return "redirect:/registration?success";
    }
}
