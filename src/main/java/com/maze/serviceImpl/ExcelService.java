package com.maze.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.maze.helper.ExcelHelper;
import com.maze.model.Employee;
import com.maze.repository.EmployeeRepository;

@Service
public class ExcelService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	 public void save(MultipartFile file) {
		    try {
		      List<Employee> employee = ExcelHelper.excelToEms(file.getInputStream());
		      employeeRepository.saveAll(employee);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
		  }

	

}
