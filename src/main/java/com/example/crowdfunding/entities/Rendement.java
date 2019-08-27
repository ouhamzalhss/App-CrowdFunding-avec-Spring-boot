package com.example.crowdfunding.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * ==============================================================
 */

@Entity
@Table(name = "rendement")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Rendement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "annee")
    private Integer annee;

    @Column(name = "resultat")
    private Double resultat;

    @ManyToOne
    @JsonIgnoreProperties("rendements")
    private Personne personne;

    @ManyToOne
    @JsonIgnoreProperties("rendements")
    private Projet projet;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnnee() {
        return annee;
    }

    public Rendement annee(Integer annee) {
        this.annee = annee;
        return this;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Double getResultat() {
        return resultat;
    }

    public Rendement resultat(Double resultat) {
        this.resultat = resultat;
        return this;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
    }

    public Personne getContributeur() {
        return personne;
    }

    public Rendement contributeur(Personne personne) {
        this.personne = personne;
        return this;
    }

    public void setContributeur(Personne personne) {
        this.personne = personne;
    }

    public Projet getProjet() {
        return projet;
    }

    public Rendement projet(Projet projet) {
        this.projet = projet;
        return this;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
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
        Rendement rendement = (Rendement) o;
        if (rendement.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rendement.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Rendement{" +
            "id=" + getId() +
            ", annee=" + getAnnee() +
            ", resultat=" + getResultat() +
            "}";
    }
}
