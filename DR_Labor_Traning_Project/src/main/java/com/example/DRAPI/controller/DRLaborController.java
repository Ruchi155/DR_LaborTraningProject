package com.example.DRAPI.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.DRAPI.model.Job;
import com.example.DRAPI.model.Machine;
import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.model.User;
import com.example.DRAPI.service.JobService;
import com.example.DRAPI.service.MachineService;
import com.example.DRAPI.service.TimecardService;
import com.example.DRAPI.service.UserService;

@Controller
public class DRLaborController 
{

	@Autowired
	TimecardService timecardserv;
	
	@Autowired
	JobService jobserv;
	
	@Autowired
	MachineService machineserv;
	@Autowired
	UserService uService;
	
//	@PostMapping("/root/{email}")
//	public ModelAndView dashboardSelector(@PathVariable(name="email") String email){
//		
//			User u = uService.findUserByEmail(email);
//			ModelAndView mav= new ModelAndView();
//			
//			if(u.getRole().equals("Contractor")) {
//				mav= new ModelAndView("contractor_main");
//			}else {
//				mav= new ModelAndView("admin_main");
//			}
//			
//			mav.addObject("user",u);
//			return mav;
//	}
	
	@PostMapping("/logout")
	public String logoutDo(HttpServletRequest request,HttpServletResponse response){
	HttpSession session= request.getSession(false);
	    SecurityContextHolder.clearContext();
	         session= request.getSession(false);
	        if(session != null) {
	            session.invalidate();
	        }
	        for(Cookie cookie : request.getCookies()) {
	            cookie.setMaxAge(0);
	        }

	    return " login";
	}
	@RequestMapping()
	public String main() {
		return "login";
		
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	

	
}
