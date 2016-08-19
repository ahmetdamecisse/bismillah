/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a618092
 */
@Entity
@Table(name = "experiencesprofessionnelles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experiencesprofessionnelles.findAll", query = "SELECT e FROM Experiencesprofessionnelles e"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByIdTypeDeProfil", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.experiencesprofessionnellesPK.idTypeDeProfil = :idTypeDeProfil"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByDescription", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.description = :description"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByDatededebut", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.experiencesprofessionnellesPK.datededebut = :datededebut"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByDatefin", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.experiencesprofessionnellesPK.datefin = :datefin"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByFonction", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.fonction = :fonction"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByEnvironnement", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.environnement = :environnement"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByProjet", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.projet = :projet"),
    @NamedQuery(name = "Experiencesprofessionnelles.findByMissionsRealisees", query = "SELECT e FROM Experiencesprofessionnelles e WHERE e.missionsRealisees = :missionsRealisees")})
public class Experiencesprofessionnelles implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExperiencesprofessionnellesPK experiencesprofessionnellesPK;
    @Size(max = 50000)
    @Column(name = "description")
    private String description;
    @Size(max = 650)
    @Column(name = "fonction")
    private String fonction;
    @Size(max = 3000)
    @Column(name = "environnement")
    private String environnement;
    @Size(max = 3000)
    @Column(name = "projet")
    private String projet;
    @Size(max = 3000)
    @Column(name = "missionsRealisees")
    private String missionsRealisees;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profilgl profilgl;

    public Experiencesprofessionnelles() {
    }

    public Experiencesprofessionnelles(ExperiencesprofessionnellesPK experiencesprofessionnellesPK) {
        this.experiencesprofessionnellesPK = experiencesprofessionnellesPK;
    }

    public Experiencesprofessionnelles(int idTypeDeProfil, Date datededebut, Date datefin) {
        this.experiencesprofessionnellesPK = new ExperiencesprofessionnellesPK(idTypeDeProfil, datededebut, datefin);
    }

    public ExperiencesprofessionnellesPK getExperiencesprofessionnellesPK() {
        return experiencesprofessionnellesPK;
    }

    public void setExperiencesprofessionnellesPK(ExperiencesprofessionnellesPK experiencesprofessionnellesPK) {
        this.experiencesprofessionnellesPK = experiencesprofessionnellesPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getEnvironnement() {
        return environnement;
    }

    public void setEnvironnement(String environnement) {
        this.environnement = environnement;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getMissionsRealisees() {
        return missionsRealisees;
    }

    public void setMissionsRealisees(String missionsRealisees) {
        this.missionsRealisees = missionsRealisees;
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
        hash += (experiencesprofessionnellesPK != null ? experiencesprofessionnellesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencesprofessionnelles)) {
            return false;
        }
        Experiencesprofessionnelles other = (Experiencesprofessionnelles) object;
        if ((this.experiencesprofessionnellesPK == null && other.experiencesprofessionnellesPK != null) || (this.experiencesprofessionnellesPK != null && !this.experiencesprofessionnellesPK.equals(other.experiencesprofessionnellesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.Experiencesprofessionnelles[ experiencesprofessionnellesPK=" + experiencesprofessionnellesPK + " ]";
    }
    
}
