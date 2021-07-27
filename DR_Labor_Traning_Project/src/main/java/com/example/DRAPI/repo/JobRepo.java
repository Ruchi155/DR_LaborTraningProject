package com.example.DRAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DRAPI.model.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {
	@Query("SELECT j FROM Job j WHERE j.jobCode = :code")
	Job findJobByCode(@Param("code")String code);
}
