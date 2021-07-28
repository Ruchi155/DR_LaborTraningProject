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
import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.service.JobService;
import com.example.DRAPI.service.TimecardService;




@Controller
public class DRLaborController 
{

	@Autowired
	TimecardService timecardserv;
	
	@Autowired
	JobService jobserv;
	
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
	
	@RequestMapping("list_timecards")
	public String listtimecards(Model model) {
		List<Timecard> list = timecardserv.getAllTimecards();
		model.addAttribute("timecards", list);
		return "timecard";	
	}
	
	@RequestMapping("/deletetimecard/{id}")
	public String deleteTimecard(@PathVariable(name="id") int id)
	{
		timecardserv.deleteTimecardById(id);
		return "redirect:/list_timecards";
		
	}
	@RequestMapping("/edittimecard/{id}")
	public ModelAndView showEditTimecardPage(@PathVariable(name="id") int id)
	{
		ModelAndView mav= new ModelAndView("edit_timecard");
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
}
