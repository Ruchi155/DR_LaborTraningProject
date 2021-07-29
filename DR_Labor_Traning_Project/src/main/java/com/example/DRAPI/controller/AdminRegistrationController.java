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
import com.example.DRAPI.service.AdminServiceImpl;
import com.example.DRAPI.web.dto.AdminRegistrationDto;

@Controller
@RequestMapping("/admin/registration")
public class AdminRegistrationController {
	@Autowired
	AdminServiceImpl aService;
	
	@GetMapping
    public String showRegistrationForm(Model model) {
        return "admin/registration";
    }
	
	@PostMapping
    public String registerAdminAccount(@ModelAttribute("admin") @Valid AdminRegistrationDto adminDto,
                                      BindingResult result){
        Admin existing = aService.getAdminByUsername(adminDto.getUsername());
        if (existing != null){
            result.rejectValue("username", null, "There is already an account registered with that username");
        }
        if (result.hasErrors()){
            return "admin/registration";
        }
        aService.save(adminDto);
        return "redirect:/admin/registration?success";
    }
}
