package com.example.DRAPI.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DRAPI.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>
{
	@Query("Select a FROM Admin a where a.username = :username")
	Admin findAdminByUsername(@Param("username") String username);
}
