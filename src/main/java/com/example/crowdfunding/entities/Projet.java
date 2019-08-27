package com.example.crowdfunding.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * ==============================================================
 */

@Entity
@Table(name = "projet")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Projet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_projet")
    private String nomProjet;

    @Column(name = "description_projet")
    private String descriptionProjet;

    @Column(name = "delai_projet")
    private String delaiProjet;

    @Column(name = "date_debut")
    private Date dateDebut;

    @Column(name = "nature_projet")
    private String natureProjet;

    @Column(name = "is_cloture")
    private Boolean isCloture;

    @Column(name = "fonds_apportes")
    private Double fondsApportes;

    @Column(name = "fonds_a_lever")
    private Double fondsALever;

    @ManyToOne
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private TypeProjet typeProjets;

    @OneToMany(mappedBy = "projet")
    private List<Contribution> contributions;

    @Transient
    private double pourcentage;

    @Transient
    private double montantInvestissemnt;

    public double getMontantInvestissemnt() {
        double montant = this.getMontantContrib(this.id);
        return this.fondsApportes +  montant;
    }

    public double getPourcentage() {
        double montant = this.getMontantContrib(this.id);
        return (this.fondsApportes +  montant ) / (this.fondsApportes +  this.fondsALever)* 100;
    }

    private double getMontantContrib(Long id){
        double montant = 0;
        for (Contribution c: this.contributions){
            montant += c.getMontantInvistissement();
        }
        return montant;
    }







    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id", referencedColumnName = "id")
    private Adresse adresse;

    @Transient
    private Adresse getAdresse;

    public Adresse getGetAdresse(){
        return  this.adresse;
    }


    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<FichierAssocier> fichierAssociers = new HashSet<>();
    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PlanProjet> planProjets = new HashSet<>();
    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PlanningExecution> planningExecutions = new HashSet<>();
    @OneToMany(mappedBy = "projet")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Rendement> rendements = new HashSet<>();
/*    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "projet_contribution",
               joinColumns = @JoinColumn(name = "projets_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "contributions_id", referencedColumnName = "id"))
    private Set<Contribution> contributions = new HashSet<>();*/

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public Projet nomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
        return this;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public String getDescriptionProjet() {
        return descriptionProjet;
    }

    public Projet descriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
        return this;
    }

    public void setDescriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
    }

    public String getDelaiProjet() {
        return delaiProjet;
    }

    public Projet delaiProjet(String delaiProjet) {
        this.delaiProjet = delaiProjet;
        return this;
    }

    public void setDelaiProjet(String delaiProjet) {
        this.delaiProjet = delaiProjet;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Projet dateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
        return this;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getNatureProjet() {
        return natureProjet;
    }

    public Projet natureProjet(String natureProjet) {
        this.natureProjet = natureProjet;
        return this;
    }

    public void setNatureProjet(String natureProjet) {
        this.natureProjet = natureProjet;
    }

    public Boolean isIsCloture() {
        return isCloture;
    }

    public Projet isCloture(Boolean isCloture) {
        this.isCloture = isCloture;
        return this;
    }

    public void setIsCloture(Boolean isCloture) {
        this.isCloture = isCloture;
    }

    public Double getFondsApportes() {
        return fondsApportes;
    }

    public Projet fondsApportes(Double fondsApportes) {
        this.fondsApportes = fondsApportes;
        return this;
    }

    public void setFondsApportes(Double fondsApportes) {
        this.fondsApportes = fondsApportes;
    }

    public Double getFondsALever() {
        return fondsALever;
    }

    public Projet fondsALever(Double fondsALever) {
        this.fondsALever = fondsALever;
        return this;
    }

    public void setFondsALever(Double fondsALever) {
        this.fondsALever = fondsALever;
    }


    public Set<FichierAssocier> getFichierAssociers() {
        return fichierAssociers;
    }

    public Projet fichierAssociers(Set<FichierAssocier> fichierAssociers) {
        this.fichierAssociers = fichierAssociers;
        return this;
    }

    public Projet addFichierAssocier(FichierAssocier fichierAssocier) {
        this.fichierAssociers.add(fichierAssocier);
        fichierAssocier.setProjet(this);
        return this;
    }

    public Projet removeFichierAssocier(FichierAssocier fichierAssocier) {
        this.fichierAssociers.remove(fichierAssocier);
        fichierAssocier.setProjet(null);
        return this;
    }

    public void setFichierAssociers(Set<FichierAssocier> fichierAssociers) {
        this.fichierAssociers = fichierAssociers;
    }

    public Set<PlanProjet> getPlanProjets() {
        return planProjets;
    }

    public Projet planProjets(Set<PlanProjet> planProjets) {
        this.planProjets = planProjets;
        return this;
    }

    public Projet addPlanProjet(PlanProjet planProjet) {
        this.planProjets.add(planProjet);
        planProjet.setProjet(this);
        return this;
    }

    public Projet removePlanProjet(PlanProjet planProjet) {
        this.planProjets.remove(planProjet);
        planProjet.setProjet(null);
        return this;
    }

    public void setPlanProjets(Set<PlanProjet> planProjets) {
        this.planProjets = planProjets;
    }

    public Set<PlanningExecution> getPlanningExecutions() {
        return planningExecutions;
    }

    public Projet planningExecutions(Set<PlanningExecution> planningExecutions) {
        this.planningExecutions = planningExecutions;
        return this;
    }

    public Projet addPlanningExecution(PlanningExecution planningExecution) {
        this.planningExecutions.add(planningExecution);
        planningExecution.setProjet(this);
        return this;
    }

    public Projet removePlanningExecution(PlanningExecution planningExecution) {
        this.planningExecutions.remove(planningExecution);
        planningExecution.setProjet(null);
        return this;
    }

    public void setPlanningExecutions(Set<PlanningExecution> planningExecutions) {
        this.planningExecutions = planningExecutions;
    }

    public Set<Rendement> getRendements() {
        return rendements;
    }

    public Projet rendements(Set<Rendement> rendements) {
        this.rendements = rendements;
        return this;
    }

    public Projet addRendement(Rendement rendement) {
        this.rendements.add(rendement);
        rendement.setProjet(this);
        return this;
    }

    public Projet removeRendement(Rendement rendement) {
        this.rendements.remove(rendement);
        rendement.setProjet(null);
        return this;
    }

    public void setRendements(Set<Rendement> rendements) {
        this.rendements = rendements;
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
        Projet projet = (Projet) o;
        if (projet.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), projet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Projet{" +
            "id=" + getId() +
            ", nomProjet='" + getNomProjet() + "'" +
            ", descriptionProjet='" + getDescriptionProjet() + "'" +
            ", delaiProjet='" + getDelaiProjet() + "'" +
            ", dateDebut='" + getDateDebut() + "'" +
            ", natureProjet='" + getNatureProjet() + "'" +
            ", isCloture='" + isIsCloture() + "'" +
            ", fondsApportes=" + getFondsApportes() +
            ", fondsALever=" + getFondsALever() +
            "}";
    }

    public TypeProjet getTypeProjets() {
        return typeProjets;
    }

    public void setTypeProjets(TypeProjet typeProjets) {
        this.typeProjets = typeProjets;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions = contributions;
    }

    public Boolean getCloture() {
        return isCloture;
    }

    public void setCloture(Boolean cloture) {
        isCloture = cloture;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
