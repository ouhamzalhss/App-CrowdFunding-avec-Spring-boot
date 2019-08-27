package com.example.crowdfunding.dao;


import com.example.crowdfunding.entities.Adresse;
import com.example.crowdfunding.entities.Personne;
import com.example.crowdfunding.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
 * Spring Data  dao for the Adresse entity.
 */
@SuppressWarnings("unused")
//@Repository
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "personnes", path = "personnes")
public interface PersonRepository extends JpaRepository<Personne, Long> {

    @RestResource(path = "/profile")
    public Personne findByUsername(@Param("username") String username);



}
