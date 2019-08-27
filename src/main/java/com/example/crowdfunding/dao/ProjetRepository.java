package com.example.crowdfunding.dao;

import com.example.crowdfunding.entities.Projet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  dao for the Projet entity.
 */
@SuppressWarnings("unused")
//@Repository
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjetRepository extends JpaRepository<Projet, Long> {

//    @Query(value = "select distinct projet from Projet projet left join fetch projet.contributions",
//        countQuery = "select count(distinct projet) from Projet projet")
//    Page<Projet> findAllWithEagerRelationships(Pageable pageable);
//    @GetMapping(value = "projetss")
//    @Query(value = "select distinct projet from Projet projet left join fetch projet.contributions")
//    List<Projet> findAllWithEagerRelationships();
//
//    @Query("select projet from Projet projet left join fetch projet.contributions where projet.id =:id")
//    Optional<Projet> findOneWithEagerRelationships(@Param("id") Long id);

    @Query("select e from Projet e where e.nomProjet like :x")
    public Page<Projet> chercher(@Param("x")String mc,Pageable pageable);

    @RestResource(path = "/projectsByKeyword")
    public List<Projet> findByNomProjetContains(@Param("mc") String mc);

    @RestResource(path = "/getLastProject")
    public Projet findFirstByOrderByIdDesc();
}
