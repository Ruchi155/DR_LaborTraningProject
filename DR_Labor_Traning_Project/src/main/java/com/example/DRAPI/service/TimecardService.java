package com.example.DRAPI.service;

import java.util.List;

import com.example.DRAPI.model.Timecard;

public interface TimecardService {
	public void updateTimecard(int id, Timecard t);
	public Timecard getTimecardById(int id);
	public Timecard getTimecardByCode(String code);
	public void createTimecard(Timecard t);
	public void deleteTimecardById(int id);
	public List<Timecard> getAllTimecards();
}
