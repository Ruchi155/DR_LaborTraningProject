package com.example.DRAPI.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DRAPI.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>
{

}
