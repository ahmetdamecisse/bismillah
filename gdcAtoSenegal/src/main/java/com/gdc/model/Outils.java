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
@Table(name = "outils")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Outils.findAll", query = "SELECT o FROM Outils o"),
    @NamedQuery(name = "Outils.findByIdTypeDeProfil", query = "SELECT o FROM Outils o WHERE o.outilsPK.idTypeDeProfil = :idTypeDeProfil"),
    @NamedQuery(name = "Outils.findByDomaine", query = "SELECT o FROM Outils o WHERE o.outilsPK.domaine = :domaine"),
    @NamedQuery(name = "Outils.findByNiveau", query = "SELECT o FROM Outils o WHERE o.niveau = :niveau")})
public class Outils implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OutilsPK outilsPK;
    @Size(max = 254)
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profilgl profilgl;

    public Outils() {
    }

    public Outils(OutilsPK outilsPK) {
        this.outilsPK = outilsPK;
    }

    public Outils(int idTypeDeProfil, String domaine) {
        this.outilsPK = new OutilsPK(idTypeDeProfil, domaine);
    }

    public OutilsPK getOutilsPK() {
        return outilsPK;
    }

    public void setOutilsPK(OutilsPK outilsPK) {
        this.outilsPK = outilsPK;
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
        hash += (outilsPK != null ? outilsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Outils)) {
            return false;
        }
        Outils other = (Outils) object;
        if ((this.outilsPK == null && other.outilsPK != null) || (this.outilsPK != null && !this.outilsPK.equals(other.outilsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.Outils[ outilsPK=" + outilsPK + " ]";
    }
    
}
