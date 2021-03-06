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
public class ModelisationPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idTypeDeProfil")
    private int idTypeDeProfil;
    @Basic(optional = false)
    @Size(min = 0, max = 254)
    @Column(name = "domaine")
    private String domaine;

    public ModelisationPK() {
    }

    public ModelisationPK(int idTypeDeProfil, String domaine) {
        this.idTypeDeProfil = idTypeDeProfil;
        this.domaine = domaine;
    }

    public int getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public void setIdTypeDeProfil(int idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTypeDeProfil;
        hash += (domaine != null ? domaine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelisationPK)) {
            return false;
        }
        ModelisationPK other = (ModelisationPK) object;
        if (this.idTypeDeProfil != other.idTypeDeProfil) {
            return false;
        }
        if ((this.domaine == null && other.domaine != null) || (this.domaine != null && !this.domaine.equals(other.domaine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.ModelisationPK[ idTypeDeProfil=" + idTypeDeProfil + ", domaine=" + domaine + " ]";
    }
    
}
