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
@Table(name = "langages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Langages.findAll", query = "SELECT l FROM Langages l"),
    @NamedQuery(name = "Langages.findByIdTypeDeProfil", query = "SELECT l FROM Langages l WHERE l.langagesPK.idTypeDeProfil = :idTypeDeProfil"),
    @NamedQuery(name = "Langages.findByDomaine", query = "SELECT l FROM Langages l WHERE l.langagesPK.domaine = :domaine"),
    @NamedQuery(name = "Langages.findByNiveau", query = "SELECT l FROM Langages l WHERE l.niveau = :niveau")})
public class Langages implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LangagesPK langagesPK;
    @Size(max = 254)
    @Column(name = "niveau")
    private String niveau;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profilgl profilgl;

    public Langages() {
    }

    public Langages(LangagesPK langagesPK) {
        this.langagesPK = langagesPK;
    }

    public Langages(int idTypeDeProfil, String domaine) {
        this.langagesPK = new LangagesPK(idTypeDeProfil, domaine);
    }

    public LangagesPK getLangagesPK() {
        return langagesPK;
    }

    public void setLangagesPK(LangagesPK langagesPK) {
        this.langagesPK = langagesPK;
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
        hash += (langagesPK != null ? langagesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Langages)) {
            return false;
        }
        Langages other = (Langages) object;
        if ((this.langagesPK == null && other.langagesPK != null) || (this.langagesPK != null && !this.langagesPK.equals(other.langagesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.Langages[ langagesPK=" + langagesPK + " ]";
    }
    
}
