package com.example.crowdfunding.dao;

import com.example.crowdfunding.entities.PlanProjet;
import com.example.crowdfunding.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  dao for the PlanProjet entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PlanProjetRepository extends JpaRepository<PlanProjet, Long> {
    public List<PlanProjet> findByProjet(Projet p);
}
