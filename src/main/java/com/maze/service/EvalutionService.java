package com.maze.service;

import java.util.List;

import com.maze.model.Evaluation;

public interface EvalutionService {
	
	public Evaluation addEvalution(Evaluation evaluation);
	
	public Evaluation findEvalutionById(int empEvaluationId);
	
	public List<Evaluation> findAllEvalution();

	public Evaluation updateEvalution(int empEvaluationId,Evaluation employeeEvaluation);
	
	public void deleteEvalution(int empEvaluationId);
}
