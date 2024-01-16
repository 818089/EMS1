package com.maze.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maze.exception.ResourceNotFoundException;
import com.maze.model.Employee;
import com.maze.repository.EmployeeRepository;
import com.maze.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Employee saveEmployee = employeeRepository.save(employee);
		return saveEmployee;
	}
	
	@Override
	public Employee getEmployee(int employeeId) {
		Employee getEmployeeById = employeeRepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("User Not Present With Id "+employeeId));
		return getEmployeeById;
	}


	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> findAllEmployee = employeeRepository.findAll();
		return findAllEmployee;
	}

	@Override
	public Employee updateEmployee(int employeeId,Employee employee) {
		Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("User Not Present With Id "+employeeId));
		
		Employee updateEmployeeProperties = updateEmployeeProperties(existingEmployee, employee);
		
		Employee updateEmployee = employeeRepository.save(updateEmployeeProperties);
		
		return updateEmployee;
	}

	
	private Employee updateEmployeeProperties(Employee existingEmployee, Employee employee) {
		existingEmployee.setEmployeeName(employee.getEmployeeName());
		existingEmployee.setYashEmpId(employee.getYashEmpId());
		existingEmployee.setGrade(employee.getGrade());
		existingEmployee.setDesignation(employee.getDesignation());
		existingEmployee.setDateOfJoining(employee.getDateOfJoining());
		existingEmployee.setEmail(employee.getEmail());		
		existingEmployee.setBaseLocation(employee.getBaseLocation());
		existingEmployee.setCurrentLocation(employee.getCurrentLocation());
		existingEmployee.setPrimarySkills(employee.getPrimarySkills());
		existingEmployee.setSecondarySkills(employee.getSecondarySkills());
		existingEmployee.setExprience(employee.getExprience());
		existingEmployee.setMobileNo(employee.getMobileNo());
		existingEmployee.setIrm(employee.getIrm());
		existingEmployee.setFileName(employee.getFileName());
		existingEmployee.setResourceCompetencyName(employee.getResourceCompetencyName());
		existingEmployee.setResourceAvailabilityStatus(employee.getResourceAvailabilityStatus());
		existingEmployee.setPoolAllocationDate(employee.getPoolAllocationDate());

	    return existingEmployee;
	}
	
	
	@Override
	public void delete(int employeeId) {
		Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(()->
		new ResourceNotFoundException("User Not Present With Id "+employeeId));
		employeeRepository.delete(existingEmployee);
		
	}

	@Override
	public List<Employee> employyOnPool(String status) {
		List<Employee> empOnPool = employeeRepository.findByResourceAvailabilityStatus(status);
		return empOnPool;
	}

}
