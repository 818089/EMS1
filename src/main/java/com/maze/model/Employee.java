package com.maze.model;

import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "yash_emp_id")
	private long yashEmpId;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "grade")
	private String grade;

	@Column(name = "designation")
	private String designation;

	@Column(name = "email")
	private String email;

	@Column(name = "date_of_joining")
	private String dateOfJoining;

	@Column(name = "base_location")
	private String baseLocation;

	@Column(name = "current_location")
	private String currentLocation;

	@Column(name = "primary_skills")
	private String primarySkills;

	@Column(name = "secondary_skills")
	private String secondarySkills;

	@Column(name = "exprience")
	private int exprience;

	@Column(name = "mobile_no")
	private long mobileNo;

	@Column(name = "irm")
	private String irm;

	

	@Column(name = "fileName")
	private String fileName;
	
	@Column(name = "resource_competency")
	private int resourceCompetency;
	
	@Transient
	private String resourceCompetencyName;

	private String resourceAvailabilityStatus;	
	
	@Transient
	String isapproved;
	
	@Nullable
	private String poolAllocationDate;

}
