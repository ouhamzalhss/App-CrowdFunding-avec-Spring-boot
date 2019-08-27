package com.example.crowdfunding.dao;


import com.example.crowdfunding.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
 * Spring Data  dao for the Adresse entity.
 */
@SuppressWarnings("unused")
//@Repository
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "adresses", path = "adresses")
public interface AdresseRepository extends JpaRepository<Adresse, Long> {

}
