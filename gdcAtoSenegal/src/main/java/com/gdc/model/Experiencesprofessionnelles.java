/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdoulahi
 */
@Entity
@Table(name = "experiencesprofessionnelles")
@XmlRootElement
public class Experiencesprofessionnelles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTypeDeProfil")
    private Integer idTypeDeProfil;
    @Size(max = 50000)
    @Column(name = "description")
    private String description;
    @Column(name = "datededebut")
    @Temporal(TemporalType.DATE)
    private Date datededebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
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
    @OneToOne(optional = false)
    private Profilgl profilgl;

    public Experiencesprofessionnelles() {
    }

    public Experiencesprofessionnelles(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public Experiencesprofessionnelles(Integer idTypeDeProfil, Date datefin) {
        this.idTypeDeProfil = idTypeDeProfil;
        this.datefin = datefin;
    }

    public Integer getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public void setIdTypeDeProfil(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatededebut() {
        return datededebut;
    }

    public void setDatededebut(Date datededebut) {
        this.datededebut = datededebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
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
        hash += (idTypeDeProfil != null ? idTypeDeProfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencesprofessionnelles)) {
            return false;
        }
        Experiencesprofessionnelles other = (Experiencesprofessionnelles) object;
        if ((this.idTypeDeProfil == null && other.idTypeDeProfil != null) || (this.idTypeDeProfil != null && !this.idTypeDeProfil.equals(other.idTypeDeProfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Experiencesprofessionnelles[ idTypeDeProfil=" + idTypeDeProfil + " ]";
    }
    
}
