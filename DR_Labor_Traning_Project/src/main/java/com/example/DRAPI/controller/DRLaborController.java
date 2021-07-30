package com.example.DRAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.DRAPI.model.Job;
import com.example.DRAPI.model.Machine;
import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.service.JobService;
import com.example.DRAPI.service.MachineService;
import com.example.DRAPI.service.TimecardService;

@Controller
public class DRLaborController 
{

	@Autowired
	TimecardService timecardserv;
	
	@Autowired
	JobService jobserv;
	
	@Autowired
	MachineService machineserv;
	
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/admin")
	public String adminMain() {
		return "admin_main";
	}
	
	@RequestMapping("/contractor")
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
		return "redirect:/list_timecards";
	}
	
	@RequestMapping(value= "/savetimecardContractor", method=RequestMethod.POST)
	public String saveTimecardContractor(@ModelAttribute("timecard") Timecard tc)
	{
		timecardserv.SaveTimecard(tc);
		return "redirect:/contractor_timecards";
	}
	
	
	@RequestMapping("list_timecards")
	public String listtimecards(Model model) {
		List<Timecard> list = timecardserv.getAllTimecards();
		model.addAttribute("timecards", list);
		return "timecard";	
	}
	//needs to be updated to just view specific contractor's timecards
	@RequestMapping("contractor_timecards")
	public String contractortimecards(Model model) {
		List<Timecard> list = timecardserv.getAllTimecards();
		model.addAttribute("timecards", list);
		return "contractor_timecard";	
	}
	
	@RequestMapping("/deletetimecard/{id}")
	public String deleteTimecard(@PathVariable(name="id") int id)
	{
		timecardserv.deleteTimecardById(id);
		return "redirect:/list_timecards";
		
	}
	
	@RequestMapping("/deletetimecard/contractor/{id}")
	public String deleteTimecardContractor(@PathVariable(name="id") int id)
	{
		timecardserv.deleteTimecardById(id);
		return "redirect:/contractor_timecards";
		
	}
	@RequestMapping("/edittimecard/{id}")
	public ModelAndView showEditTimecardPage(@PathVariable(name="id") int id)
	{
		ModelAndView mav= new ModelAndView("edit_timecard");
		Timecard tc= timecardserv.get(id);
		mav.addObject("timecard",tc);
		return mav;
	}
	@RequestMapping("/edittimecard/contractor/{id}")
	public ModelAndView showEditTimecardPageContractor(@PathVariable(name="id") int id)
	{
		ModelAndView mav= new ModelAndView("edit_timecard_contractor");
		Timecard tc= timecardserv.get(id);
		mav.addObject("timecard",tc);
		return mav;
	}

	/*Job Controller */

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
		return "redirect:/list_jobs";
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
		return "redirect:/list_jobs";
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
	@RequestMapping(value= "/savemachine", method=RequestMethod.POST)
	public String saveMachine(@ModelAttribute("machine") Machine m)
	{
		machineserv.SaveMachine(m);
		return "redirect:/list_machines";
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
		return "redirect:/list_machines";
	}
	
	/* Admin Controller */
	

	
}
