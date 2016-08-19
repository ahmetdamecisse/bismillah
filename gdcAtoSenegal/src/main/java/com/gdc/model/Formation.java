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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a618092
 */
@Entity
@Table(name = "formation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f"),
    @NamedQuery(name = "Formation.findByIdTypeDeProfil", query = "SELECT f FROM Formation f WHERE f.formationPK.idTypeDeProfil = :idTypeDeProfil"),
    @NamedQuery(name = "Formation.findByNomDiplome", query = "SELECT f FROM Formation f WHERE f.formationPK.nomDiplome = :nomDiplome"),
    @NamedQuery(name = "Formation.findByUniversite", query = "SELECT f FROM Formation f WHERE f.universite = :universite"),
    @NamedQuery(name = "Formation.findByAnneeObtention", query = "SELECT f FROM Formation f WHERE f.anneeObtention = :anneeObtention"),
    @NamedQuery(name = "Formation.findByMention", query = "SELECT f FROM Formation f WHERE f.mention = :mention")})
public class Formation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FormationPK formationPK;
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
    @ManyToOne(optional = false)
    private Profilgl profilgl;

    public Formation() {
    }

    public Formation(FormationPK formationPK) {
        this.formationPK = formationPK;
    }

    public Formation(int idTypeDeProfil, String nomDiplome) {
        this.formationPK = new FormationPK(idTypeDeProfil, nomDiplome);
    }

    public FormationPK getFormationPK() {
        return formationPK;
    }

    public void setFormationPK(FormationPK formationPK) {
        this.formationPK = formationPK;
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
        hash += (formationPK != null ? formationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.formationPK == null && other.formationPK != null) || (this.formationPK != null && !this.formationPK.equals(other.formationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.Formation[ formationPK=" + formationPK + " ]";
    }
    
}
