/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdc.model;

import java.io.Serializable;
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
@Table(name = "modelisation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelisation.findAll", query = "SELECT m FROM Modelisation m"),
    @NamedQuery(name = "Modelisation.findByIdTypeDeProfil", query = "SELECT m FROM Modelisation m WHERE m.modelisationPK.idTypeDeProfil = :idTypeDeProfil"),
    @NamedQuery(name = "Modelisation.findByDomaine", query = "SELECT m FROM Modelisation m WHERE m.modelisationPK.domaine = :domaine"),
    @NamedQuery(name = "Modelisation.findByNiveau", query = "SELECT m FROM Modelisation m WHERE m.niveau = :niveau")})
public class Modelisation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModelisationPK modelisationPK;
    @Size(max = 254)
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profilgl profilgl;

    public Modelisation() {
    }

    public Modelisation(ModelisationPK modelisationPK) {
        this.modelisationPK = modelisationPK;
    }

    public Modelisation(int idTypeDeProfil, String domaine) {
        this.modelisationPK = new ModelisationPK(idTypeDeProfil, domaine);
    }

    public ModelisationPK getModelisationPK() {
        return modelisationPK;
    }

    public void setModelisationPK(ModelisationPK modelisationPK) {
        this.modelisationPK = modelisationPK;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
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
        hash += (modelisationPK != null ? modelisationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelisation)) {
            return false;
        }
        Modelisation other = (Modelisation) object;
        if ((this.modelisationPK == null && other.modelisationPK != null) || (this.modelisationPK != null && !this.modelisationPK.equals(other.modelisationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.Modelisation[ modelisationPK=" + modelisationPK + " ]";
    }
    
}
