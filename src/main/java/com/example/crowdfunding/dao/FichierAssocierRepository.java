package com.example.crowdfunding.dao;


import com.example.crowdfunding.entities.FichierAssocier;
import com.example.crowdfunding.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  dao for the FichierAssocier entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FichierAssocierRepository extends JpaRepository<FichierAssocier, Long> {
    public List<FichierAssocier> findByProjet(Projet projet);

}
