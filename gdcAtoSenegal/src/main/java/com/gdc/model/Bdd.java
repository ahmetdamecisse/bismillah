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
@Table(name = "bdd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bdd.findAll", query = "SELECT b FROM Bdd b"),
    @NamedQuery(name = "Bdd.findByIdTypeDeProfil", query = "SELECT b FROM Bdd b WHERE b.bddPK.idTypeDeProfil = :idTypeDeProfil"),
    @NamedQuery(name = "Bdd.findByDomaine", query = "SELECT b FROM Bdd b WHERE b.bddPK.domaine = :domaine"),
    @NamedQuery(name = "Bdd.findByNiveau", query = "SELECT b FROM Bdd b WHERE b.niveau = :niveau")})
public class Bdd implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BddPK bddPK;
    @Size(max = 254)
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profilgl profilgl;

    public Bdd() {
    }

    public Bdd(BddPK bddPK) {
        this.bddPK = bddPK;
    }

    public Bdd(int idTypeDeProfil, String domaine) {
        this.bddPK = new BddPK(idTypeDeProfil, domaine);
    }

    public BddPK getBddPK() {
        return bddPK;
    }

    public void setBddPK(BddPK bddPK) {
        this.bddPK = bddPK;
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
        hash += (bddPK != null ? bddPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bdd)) {
            return false;
        }
        Bdd other = (Bdd) object;
        if ((this.bddPK == null && other.bddPK != null) || (this.bddPK != null && !this.bddPK.equals(other.bddPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.Bdd[ bddPK=" + bddPK + " ]";
    }
    
}
