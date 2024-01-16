package com.maze.serviceTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockitoSession;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.maze.exception.ResourceNotFoundException;
import com.maze.model.Employee;
import com.maze.repository.EmployeeRepository;
import com.maze.serviceImpl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)

public class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	private Employee employee;

	@BeforeEach
	public void setUp() {

		employee = new Employee();
		employee.setEmployeeName("John Doe");
		employee.setYashEmpId(123456);
		employee.setGrade("Senior");
		employee.setDesignation("Software Engineer");
		employee.setDateOfJoining("01-01-2022");
		employee.setEmail("john.doe@example.com");
		employee.setBaseLocation("New York");
		employee.setCurrentLocation("New York");
		employee.setPrimarySkills("Java");
		employee.setSecondarySkills("SQL");
		employee.setExprience(6);
		employee.setMobileNo(1234567890);
		employee.setIrm("12345");
		employee.setFileName("resume.pdf");
		employee.setResourceCompetencyName("Java Development");
		employee.setResourceAvailabilityStatus("Available");
		employee.setPoolAllocationDate("01-01-2022");
	}

	@DisplayName("Junit Test case for saveEmployee method")
	@Test
	public void testSaveEmployee() {

		Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);

		Employee savedEmployee = employeeServiceImpl.addEmployee(employee);

		assertEquals(employee, savedEmployee);

		Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);

	}

	@DisplayName("Junit Test case for sgetEmployee method")
	@Test
	public void testGetEmployee() {
		int employeeId = 1;

		Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

		Employee retrivedEmployee = employeeServiceImpl.getEmployee(employeeId);

		assertEquals(employee, retrivedEmployee);

		Mockito.verify(employeeRepository, Mockito.times(1)).findById(employeeId);

	}

	@DisplayName("Junit Test case for sgetEmployee method")
	@Test
	public void testGetEmployeeThrowException() {

		int employeeId = 1;

		Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());


		 assertThrows(ResourceNotFoundException.class, () -> {
			employeeServiceImpl.getEmployee(employeeId);
		});
		
		
//		Mockito.verify(employeeRepository, Mockito.times(1)).findById(employeeId);

//		 String expectedErrorMessage = "User Not Present With Id " + employeeId;
//		    String actualErrorMessage = exception.getMessage();
//		    assertEquals(expectedErrorMessage, actualErrorMessage, "Incorrect exception message");
	}
	
	@DisplayName("Junit Test case for deleteEmployee method")
	@Test
	public void testDeleteEmployee() {
		
		int employeeId=1;
		
		Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
		
		employeeServiceImpl.delete(employeeId);
		
		
		Mockito.verify(employeeRepository,Mockito.times(1)).delete(employee);
		
	}
	
	@DisplayName("Junit Test case for deleteEmployee when throw exception")
	@Test
	public void testDeleteEmployee_ThrowException() {
		
		int employeeId=1;
		
		Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());
		
		assertThrows(ResourceNotFoundException.class, ()->{
			employeeServiceImpl.delete(employeeId);
		});
	}
	
	@DisplayName("Junit Test case for deleteEmployee method")
	@Test
	public void testGetAllEmployee() {
		
		List<Employee> existingEmployee=new ArrayList<>();
		existingEmployee.add(employee);
		
		Mockito.when(employeeRepository.findAll()).thenReturn(existingEmployee);
		
		List<Employee> allEmployee = employeeServiceImpl.getAllEmployee();
		
		assertEquals(existingEmployee, allEmployee);
		
		Mockito.verify(employeeRepository,Mockito.times(1)).findAll();
		
	}

	@DisplayName("Junit Test case for updateEmployee method")
	@Test
	public void testUpdateEmployee() {
		
	    int employeeId = 1;
        Employee existingEmployee = new Employee();
        // Set existingEmployee properties
        Employee updatedEmployee = new Employee();
        // Set updatedEmployee properties

        Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(existingEmployee));
        Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(updatedEmployee);

        // Act
        Employee result = employeeServiceImpl.updateEmployee(employeeId, updatedEmployee);

        // Assert
        assertEquals(updatedEmployee, result);
        Mockito.verify(employeeRepository, Mockito.times(1)).findById(employeeId);
        Mockito.verify(employeeRepository, Mockito.times(1)).save(existingEmployee);
	}
	
	  @Test
	    public void testUpdateEmployee_ThrowException() {
	        // Arrange
	        int employeeId = 1;
	        Employee updatedEmployee = new Employee();
	        // Set updatedEmployee properties

	        Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());

	        // Act and Assert
	        assertThrows(ResourceNotFoundException.class, () -> {
	            employeeServiceImpl.updateEmployee(employeeId, updatedEmployee);
	        });
	        Mockito.verify(employeeRepository, Mockito.times(1)).findById(employeeId);
	    }
}
