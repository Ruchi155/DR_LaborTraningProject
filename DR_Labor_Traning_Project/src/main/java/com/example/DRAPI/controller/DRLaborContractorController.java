package com.example.DRAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.service.JobService;
import com.example.DRAPI.service.MachineService;
import com.example.DRAPI.service.TimecardService;
import com.example.DRAPI.service.UserService;

@Controller
@RequestMapping("/contractor") 
public class DRLaborContractorController {
	
	@Autowired
	TimecardService timecardserv;
	
	@Autowired
	JobService jobserv;
	
	@Autowired
	MachineService machineserv;
	
	@Autowired
	UserService uService;
	
	@GetMapping
	public String contractorMain() {
		return "contractor_main";
	}
	
	/* Timecard Controller */
	
	@RequestMapping("/newtimecard")
	public String addnewTimecard(Model model) {
		Timecard tc = new Timecard();
		model.addAttribute("timecard", tc);
		return "new_timecard";
	}
	@RequestMapping(value= "/savetimecard", method=RequestMethod.POST)
	public String saveTimecard(@ModelAttribute("timecard") Timecard tc)
	{
		timecardserv.SaveTimecard(tc);
		return "redirect:/contractor/list_timecards";
	}
	
	@RequestMapping("list_timecards")
	public String listtimecards(Model model) {
		List<Timecard> list = timecardserv.getAllTimecards();
		model.addAttribute("timecards", list);
		return "contractor_timecard";	
	}
	
	@RequestMapping("/deletetimecard/{id}")
	public String deleteTimecard(@PathVariable(name="id") int id)
	{
		timecardserv.deleteTimecardById(id);
		return "redirect:/contractor/list_timecards";
		
	}

	@RequestMapping("/edittimecard/{id}")
	public ModelAndView showEditTimecardPage(@PathVariable(name="id") int id)
	{
		ModelAndView mav= new ModelAndView("edit_timecard");
		Timecard tc= timecardserv.get(id);
		mav.addObject("timecard",tc);
		return mav;
	}

	
}
