package com.example.crowdfunding.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Adresse.
 */
@Entity
@Table(name = "adresse")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "pays")
    private String pays;

    @Column(name = "region")
    private String region;

    @Column(name = "prefecture")
    private String prefecture;

    @Column(name = "commun")
    private String commun;

    @OneToOne(mappedBy = "adresse")
    private Projet projet;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getCommun() {
        return commun;
    }

    public void setCommun(String commun) {
        this.commun = commun;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Adresse(String adresse, String pays, String region, String prefecture, String commun) {
        this.adresse = adresse;
        this.pays = pays;
        this.region = region;
        this.prefecture = prefecture;
        this.commun = commun;
       // this.projetAdresse = projetAdresse;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", adresse='" + adresse + '\'' +
                ", pays='" + pays + '\'' +
                ", region='" + region + '\'' +
                ", prefecture='" + prefecture + '\'' +
                ", commun='" + commun + '\'' +
              //  ", projetAdresse=" + projetAdresse +
                '}';
    }

    public Adresse() {
    }
}
