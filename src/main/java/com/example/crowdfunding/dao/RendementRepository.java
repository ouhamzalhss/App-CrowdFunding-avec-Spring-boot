package com.example.crowdfunding.dao;

import com.example.crowdfunding.entities.Rendement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  dao for the Rendement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RendementRepository extends JpaRepository<Rendement, Long> {

}
