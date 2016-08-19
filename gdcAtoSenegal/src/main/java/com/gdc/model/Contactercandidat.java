/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdc.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdoulahi
 */
@Entity
@Table(name = "contactercandidat")
@XmlRootElement
 public class Contactercandidat implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContactercandidatPK contactercandidatPK;

    public Contactercandidat() {
    }

    public Contactercandidat(ContactercandidatPK contactercandidatPK) {
        this.contactercandidatPK = contactercandidatPK;
    }

    public Contactercandidat(String recusername, String username) {
        this.contactercandidatPK = new ContactercandidatPK(recusername, username);
    }

    public ContactercandidatPK getContactercandidatPK() {
        return contactercandidatPK;
    }

    public void setContactercandidatPK(ContactercandidatPK contactercandidatPK) {
        this.contactercandidatPK = contactercandidatPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactercandidatPK != null ? contactercandidatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactercandidat)) {
            return false;
        }
        Contactercandidat other = (Contactercandidat) object;
        if ((this.contactercandidatPK == null && other.contactercandidatPK != null) || (this.contactercandidatPK != null && !this.contactercandidatPK.equals(other.contactercandidatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Contactercandidat[ contactercandidatPK=" + contactercandidatPK + " ]";
    }
    
}
