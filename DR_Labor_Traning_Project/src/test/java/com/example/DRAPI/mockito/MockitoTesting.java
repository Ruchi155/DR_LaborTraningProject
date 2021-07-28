package com.example.DRAPI.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.DRAPI.model.Job;
import com.example.DRAPI.model.Machine;
import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.repo.ContractorRepo;
import com.example.DRAPI.repo.JobRepo;
import com.example.DRAPI.repo.MachineRepo;
import com.example.DRAPI.repo.TimecardRepo;
import com.example.DRAPI.service.JobServiceImpl;
import com.example.DRAPI.service.MachineServiceImpl;
import com.example.DRAPI.service.TimecardServiceImpl;

@SpringBootTest
public class MockitoTesting {
	@Mock
	JobRepo jRepo;
	
	@Mock
	MachineRepo mRepo;
	
	@Mock
	TimecardRepo tRepo;
	
	@Mock
	ContractorRepo cRepo;
	
	@InjectMocks
	@Autowired
	JobServiceImpl jService;
	
	@InjectMocks
	@Autowired
	MachineServiceImpl mService;
	
	@InjectMocks
	@Autowired
	TimecardServiceImpl tService;
	
	@Test
	void jobServiceImplUpdateTest() {
		Job j = new Job();
		
		j.setDescription("wood work");
		j.setHourlyRate(50);
		j.setJobCode("Carpenter");
		j.setMaxHoursPerDay(4);
		Job j2 = jRepo.getById(1);
		jService.updateJob(1, j);
		
		Job j3 = jRepo.getById(1);
		assertFalse(j2.toString().equals(j3.toString()));
	}
	
	@Test
	void jobServiceImplGetJobByIdTest() {
		Job j = new Job();
		
		j.setDescription("wood work");
		j.setHourlyRate(50);
		j.setJobCode("Carpenter");
		j.setMaxHoursPerDay(4);
		Job j2 = jService.getJobById(1);
		assertFalse(j.toString().equals(j2.toString()));
		
	}
	
	@Test
	void jobServiceImplGetJobByCodeTest() {
		Job j = new Job();
		
		j.setDescription("wood work");
		j.setHourlyRate(50);
		j.setJobCode("Carpenter");
		j.setMaxHoursPerDay(4);
		Job j2 = jService.getJobByCode("Carpenter");
		assertFalse(j.toString().equals(j2.toString()));
	}
	
	@Test
	void jobServiceImplCreateJobTest() {
		Job j = new Job();
		
		j.setDescription("electric work");
		j.setHourlyRate(45);
		j.setJobCode("Electrician");
		j.setMaxHoursPerDay(4);
		j.setId(100);
		jService.createJob(j);
		
		Job j2 = jRepo.getById(100);
		assertFalse(j.toString().equals(j2.toString()));
		
	}
	@Test
	void jobServiceImpldeleteByIDJobTest() {
		
		jService.deleteJobById(100);
		
		Job j2 = jRepo.getById(100);
		assertTrue(j2 == null);
		
	}
	@Test
	void jobServiceImplGetAllJobTest() {
		
		List<Job> jobsRepo = jRepo.findAll();
		List<Job> jobsService = jService.getAllJobs();
		assertEquals(jobsRepo,jobsService);
		
	}
	
	@Test
	void machineServiceImplUpdateTest() {
		Machine m = new Machine();
		
		m.setDescription("Appliance Truck");
		m.setHourlyRent(12);
		m.setMachineCode("AT-800");
		m.setMaxHoursPerDay(8);
		Machine m2 = mRepo.getById(1);
		mService.updateMachine(1, m);
		
		Machine m3 = mRepo.getById(1);
		assertFalse(m2.toString().equals(m3.toString()));
	}
	
	@Test
	void machineServiceImplGetJobByIdTest() {
		Machine m = new Machine();
		
		m.setDescription("Appliance Truck");
		m.setHourlyRent(12);
		m.setMachineCode("AT-800");
		m.setMaxHoursPerDay(8);
		Machine m2 = mService.getMachineById(1);
		assertFalse(m.toString().equals(m2.toString()));
		
	}
	
	@Test
	void machineServiceImplGetJobByCodeTest() {
		Machine m = new Machine();
		
		m.setDescription("Appliance Truck");
		m.setHourlyRent(12);
		m.setMachineCode("AT-800");
		m.setMaxHoursPerDay(8);
		Machine m2 = mService.getMachineByCode("AT-800");
		assertFalse(m.toString().equals(m2.toString()));
	}
	
	@Test
	void machineServiceImplCreateJobTest() {
		Machine m = new Machine();
		
		m.setDescription("AirComp");
		m.setHourlyRent(10);
		m.setMachineCode("AirComp");
		m.setMaxHoursPerDay(4);
		m.setId(100);
		mService.createMachine(m);
		
		Machine m2 = mRepo.getById(100);
		assertFalse(m.toString().equals(m2.toString()));
		
	}
	@Test
	void machineServiceImpldeleteByIDJobTest() {
		
		mService.deleteMachineById(100);
		
		Machine m2 = mRepo.getById(100);
		assertTrue(m2 == null);
		
	}
	@Test
	void machineServiceImplGetAllJobTest() {
		
		List<Machine> machineRepo = mRepo.findAll();
		List<Machine> machineService = mService.getAllMachines();
		assertEquals(machineRepo,machineService);
		
	}
	
	@Test
	void timecardServiceImplUpdateTest() {
		Timecard t = new Timecard();
		
		t.setTotalHours(100);
		t.setTotalAmount(1000);
		t.setContractor(cRepo.getById(1));
		t.setSiteCode("Site1");
		Timecard t2 = tRepo.getById(1);
		tService.updateTimecard(1, t);
		
		Timecard t3 = tRepo.getById(1);
		assertFalse(t2.toString().equals(t3.toString()));
	}
	
	@Test
	void timecardServiceImplGetTimecardByIdTest() {
		Timecard t = new Timecard();
		
		t.setTotalHours(100);
		t.setTotalAmount(1000);
		t.setContractor(cRepo.getById(1));
		t.setSiteCode("Site1");
		Timecard t2 = tRepo.getById(1);
		assertFalse(t.toString().equals(t2.toString()));
		
	}
	
	@Test
	void timecardServiceImplGetTimecardByCodeTest() {
		Timecard t = new Timecard();
		
		t.setTotalHours(100);
		t.setTotalAmount(1000);
		t.setContractor(cRepo.getById(1));
		t.setSiteCode("Site1");
		Timecard t2 = tRepo.findTimecardByCode("Site1");
		assertFalse(t.toString().equals(t2.toString()));
	}
	
	@Test
	void timecardServiceImplCreateTimecardTest() {
		Timecard t = new Timecard();
		
		t.setTotalHours(100);
		t.setTotalAmount(1000);
		t.setContractor(cRepo.getById(1));
		t.setSiteCode("Site1");
		t.setId(100);
		tService.createTimecard(t);
		
		Timecard t2 = tRepo.getById(100);
		assertFalse(t.toString().equals(t2.toString()));
		
	}
	@Test
	void timecardServiceImpldeleteByIDTimecardTest() {
		
		tService.deleteTimecardById(100);
		
		Timecard t2 = tRepo.getById(100);
		assertTrue(t2 == null);
		
	}
	@Test
	void timecardServiceImplGetAllTimecardTest() {
		
		List<Timecard> timecardRepo = tRepo.findAll();
		List<Timecard> timecardService = tService.getAllTimecards();
		assertEquals(timecardRepo,timecardService);
		
	}
	
}
