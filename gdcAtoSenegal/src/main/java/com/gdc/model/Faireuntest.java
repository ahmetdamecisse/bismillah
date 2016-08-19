/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdc.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdoulahi
 */
@Entity
@Table(name = "faireuntest")
@XmlRootElement
public class Faireuntest implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FaireuntestPK faireuntestPK;

    public Faireuntest() {
    }

    public Faireuntest(FaireuntestPK faireuntestPK) {
        this.faireuntestPK = faireuntestPK;
    }

    public Faireuntest(String username, int idFicheTest) {
        this.faireuntestPK = new FaireuntestPK(username, idFicheTest);
    }

    public FaireuntestPK getFaireuntestPK() {
        return faireuntestPK;
    }

    public void setFaireuntestPK(FaireuntestPK faireuntestPK) {
        this.faireuntestPK = faireuntestPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faireuntestPK != null ? faireuntestPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faireuntest)) {
            return false;
        }
        Faireuntest other = (Faireuntest) object;
        if ((this.faireuntestPK == null && other.faireuntestPK != null) || (this.faireuntestPK != null && !this.faireuntestPK.equals(other.faireuntestPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Faireuntest[ faireuntestPK=" + faireuntestPK + " ]";
    }
    
}
