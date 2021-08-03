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

import com.example.DRAPI.model.Job;
import com.example.DRAPI.model.Machine;
import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.model.User;
import com.example.DRAPI.service.JobService;
import com.example.DRAPI.service.MachineService;
import com.example.DRAPI.service.TimecardService;
import com.example.DRAPI.service.UserService;

@Controller
@RequestMapping("/admin")
public class DRLaborAdminController {
	
	@Autowired
	TimecardService timecardserv;
	
	@Autowired
	JobService jobserv;
	
	@Autowired
	MachineService machineserv;
	
	@Autowired
	UserService uService;
	
	//Default admin
	@GetMapping
	public String adminMain() {
		return "admin_main";
	}
	
	//TIMECARD 
	@RequestMapping("list_timecards")
	public String listtimecards(Model model) {
		List<Timecard> list = timecardserv.getAllTimecards();
		model.addAttribute("timecards", list);
		return "timecard";	
	}
	
	@RequestMapping("timecards/review/{id}")
	public ModelAndView finalizeTimecards(@PathVariable(name="id") int id) {
		ModelAndView mav= new ModelAndView("view_timecard");
		
		Timecard t = timecardserv.get(id);
		User u = t.getContractor();
		Job j = t.getJob();
		Machine m = t.getMachine();
		System.out.println(u);
		mav.addObject("user",u);
		mav.addObject("timecard",t);
		mav.addObject("job",j);
		mav.addObject("machine",m);
		return mav;
	}
	
	@RequestMapping(value= "/savetimecard", method=RequestMethod.POST)
	public String saveTimecard(@ModelAttribute("timecard") Timecard tc)
	{
		timecardserv.SaveTimecard(tc);
		return "redirect:/list_timecards";
	}
	@RequestMapping(value="/timecards/review/{id}/approveTimecard")
	public String approveTimecardPage(@PathVariable(name="id") int id)
	{
		
		timecardserv.approveTimecard(id);
		return "redirect:/admin/list_timecards";
	}
	
	@RequestMapping(value="/timecards/review/{id}/disapproveTimecard")
	public String disapproveTimecardPage(@PathVariable(name="id") int id)
	{
		timecardserv.disapproveTimecard(id);
		return "redirect:/admin/list_timecards";
	}
	//JOB
	
	@RequestMapping("list_jobs")
	public String listjobs(Model model) {
		List<Job> list = jobserv.getAllJobs();
		model.addAttribute("jobs", list);
		return "job";	
	}
	@RequestMapping("/newjob")
	public String addnewJob(Model model) {
		Job j = new Job();
		model.addAttribute("job", j);
		return "new_job";
	}
	@RequestMapping(value= "/savejob", method=RequestMethod.POST)
	public String saveJob(@ModelAttribute("job") Job j)
	{
		jobserv.SaveJob(j);
		return "redirect:/admin/list_jobs";
	}
	@RequestMapping("/editjob/{id}")
	public ModelAndView showEditJobPage(@PathVariable(name="id") int id)
	{
		ModelAndView mav= new ModelAndView("edit_job");
		Job j= jobserv.get(id);
		mav.addObject("job",j);
		return mav;
	}
	
	@RequestMapping("/deletejob/{id}")
	public String deleteJob(@PathVariable(name="id") int id)
	{
		jobserv.deleteJobById(id);
		return "redirect:/admin/list_jobs";
	}
	
	/* Machine Controller */
	
	@RequestMapping("list_machines")
	public String listmachines(Model model) {
		List<Machine> list = machineserv.getAllMachines();
		model.addAttribute("machines", list);
		return "machine";	
	}
	
	@RequestMapping("/newmachine")
	public String addnewMachine(Model model) {
		Machine m = new Machine();
		model.addAttribute("machine", m);
		return "new_machine";
	}
	@RequestMapping(value= "/savemachine/{id}", method=RequestMethod.POST)
	public String saveMachine(@ModelAttribute("machine") Machine m,@PathVariable(name="id") int id)
	{
		machineserv.deleteMachineById(id);
		int id2 = m.getId();
		m.setId(id);
		machineserv.SaveMachine(m);
		
		return "redirect:/admin/list_machines";
	}
	
	@RequestMapping("/editmachine/{id}")
	public ModelAndView showEditMachinePage(@PathVariable(name="id") int id)
	{
		ModelAndView mav= new ModelAndView("edit_machine");
		Machine m= machineserv.get(id);
		mav.addObject("machine",m);
		return mav;
	}
	
	@RequestMapping("/deletemachine/{id}")
	public String deleteMachine(@PathVariable(name="id") int id)
	{
		machineserv.deleteMachineById(id);
		return "redirect:/admin/list_machines";
	}
	
	
}
