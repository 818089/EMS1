package com.maze.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maze.model.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Integer>{

}
