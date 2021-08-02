package com.example.DRAPI.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DRAPI.model.Timecard;
import com.example.DRAPI.model.User;

@Repository
public interface TimecardRepo extends JpaRepository<Timecard, Integer> {
	@Query("SELECT t FROM Timecard t WHERE t.siteCode = :code")
	Timecard findTimecardByCode(@Param("code")String code);
	
	@Query("SELECT t FROM Timecard t WHERE t.contractor = :contractor")
	List<Timecard> findTimecardByUser(@Param("contractor")User u);
}
