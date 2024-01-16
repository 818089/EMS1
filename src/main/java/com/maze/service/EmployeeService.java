package com.maze.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maze.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public Employee getEmployee(int employeeId);
	
	public List<Employee> getAllEmployee();
	
	public Employee updateEmployee(int employeeId,Employee employee);
	
	public void delete(int employeeId);
	
	public List<Employee> employyOnPool(String status);


}
