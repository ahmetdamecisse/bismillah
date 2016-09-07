/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a618092
 */
@Entity
@Table(name = "offresemploi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offresemploi.findAll", query = "SELECT o FROM Offresemploi o"),
    @NamedQuery(name = "Offresemploi.findByIdOffreEmploi", query = "SELECT o FROM Offresemploi o WHERE o.idOffreEmploi = :idOffreEmploi"),
    @NamedQuery(name = "Offresemploi.findByIntitulePoste", query = "SELECT o FROM Offresemploi o WHERE o.intitulePoste = :intitulePoste"),
    @NamedQuery(name = "Offresemploi.findByTypeDeContrat", query = "SELECT o FROM Offresemploi o WHERE o.typeDeContrat = :typeDeContrat"),
    @NamedQuery(name = "Offresemploi.findByCategorie", query = "SELECT o FROM Offresemploi o WHERE o.categorie = :categorie"),
    @NamedQuery(name = "Offresemploi.findByProfilRecherche", query = "SELECT o FROM Offresemploi o WHERE o.profilRecherche = :profilRecherche"),
    @NamedQuery(name = "Offresemploi.findByDiplomeDemandes", query = "SELECT o FROM Offresemploi o WHERE o.diplomeDemandes = :diplomeDemandes"),
    @NamedQuery(name = "Offresemploi.findByLanguesParlees", query = "SELECT o FROM Offresemploi o WHERE o.languesParlees = :languesParlees"),
    @NamedQuery(name = "Offresemploi.findByDebutContrat", query = "SELECT o FROM Offresemploi o WHERE o.debutContrat = :debutContrat"),
    @NamedQuery(name = "Offresemploi.findByFincontrat", query = "SELECT o FROM Offresemploi o WHERE o.fincontrat = :fincontrat"),
    @NamedQuery(name = "Offresemploi.findByPrerequisDuPoste", query = "SELECT o FROM Offresemploi o WHERE o.prerequisDuPoste = :prerequisDuPoste"),
    @NamedQuery(name = "Offresemploi.findByDescriptifDeLaSociete", query = "SELECT o FROM Offresemploi o WHERE o.descriptifDeLaSociete = :descriptifDeLaSociete"),
    @NamedQuery(name = "Offresemploi.findByNbreDanneesDexperiences", query = "SELECT o FROM Offresemploi o WHERE o.nbreDanneesDexperiences = :nbreDanneesDexperiences")})
public class Offresemploi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOffreEmploi")
    private Integer idOffreEmploi;
    @Size(max = 500)
    @Column(name = "intitulePoste")
    private String intitulePoste;
    @Lob
    @Size(max = 16777215)
    @Column(name = "description")
    private String description;
    @Size(max = 500)
    @Column(name = "typeDeContrat")
    private String typeDeContrat;
    @Size(max = 500)
    @Column(name = "categorie")
    private String categorie;
    @Size(max = 1000)
    @Column(name = "profilRecherche")
    private String profilRecherche;
    @Size(max = 500)
    @Column(name = "diplomeDemandes")
    private String diplomeDemandes;
    @Size(max = 500)
    @Column(name = "LanguesParlees")
    private String languesParlees;
    @Column(name = "debutContrat")
    @Temporal(TemporalType.DATE)
    private Date debutContrat;
    @Column(name = "fincontrat")
    @Temporal(TemporalType.DATE)
    private Date fincontrat;
    @Size(max = 1000)
    @Column(name = "prerequisDuPoste")
    private String prerequisDuPoste;
    @Size(max = 3000)
    @Column(name = "descriptifDeLaSociete")
    private String descriptifDeLaSociete;
    @Column(name = "nbreDanneesDexperiences")
    private Integer nbreDanneesDexperiences;
    
    @ManyToMany(mappedBy = "offresemploiList")
    private List<Candidat> candidatList;
    
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Recruteur username;

    public Offresemploi() {
    }

    public Offresemploi(Integer idOffreEmploi) {
        this.idOffreEmploi = idOffreEmploi;
    }

    public Integer getIdOffreEmploi() {
        return idOffreEmploi;
    }

    public void setIdOffreEmploi(Integer idOffreEmploi) {
        this.idOffreEmploi = idOffreEmploi;
    }

    public String getIntitulePoste() {
        return intitulePoste;
    }

    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeDeContrat() {
        return typeDeContrat;
    }

    public void setTypeDeContrat(String typeDeContrat) {
        this.typeDeContrat = typeDeContrat;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getProfilRecherche() {
        return profilRecherche;
    }

    public void setProfilRecherche(String profilRecherche) {
        this.profilRecherche = profilRecherche;
    }

    public String getDiplomeDemandes() {
        return diplomeDemandes;
    }

    public void setDiplomeDemandes(String diplomeDemandes) {
        this.diplomeDemandes = diplomeDemandes;
    }

    public String getLanguesParlees() {
        return languesParlees;
    }

    public void setLanguesParlees(String languesParlees) {
        this.languesParlees = languesParlees;
    }

    public Date getDebutContrat() {
        return debutContrat;
    }

    public void setDebutContrat(Date debutContrat) {
        this.debutContrat = debutContrat;
    }

    public Date getFincontrat() {
        return fincontrat;
    }

    public void setFincontrat(Date fincontrat) {
        this.fincontrat = fincontrat;
    }

    public String getPrerequisDuPoste() {
        return prerequisDuPoste;
    }

    public void setPrerequisDuPoste(String prerequisDuPoste) {
        this.prerequisDuPoste = prerequisDuPoste;
    }

    public String getDescriptifDeLaSociete() {
        return descriptifDeLaSociete;
    }

    public void setDescriptifDeLaSociete(String descriptifDeLaSociete) {
        this.descriptifDeLaSociete = descriptifDeLaSociete;
    }

    public Integer getNbreDanneesDexperiences() {
        return nbreDanneesDexperiences;
    }

    public void setNbreDanneesDexperiences(Integer nbreDanneesDexperiences) {
        this.nbreDanneesDexperiences = nbreDanneesDexperiences;
    }

    @XmlTransient
    public List<Candidat> getCandidatList() {
        return candidatList;
    }

    public void setCandidatList(List<Candidat> candidatList) {
        this.candidatList = candidatList;
    }

    public Recruteur getUsername() {
        return username;
    }

    public void setUsername(Recruteur username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOffreEmploi != null ? idOffreEmploi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offresemploi)) {
            return false;
        }
        Offresemploi other = (Offresemploi) object;
        if ((this.idOffreEmploi == null && other.idOffreEmploi != null) || (this.idOffreEmploi != null && !this.idOffreEmploi.equals(other.idOffreEmploi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gdc.dao.Offresemploi[ idOffreEmploi=" + idOffreEmploi+" intitulé du poste: "+intitulePoste+" description: "+description+" username: "+username + " ]";
    }
    
}
