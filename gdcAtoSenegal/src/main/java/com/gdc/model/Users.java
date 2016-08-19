/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdoulahi
 */
@Entity
@Table(name = "users")
@XmlRootElement

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Size(min = 1, max = 150)
    @Column(name = "username")
    private String username;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 500)
    @Column(name = "localisation")
    private String localisation;
    @Size(max = 254)
    @Column(name = "mail")
    private String mail;
    @Size(max = 254)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @Size(min = 1, max = 254)
    @NotNull
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private short enabled;
    @Size(max = 254)
    @Column(name = "specialite")
    private String specialite;
    @Column(name = "dateDeNaissance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeNaissance;
    @Column(name = "version")
    @Version
    private Integer version;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private Administrateur administrateur;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private Candidat candidat;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private Recruteur recruteur;

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }

    public Users(String username, String password, short enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
//pour créer un administrateur

    public Users(String username, String nom, String prenom, String localisation, String mail, String telephone, String password, String specialite, Date dateDeNaissance, Administrateur administrateur) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.localisation = localisation;
        this.mail = mail;
        this.telephone = telephone;
        this.password = password;
        this.specialite = specialite;
        this.dateDeNaissance = dateDeNaissance;
        this.administrateur = administrateur;
    }
//pour créer un candidat

    public Users(String username, String nom, String prenom, String localisation, String mail, String telephone, String password, String specialite, Date dateDeNaissance, short enabled, Integer version) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.localisation = localisation;
        this.mail = mail;
        this.telephone = telephone;
        this.password = password;
        this.specialite = specialite;
        this.dateDeNaissance = dateDeNaissance;
        this.version = version;
        this.enabled = enabled;
    }
//pour créer un recruteur

    public Users(String username, String nom, String prenom, String localisation, String mail, String telephone, String password, String specialite, Date dateDeNaissance, Recruteur recruteur) {
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.localisation = localisation;
        this.mail = mail;
        this.telephone = telephone;
        this.password = password;
        this.specialite = specialite;
        this.dateDeNaissance = dateDeNaissance;
        this.recruteur = recruteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Recruteur getRecruteur() {
        return recruteur;
    }

    public void setRecruteur(Recruteur recruteur) {
        this.recruteur = recruteur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Users[ username=" + username + " ]";
    }

}
