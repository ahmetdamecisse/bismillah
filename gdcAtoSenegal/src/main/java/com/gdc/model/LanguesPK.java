/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdc.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

/**
 *
 * @author a618092
 */
@Embeddable
public class LanguesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idTypeDeProfil")
    private int idTypeDeProfil;
    @Basic(optional = false)
    @Size(min = 0, max = 254)
    @Column(name = "nom")
    private String nom;

    public LanguesPK() {
    }

    public LanguesPK(int idTypeDeProfil, String nom) {
        this.idTypeDeProfil = idTypeDeProfil;
        this.nom = nom;
    }

    public int getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public void setIdTypeDeProfil(int idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTypeDeProfil;
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LanguesPK)) {
            return false;
        }
        LanguesPK other = (LanguesPK) object;
        if (this.idTypeDeProfil != other.idTypeDeProfil) {
            return false;
        }
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.LanguesPK[ idTypeDeProfil=" + idTypeDeProfil + ", nom=" + nom + " ]";
    }
    
}
