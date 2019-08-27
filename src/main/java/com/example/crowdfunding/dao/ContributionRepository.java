package com.example.crowdfunding.dao;

import com.example.crowdfunding.entities.Contribution;
import com.example.crowdfunding.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


/**
 * Spring Data  dao for the Contribution entity.
 */
@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "contributions", path = "contributions")
public interface ContributionRepository extends JpaRepository<Contribution, Long> {

 /*   @Query("select c from Contribution c where c.personne.id=:idPersone and c.typePersonne=:type")
    public List<Contribution> findByPersonneAndTypePersonneEquals(@Param("idPersone") Long idPersone,@Param("type") Character type);

*/


}
