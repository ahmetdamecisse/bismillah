/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdc.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdoulahi
 */
@Entity
@Table(name = "profil")
@XmlRootElement
public class Profil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTypeDeProfil")
    private Integer idTypeDeProfil;
    @Column(name = "nombreAnneesExperience")
    private Integer nombreAnneesExperience;
    @Size(max = 1000)
    @Column(name = "principalesCompetences")
    private String principalesCompetences;
    @Size(max = 1000)
    @Column(name = "competencesFonctionnelles")
    private String competencesFonctionnelles;
    @Size(max = 254)
    @Column(name = "etatProfil")
    private String etatProfil;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profil")
    private Profilgl profilgl;

    public Profil() {
    }

    public Profil(Integer idTypeDeProfil, Integer nombreAnneesExperience, String principalesCompetences, String competencesFonctionnelles, String etatProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
        this.nombreAnneesExperience = nombreAnneesExperience;
        this.principalesCompetences = principalesCompetences;
        this.competencesFonctionnelles = competencesFonctionnelles;
        this.etatProfil = etatProfil;
    }

    public Profil(Integer idTypeDeProfil, Profilgl profilgl) {
        this.idTypeDeProfil = idTypeDeProfil;
        this.profilgl = profilgl;
    }

    public Profil(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public Integer getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public void setIdTypeDeProfil(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public Integer getNombreAnneesExperience() {
        return nombreAnneesExperience;
    }

    public void setNombreAnneesExperience(Integer nombreAnneesExperience) {
        this.nombreAnneesExperience = nombreAnneesExperience;
    }

    public String getPrincipalesCompetences() {
        return principalesCompetences;
    }

    public void setPrincipalesCompetences(String principalesCompetences) {
        this.principalesCompetences = principalesCompetences;
    }

    public String getCompetencesFonctionnelles() {
        return competencesFonctionnelles;
    }

    public void setCompetencesFonctionnelles(String competencesFonctionnelles) {
        this.competencesFonctionnelles = competencesFonctionnelles;
    }

    public String getEtatProfil() {
        return etatProfil;
    }

    public void setEtatProfil(String etatProfil) {
        this.etatProfil = etatProfil;
    }

    public Profilgl getProfilgl() {
        return profilgl;
    }

    public void setProfilgl(Profilgl profilgl) {
        this.profilgl = profilgl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeDeProfil != null ? idTypeDeProfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profil)) {
            return false;
        }
        Profil other = (Profil) object;
        if ((this.idTypeDeProfil == null && other.idTypeDeProfil != null) || (this.idTypeDeProfil != null && !this.idTypeDeProfil.equals(other.idTypeDeProfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Profil[ idTypeDeProfil=" + idTypeDeProfil + " ]";
    }
    
}
