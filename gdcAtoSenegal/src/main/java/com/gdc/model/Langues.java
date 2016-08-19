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
@Table(name = "langues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Langues.findAll", query = "SELECT l FROM Langues l"),
    @NamedQuery(name = "Langues.findByIdTypeDeProfil", query = "SELECT l FROM Langues l WHERE l.languesPK.idTypeDeProfil = :idTypeDeProfil"),
    @NamedQuery(name = "Langues.findByNom", query = "SELECT l FROM Langues l WHERE l.languesPK.nom = :nom"),
    @NamedQuery(name = "Langues.findByNiveau", query = "SELECT l FROM Langues l WHERE l.niveau = :niveau")})
public class Langues implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LanguesPK languesPK;
    @Size(max = 254)
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profilgl profilgl;

    public Langues() {
    }

    public Langues(LanguesPK languesPK) {
        this.languesPK = languesPK;
    }

    public Langues(int idTypeDeProfil, String nom) {
        this.languesPK = new LanguesPK(idTypeDeProfil, nom);
    }

    public LanguesPK getLanguesPK() {
        return languesPK;
    }

    public void setLanguesPK(LanguesPK languesPK) {
        this.languesPK = languesPK;
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
        hash += (languesPK != null ? languesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Langues)) {
            return false;
        }
        Langues other = (Langues) object;
        if ((this.languesPK == null && other.languesPK != null) || (this.languesPK != null && !this.languesPK.equals(other.languesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.Langues[ languesPK=" + languesPK + " ]";
    }
    
}
