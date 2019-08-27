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
@Table(name = "plan_projet")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PlanProjet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resume")
    private String resume;

    @Column(name = "description")
    private String description;

    @Column(name = "annee")
    private Integer annee;

    @Column(name = "opex")
    private Double opex;

    @Column(name = "capex")
    private Double capex;

    @Column(name = "resultat")
    private Double resultat;

    @ManyToOne
    @JsonIgnoreProperties("planProjets")
    private Projet projet;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResume() {
        return resume;
    }

    public PlanProjet resume(String resume) {
        this.resume = resume;
        return this;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getDescription() {
        return description;
    }

    public PlanProjet description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAnnee() {
        return annee;
    }

    public PlanProjet annee(Integer annee) {
        this.annee = annee;
        return this;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Double getOpex() {
        return opex;
    }

    public PlanProjet opex(Double opex) {
        this.opex = opex;
        return this;
    }

    public void setOpex(Double opex) {
        this.opex = opex;
    }

    public Double getCapex() {
        return capex;
    }

    public PlanProjet capex(Double capex) {
        this.capex = capex;
        return this;
    }

    public void setCapex(Double capex) {
        this.capex = capex;
    }

    public Double getResultat() {
        return resultat;
    }

    public PlanProjet resultat(Double resultat) {
        this.resultat = resultat;
        return this;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
    }

    public Projet getProjet() {
        return projet;
    }

    public PlanProjet projet(Projet projet) {
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
        PlanProjet planProjet = (PlanProjet) o;
        if (planProjet.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), planProjet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PlanProjet{" +
            "id=" + getId() +
            ", resume='" + getResume() + "'" +
            ", description='" + getDescription() + "'" +
            ", annee=" + getAnnee() +
            ", opex=" + getOpex() +
            ", capex=" + getCapex() +
            ", resultat=" + getResultat() +
            "}";
    }
}
