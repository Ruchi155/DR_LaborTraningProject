package com.example.DRAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DRAPI.model.Contractor;

@Repository
public interface ContractorRepo extends JpaRepository<Contractor, Integer> 
{
	@Query("Select c FROM Contractor c where c.username = :username")
	Contractor findContractorByUsername(@Param("username")String username);
}
