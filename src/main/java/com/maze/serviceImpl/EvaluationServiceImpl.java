package com.maze.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maze.exception.ResourceNotFoundException;
import com.maze.model.Evaluation;
import com.maze.repository.EvaluationRepository;
import com.maze.service.EvalutionService;

@Service
public class EvaluationServiceImpl implements EvalutionService {

	private final EvaluationRepository evaluationRepository;

	@Autowired
	public EvaluationServiceImpl(EvaluationRepository evaluationRepository) {
		this.evaluationRepository = evaluationRepository;
	}

	@Override
	public Evaluation addEvalution(Evaluation evaluation) {
		
		Evaluation saveEvaluation = evaluationRepository.save(evaluation);

		return saveEvaluation;
	}

	@Override
	public Evaluation findEvalutionById(int empEvaluationId) {
		
		Evaluation findEvaluationById = evaluationRepository.findById(empEvaluationId)
				.orElseThrow(() -> new ResourceNotFoundException("Evalation is not present for id" + empEvaluationId));
		
		return findEvaluationById;
	}

	@Override
	public List<Evaluation> findAllEvalution() {
		
		List<Evaluation> findAllEvaluation = evaluationRepository.findAll();
		
		return findAllEvaluation;
	}

	@Override
	public Evaluation updateEvalution(int empEvaluationId, Evaluation employeeEvaluation) {
		
		Evaluation existingEvaluation = evaluationRepository.findById(empEvaluationId).orElseThrow(()->
		new ResourceNotFoundException("Evalation is not present for id" + empEvaluationId));
		
		existingEvaluation.setEmployee(employeeEvaluation.getEmployee());
		existingEvaluation.setEvaluatedBy(employeeEvaluation.getEvaluatedBy());
		existingEvaluation.setEvaluationDate(employeeEvaluation.getEvaluationDate());
		existingEvaluation.setEvaluationNumber(employeeEvaluation.getEvaluationNumber());
		existingEvaluation.setEvalutionType(employeeEvaluation.getEvalutionType());
		existingEvaluation.setOverallRating(employeeEvaluation.getOverallRating());
		existingEvaluation.setRatingMap(employeeEvaluation.getRatingMap());
		existingEvaluation.setRelocation(employeeEvaluation.getRelocation());
		existingEvaluation.setRemarks(employeeEvaluation.getRemarks());
		
		Evaluation updatedEvaluation = evaluationRepository.save(employeeEvaluation);

		return updatedEvaluation;
	}

	@Override
	public void deleteEvalution(int empEvaluationId) {

		evaluationRepository.deleteById(empEvaluationId);

	}

}
