package com.example.DRAPI.service;

import java.util.List;

import com.example.DRAPI.model.Timecard;

public interface TimecardService {
	public void updateTimecard(int id, Timecard t);
	public void createTimecard(Timecard t);
	public void deleteTimecardById(int id);
	public List<Timecard> getAllTimecards();
	public void SaveTimecard(Timecard tc);
	public Timecard get(int id);
	public void approveTimecard(int id);
	public void disapproveTimecard(int id);
}
