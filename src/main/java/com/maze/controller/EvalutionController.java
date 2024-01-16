package com.maze.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maze.model.Evaluation;
import com.maze.service.EvalutionService;
import com.maze.serviceImpl.EvaluationServiceImpl;

import lombok.Delegate;

@RestController
@RequestMapping("api/evaluation")
public class EvalutionController {
	
	private final EvaluationServiceImpl evaluationServiceImpl;
	@Autowired
	
	public EvalutionController (EvaluationServiceImpl evaluationServiceImpl) {
		this.evaluationServiceImpl=evaluationServiceImpl;
	}
	
	@PostMapping("/addEvaluation")
	public ResponseEntity<Evaluation> saveEvaluation(@RequestBody Evaluation evaluation){
		
		Evaluation addEvalution = evaluationServiceImpl.addEvalution(evaluation);
		
		return new ResponseEntity<>(addEvalution,HttpStatus.CREATED);
	}
	
	@GetMapping("/getEvaluation/{empEvaluationId}")
	public ResponseEntity<Evaluation> findEvaluatuinById(@PathVariable int empEvaluationId){
		
		Evaluation findEvalutionById = evaluationServiceImpl.findEvalutionById(empEvaluationId);
		
		return new ResponseEntity<Evaluation>(findEvalutionById,HttpStatus.OK);
	}
	
	@GetMapping("/getAllEvaluation")
	 public ResponseEntity<List<Evaluation>> findAllEvaluation(){
		 
		 List<Evaluation> findAllEvalution = evaluationServiceImpl.findAllEvalution();
		 
		 return new ResponseEntity<>(findAllEvalution,HttpStatus.OK);
	 }
	
	@DeleteMapping("/deleteEvaluation/{empEvaluationId}")
	public ResponseEntity<String> deleteEvaluation(@PathVariable int empEvaluationId){
		
		evaluationServiceImpl.deleteEvalution(empEvaluationId);
		return new ResponseEntity<>("Evaluation deleted successfully with id "+empEvaluationId,HttpStatus.OK);
	}
	
	@PutMapping("/updateEvaluation/{empEvaluationId}")
	public ResponseEntity<Evaluation> updateEmployee(@PathVariable int empEvaluationId,@RequestBody Evaluation evaluation){
		
		Evaluation updateEvalution = evaluationServiceImpl.updateEvalution(empEvaluationId, evaluation);
	
		return new ResponseEntity<Evaluation>(updateEvalution,HttpStatus.OK);
	}
	
	
	

}
