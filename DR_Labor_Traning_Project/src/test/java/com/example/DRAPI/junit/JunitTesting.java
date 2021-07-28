package com.example.DRAPI.junit;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.DRAPI.model.Job;
import com.example.DRAPI.model.Machine;
import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.repo.ContractorRepo;
import com.example.DRAPI.repo.JobRepo;
import com.example.DRAPI.repo.MachineRepo;
import com.example.DRAPI.repo.TimecardRepo;

@SpringBootTest
@Transactional
public class JunitTesting {

	@Autowired
	JobRepo jRepo;
	
	@Autowired
	MachineRepo mRepo;
	
	@Autowired
	TimecardRepo tRepo;
	
	@Autowired
	ContractorRepo cRepo;
	@Test
	void contextLoads() {
	}
	
//	@Test
//	void jobRepoAddTest() {
//		Job j = new Job();
//		
//		j.setDescription("fix the plumbing");
//		j.setHourlyRate(65);
//		j.setJobCode("Plumber");
//		j.setMaxHoursPerDay(6);
//		
//		jRepo.save(j);
//	}
	
	@Test
	void jobRepoFindByCodeTest() {
		Job j = new Job();
		
		j.setDescription("fix the plumbing");
		j.setHourlyRate(65);
		j.setJobCode("Plumber");
		j.setMaxHoursPerDay(6);
		
		Job j2 = jRepo.findJobByCode("Plumber");
		
		assertEquals(j.toString(),j2.toString());
	}
	
//	@Test
//	void machineRepoAddTest() {
//		Machine m = new Machine();
//		
//		m.setDescription("hand truck with 1000 lbs");
//		m.setHourlyRent(12);
//		m.setMachineCode("HT-100");
//		m.setMaxHoursPerDay(8);
//		
//		mRepo.save(m);
//	}
//	
	@Test
	void machineRepoFindByCodeTest() {
		Machine m = new Machine();
		
		m.setDescription("hand truck with 1000 lbs");
		m.setHourlyRent(12);
		m.setMachineCode("HT-100");
		m.setMaxHoursPerDay(8);
		Machine m2 = mRepo.findMachineByCode("HT-100");
		assertEquals(m.toString(),m2.toString());
	}
//	@Test
//	void timecardRepoAddTest() {
//		Timecard t = new Timecard();
//		
//		t.setContractor(cRepo.getById(1));
//		t.setSiteCode("Site1");
//		t.setTotalAmount(1000);
//		t.setTotalHours(10);
//		tRepo.save(t);
//	}
	
	@Test
	void timecardRepoFindByCodeTest() {
		Timecard t = new Timecard();
		
		t.setContractor(cRepo.getById(1));
		t.setSiteCode("Site1");
		t.setTotalAmount(1000);
		t.setTotalHours(10);
//		t.getMachines().add(mRepo.getById(1));
//		t.getJobs().add(jRepo.getById(1));
		
		Timecard t2 = tRepo.findTimecardByCode("Site1");
		
		assertEquals(t.toString(),t2.toString());
	}
	
	
}
