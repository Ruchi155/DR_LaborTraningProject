package com.example.demo.junit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.DRAPI.repo.JobRepo;
import com.example.DRAPI.repo.MachineRepo;
import com.example.DRAPI.repo.TimecardRepo;

@SpringBootTest
public class JunitTesting {

	@Autowired
	JobRepo jRepo;
	
	@Autowired
	MachineRepo mRepo;
	
	@Autowired
	TimecardRepo tRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void jobRepoFindByCodeTest() {
		
	}
}
