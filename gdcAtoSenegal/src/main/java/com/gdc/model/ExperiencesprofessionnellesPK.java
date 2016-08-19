/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author a618092
 */
@Embeddable
public class ExperiencesprofessionnellesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idTypeDeProfil")
    private int idTypeDeProfil;
    @Basic(optional = false)
    @Column(name = "datededebut")
    @Temporal(TemporalType.DATE)
    private Date datededebut;
    @Basic(optional = false)
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;

    public ExperiencesprofessionnellesPK() {
    }

    public ExperiencesprofessionnellesPK(int idTypeDeProfil, Date datededebut, Date datefin) {
        this.idTypeDeProfil = idTypeDeProfil;
        this.datededebut = datededebut;
        this.datefin = datefin;
    }

    public int getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public void setIdTypeDeProfil(int idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public Date getDatededebut() {
        return datededebut;
    }

    public void setDatededebut(Date datededebut) {
        this.datededebut = datededebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTypeDeProfil;
        hash += (datededebut != null ? datededebut.hashCode() : 0);
        hash += (datefin != null ? datefin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperiencesprofessionnellesPK)) {
            return false;
        }
        ExperiencesprofessionnellesPK other = (ExperiencesprofessionnellesPK) object;
        if (this.idTypeDeProfil != other.idTypeDeProfil) {
            return false;
        }
        if ((this.datededebut == null && other.datededebut != null) || (this.datededebut != null && !this.datededebut.equals(other.datededebut))) {
            return false;
        }
        if ((this.datefin == null && other.datefin != null) || (this.datefin != null && !this.datefin.equals(other.datefin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.testeur.ExperiencesprofessionnellesPK[ idTypeDeProfil=" + idTypeDeProfil + ", datededebut=" + datededebut + ", datefin=" + datefin + " ]";
    }
    
}
