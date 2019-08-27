package com.example.crowdfunding.dao;


import com.example.crowdfunding.entities.TypeProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
 * Spring Data  dao for the TypeProjet entity.
 */
@SuppressWarnings("unused")
//@Repository
@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "typesProjects", path = "typesProjects")
public interface TypeProjetRepository extends JpaRepository<TypeProjet, Long> {

}
