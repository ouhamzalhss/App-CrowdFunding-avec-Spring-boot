package com.example.crowdfunding.dao;


import com.example.crowdfunding.entities.PlanningExecution;

import com.example.crowdfunding.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  dao for the PlanningExecution entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PlanningExecutionRepository extends JpaRepository<PlanningExecution, Long> {
    public List<PlanningExecution> findByProjet(Projet p);
}
