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
public class FormationPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idTypeDeProfil")
    private int idTypeDeProfil;
    @Basic(optional = false)
    @Size(min = 1, max = 254)
    @Column(name = "nomDiplome")
    private String nomDiplome;

    public FormationPK() {
    }

    public FormationPK(int idTypeDeProfil, String nomDiplome) {
        this.idTypeDeProfil = idTypeDeProfil;
        this.nomDiplome = nomDiplome;
    }

    public int getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public void setIdTypeDeProfil(int idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public String getNomDiplome() {
        return nomDiplome;
    }

    public void setNomDiplome(String nomDiplome) {
        this.nomDiplome = nomDiplome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTypeDeProfil;
        hash += (nomDiplome != null ? nomDiplome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormationPK)) {
            return false;
        }
        FormationPK other = (FormationPK) object;
        if (this.idTypeDeProfil != other.idTypeDeProfil) {
            return false;
        }
        if ((this.nomDiplome == null && other.nomDiplome != null) || (this.nomDiplome != null && !this.nomDiplome.equals(other.nomDiplome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.FormationPK[ idTypeDeProfil=" + idTypeDeProfil + ", nomDiplome=" + nomDiplome + " ]";
    }
    
}
