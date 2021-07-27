package com.example.DRAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DRAPI.model.Timecard;

@Repository
public interface TimecardRepo extends JpaRepository<Timecard, Integer> {

}
