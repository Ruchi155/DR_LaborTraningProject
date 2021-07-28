package com.example.DRAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DRAPI.model.Job;
import com.example.DRAPI.model.Machine;

@Repository
public interface MachineRepo extends JpaRepository<Machine, Integer> {
	@Query("SELECT m FROM Machine m WHERE m.machineCode = :code")
	Machine findMachineByCode(@Param("code")String code);
}
