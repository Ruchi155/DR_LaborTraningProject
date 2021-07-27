package com.example.DRAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DRAPI.model.Timecard;

@Repository
public interface TimecardRepo extends JpaRepository<Timecard, Integer> {
	@Query("SELECT t FROM Timecard t WHERE t.siteCode = :code")
	Timecard findTimecardByCode(@Param("code")String code);
}
