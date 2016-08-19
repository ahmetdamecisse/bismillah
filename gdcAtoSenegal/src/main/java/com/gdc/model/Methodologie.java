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
@Table(name = "methodologie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Methodologie.findAll", query = "SELECT m FROM Methodologie m"),
    @NamedQuery(name = "Methodologie.findByIdTypeDeProfil", query = "SELECT m FROM Methodologie m WHERE m.methodologiePK.idTypeDeProfil = :idTypeDeProfil"),
    @NamedQuery(name = "Methodologie.findByDomaine", query = "SELECT m FROM Methodologie m WHERE m.methodologiePK.domaine = :domaine"),
    @NamedQuery(name = "Methodologie.findByNiveau", query = "SELECT m FROM Methodologie m WHERE m.niveau = :niveau")})
public class Methodologie implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MethodologiePK methodologiePK;
    @Size(max = 254)
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profilgl profilgl;

    public Methodologie() {
    }

    public Methodologie(MethodologiePK methodologiePK) {
        this.methodologiePK = methodologiePK;
    }

    public Methodologie(int idTypeDeProfil, String domaine) {
        this.methodologiePK = new MethodologiePK(idTypeDeProfil, domaine);
    }

    public MethodologiePK getMethodologiePK() {
        return methodologiePK;
    }

    public void setMethodologiePK(MethodologiePK methodologiePK) {
        this.methodologiePK = methodologiePK;
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
        hash += (methodologiePK != null ? methodologiePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Methodologie)) {
            return false;
        }
        Methodologie other = (Methodologie) object;
        if ((this.methodologiePK == null && other.methodologiePK != null) || (this.methodologiePK != null && !this.methodologiePK.equals(other.methodologiePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.Methodologie[ methodologiePK=" + methodologiePK + " ]";
    }
    
}
