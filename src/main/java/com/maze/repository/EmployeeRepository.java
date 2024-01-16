package com.maze.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maze.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query("select e from Employee e where e.resourceAvailabilityStatus='competancy pool'")
	public List<Employee> findByResourceAvailabilityStatus(String status);

}
