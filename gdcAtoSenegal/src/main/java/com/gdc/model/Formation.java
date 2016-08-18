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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "formation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f"),
    @NamedQuery(name = "Formation.findByIdTypeDeProfil", query = "SELECT f FROM Formation f WHERE f.idTypeDeProfil = :idTypeDeProfil"),
    @NamedQuery(name = "Formation.findByNomDiplome", query = "SELECT f FROM Formation f WHERE f.nomDiplome = :nomDiplome"),
    @NamedQuery(name = "Formation.findByUniversite", query = "SELECT f FROM Formation f WHERE f.universite = :universite"),
    @NamedQuery(name = "Formation.findByAnneeObtention", query = "SELECT f FROM Formation f WHERE f.anneeObtention = :anneeObtention"),
    @NamedQuery(name = "Formation.findByMention", query = "SELECT f FROM Formation f WHERE f.mention = :mention")})
public class Formation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTypeDeProfil")
    private Integer idTypeDeProfil;
    @Size(max = 254)
    @Column(name = "nomDiplome")
    private String nomDiplome;
    @Size(max = 254)
    @Column(name = "universite")
    private String universite;
    @Column(name = "anneeObtention")
    @Temporal(TemporalType.DATE)
    private Date anneeObtention;
    @Size(max = 254)
    @Column(name = "mention")
    private String mention;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Profilgl profilgl;

    public Formation() {
    }

    public Formation(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public Integer getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public void setIdTypeDeProfil(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public String getNomDiplome() {
        return nomDiplome;
    }

    public void setNomDiplome(String nomDiplome) {
        this.nomDiplome = nomDiplome;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public Date getAnneeObtention() {
        return anneeObtention;
    }

    public void setAnneeObtention(Date anneeObtention) {
        this.anneeObtention = anneeObtention;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
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
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.idTypeDeProfil == null && other.idTypeDeProfil != null) || (this.idTypeDeProfil != null && !this.idTypeDeProfil.equals(other.idTypeDeProfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Formation[ idTypeDeProfil=" + idTypeDeProfil + " ]";
    }
    
}
