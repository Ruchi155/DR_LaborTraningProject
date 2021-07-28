package com.example.DRAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DRAPI.model.Contractor;

@Repository
public interface ContractorRepo extends JpaRepository<Contractor, Integer> 
{

}
