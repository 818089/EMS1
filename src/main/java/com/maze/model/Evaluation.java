package com.maze.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Evaluation {
	
	@Id
	@Column(name = "emp_evaluation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empEvaluationId;

	@Column(name = "evaluation_date")
	private Date evaluationDate;

	@Column(name = "evaluation_number")
	private long evaluationNumber;

	@Column(name = "evaluated_by")
	private String evaluatedBy;

	@Column(name = "overall_rating")
	private long overallRating;


	@Column(name = "remarks")
	private String remarks;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id" )
	public Employee employee;

	@Transient
	private long yashEmployeeId;

	@Column(name = "evalution_type")
	private String evalutionType;
	
	@Transient
	private String evlDate;	
	
	@Transient
	Map<Long,Long> ratingMap = new HashMap<Long,Long>();
	
	@Transient
	String moduleName;
	
	@Transient
	String isapproved;


	@Column(name = "ready_for_relocation")
	private String relocation;

}
