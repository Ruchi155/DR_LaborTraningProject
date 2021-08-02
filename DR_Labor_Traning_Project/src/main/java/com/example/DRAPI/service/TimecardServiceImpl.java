package com.example.DRAPI.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.model.User;
import com.example.DRAPI.repo.TimecardRepo;
@Service
public class TimecardServiceImpl implements TimecardService {
	
	@Autowired
	TimecardRepo repo;

	@Override
	public void updateTimecard(int id, Timecard t) {
		Timecard temp  = repo.getById(id);
		
//		temp.setAdmin(t.getAdmin());
//		temp.setContract(t.getContract());
		temp.setContractor(t.getContractor());
		temp.setSiteCode(t.getSiteCode());
		temp.setTotalAmount(t.getTotalAmount());
		temp.setTotalHours(t.getTotalHours());
		repo.save(temp);
	}

	@Override
	public void createTimecard(Timecard t) {
		repo.save(t);
	}

	@Override
	public void deleteTimecardById(int id) {
		repo.deleteById(id);
	}

	@Override
	public List<Timecard> getAllTimecards() {
		return repo.findAll();
	}
	public void SaveTimecard(Timecard tc) 
	{
		repo.save(tc);
	}

	@Override
	public Timecard get(int i) {
		return repo.findById(i).get();
	}

	@Override
	public void approveTimecard(int id) {
		Timecard t = repo.getById(id);
		t.setApproved(true);
		repo.save(t);
		System.out.println(t.isApproved());
	}
	@Override
	public void disapproveTimecard(int id) {
		Timecard t = repo.getById(id);
		t.setApproved(false);
		repo.save(t);
		System.out.println(t.isApproved());
	}

	@Override
	public List<Timecard> getTimecardsByUser(User u) {
		return repo.findTimecardByUser(u);
	}
}
