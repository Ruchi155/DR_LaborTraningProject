package com.example.DRAPI.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DRAPI.model.Machine;

@Repository
public interface MachineRepo extends JpaRepository<Machine, Integer> {

}
