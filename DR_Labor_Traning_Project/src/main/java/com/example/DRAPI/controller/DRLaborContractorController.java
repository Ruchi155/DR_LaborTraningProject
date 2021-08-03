package com.example.DRAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String contractorMain(Authentication authentication) {
//		String info = authentication.getName()
		return "contractor_main";
	}
	
	/* Timecard Controller */
	
	@RequestMapping("/newtimecard")
	public String addnewTimecard(Model model, Authentication authentication) {
		Timecard tc = new Timecard();
		List<Machine> machines = machineserv.getAllMachines();
		List<Job> jobs = jobserv.getAllJobs();
		User u = uService.findUserByEmail(authentication.getName());
		System.out.println(authentication.getName());
		model.addAttribute("contractor",u);
		model.addAttribute("labor", jobs);
		model.addAttribute("machines",machines);
		model.addAttribute("timecard", tc);
		return "new_timecard";
	}
	@RequestMapping(value= "/savetimecard", method=RequestMethod.POST)
	public String saveTimecard(@ModelAttribute("timecard") Timecard tc,Authentication authentication)
	{	
		User u = uService.findUserByEmail(authentication.getName());
		
		tc.setContractor(u);
		tc.setMachine(machineserv.getMachineByCode(tc.getMachineString()));
		tc.setJob(jobserv.getJobByCode(tc.getJobString()));
		timecardserv.SaveTimecard(tc);
		
		return "redirect:/contractor/list_timecards";
	}
	@RequestMapping(value= "/saveTimecardEdit/{id}", method=RequestMethod.POST)
	public String saveTimecardEdit(@PathVariable(name="id") int id, @ModelAttribute("timecard") Timecard tc,Authentication auth)
	{	
		User u = uService.findUserByEmail(auth.getName());
		
		tc.setContractor(u);
		tc.setMachine(machineserv.getMachineByCode(tc.getMachineString()));
		tc.setJob(jobserv.getJobByCode(tc.getJobString()));
		timecardserv.SaveTimecard(tc);
		return "redirect:/contractor/list_timecards";
	}
	
	@RequestMapping("list_timecards")
	public String listtimecards(Model model, Authentication authentication) {
		List<Timecard> list = timecardserv.getTimecardsByUser(uService.findUserByEmail(authentication.getName()));
		
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
	public ModelAndView showEditTimecardPage(@PathVariable(name="id") int id, Authentication authentication)
	{
		User u = uService.findUserByEmail(authentication.getName());
		ModelAndView mav = new ModelAndView("edit_timecard");
		List<Machine> machines = machineserv.getAllMachines();
		List<Job> jobs = jobserv.getAllJobs();
		Timecard tc = timecardserv.get(id);
		Machine machine = tc.getMachine();
		Job job = tc.getJob();
		mav.addObject("contractor",u);
		mav.addObject("labor", jobs);
		mav.addObject("machines",machines);
		mav.addObject("machine",machine);
		mav.addObject("timecard",tc);
		mav.addObject("job",job);
		return mav;
	}

	
}
