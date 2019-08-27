package com.example.crowdfunding.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * ==============================================================
 */

@Entity
@Table(name = "contribution")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Contribution implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "montant_invistissement")
    private Integer montantInvistissement;

    @Column(name = "data_invistissement")
    private Instant dataInvistissement;

/*    @ManyToMany(mappedBy = "contributions")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Personne> contributeurs = new HashSet<>();*/

    @ManyToOne
    private Projet projet;


    @ManyToOne
    private Personne personne;


    @Column(name = "date_creation")
    private Instant dateCreation;

    @Column(name = "date_modification")
    private Instant dateModification;

    private Character typePersonne;

    @Transient
    private Projet getprojet;

    public Projet getGetprojet(){
        return this.projet;
    }

    @Transient
    private Personne getpersonne;

    public Personne getGetpersonne(){
        return this.personne;
    }


    public Instant getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Instant dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Instant getDateModification() {
        return dateModification;
    }

    public void setDateModification(Instant dateModification) {
        this.dateModification = dateModification;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMontantInvistissement() {
        return montantInvistissement;
    }

    public Contribution montantInvistissement(Integer montantInvistissement) {
        this.montantInvistissement = montantInvistissement;
        return this;
    }

    public void setMontantInvistissement(Integer montantInvistissement) {
        this.montantInvistissement = montantInvistissement;
    }

    public Instant getDataInvistissement() {
        return dataInvistissement;
    }

    public Contribution dataInvistissement(Instant dataInvistissement) {
        this.dataInvistissement = dataInvistissement;
        return this;
    }

    public void setDataInvistissement(Instant dataInvistissement) {
        this.dataInvistissement = dataInvistissement;
    }


// jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contribution contribution = (Contribution) o;
        if (contribution.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), contribution.getId());
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Contribution{" +
            "id=" + getId() +
            ", montantInvistissement=" + getMontantInvistissement() +
            ", dataInvistissement='" + getDataInvistissement() + "'" +
            "}";
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Character getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(Character typePersonne) {
        this.typePersonne = typePersonne;
    }


}
