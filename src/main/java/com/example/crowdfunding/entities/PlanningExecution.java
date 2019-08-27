package com.example.crowdfunding.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * ==============================================================
 */

@Entity
@Table(name = "planning_execution")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PlanningExecution implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jalon")
    private String jalon;

    @Column(name = "instant_jalon")
    private Instant instantJalon;

    @ManyToOne
    @JsonIgnoreProperties("planningExecutions")
    private Projet projet;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJalon() {
        return jalon;
    }

    public PlanningExecution jalon(String jalon) {
        this.jalon = jalon;
        return this;
    }

    public void setJalon(String jalon) {
        this.jalon = jalon;
    }

    public Instant getInstantJalon() {
        return instantJalon;
    }

    public PlanningExecution instantJalon(Instant instantJalon) {
        this.instantJalon = instantJalon;
        return this;
    }

    public void setInstantJalon(Instant instantJalon) {
        this.instantJalon = instantJalon;
    }

    public Projet getProjet() {
        return projet;
    }

    public PlanningExecution projet(Projet projet) {
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
        PlanningExecution planningExecution = (PlanningExecution) o;
        if (planningExecution.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), planningExecution.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PlanningExecution{" +
            "id=" + getId() +
            ", jalon='" + getJalon() + "'" +
            ", instantJalon='" + getInstantJalon() + "'" +
            "}";
    }
}
