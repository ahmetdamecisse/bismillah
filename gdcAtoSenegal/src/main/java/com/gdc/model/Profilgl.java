/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abdoulahi
 */
@Entity
@Table(name = "profilgl")
@XmlRootElement
public class Profilgl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTypeDeProfil")
    private Integer idTypeDeProfil;
    @Column(name = "version")
    @Version
    private Integer version;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profilgl")
    private Formation formation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profilgl")
    private Langages langages;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profilgl")
    private Langues langues;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profilgl")
    private Experiencesprofessionnelles experiencesprofessionnelles;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profilgl")
    private Materielssystemesexploitation materielssystemesexploitation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profilgl")
    private Methodologie methodologie;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profilgl")
    private Bdd bdd;
    @JoinColumn(name = "idTypeDeProfil", referencedColumnName = "idTypeDeProfil", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Profil profil;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profilgl")
    private Outils outils;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profilgl")
    private Modelisation modelisation;

    public Profilgl() {
    }

    public Profilgl(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public Integer getIdTypeDeProfil() {
        return idTypeDeProfil;
    }

    public Profilgl(Integer idTypeDeProfil, Integer version, Formation formation, Langages langages, Langues langues, Experiencesprofessionnelles experiencesprofessionnelles, Materielssystemesexploitation materielssystemesexploitation, Methodologie methodologie, Bdd bdd, Profil profil, Outils outils, Modelisation modelisation) {
        this.idTypeDeProfil = idTypeDeProfil;
        this.version = version;
        this.formation = formation;
        this.langages = langages;
        this.langues = langues;
        this.experiencesprofessionnelles = experiencesprofessionnelles;
        this.materielssystemesexploitation = materielssystemesexploitation;
        this.methodologie = methodologie;
        this.bdd = bdd;
        this.profil = profil;
        this.outils = outils;
        this.modelisation = modelisation;
    }

    public void setIdTypeDeProfil(Integer idTypeDeProfil) {
        this.idTypeDeProfil = idTypeDeProfil;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Langages getLangages() {
        return langages;
    }

    public void setLangages(Langages langages) {
        this.langages = langages;
    }

    public Langues getLangues() {
        return langues;
    }

    public void setLangues(Langues langues) {
        this.langues = langues;
    }

    public Experiencesprofessionnelles getExperiencesprofessionnelles() {
        return experiencesprofessionnelles;
    }

    public void setExperiencesprofessionnelles(Experiencesprofessionnelles experiencesprofessionnelles) {
        this.experiencesprofessionnelles = experiencesprofessionnelles;
    }

    public Materielssystemesexploitation getMaterielssystemesexploitation() {
        return materielssystemesexploitation;
    }

    public void setMaterielssystemesexploitation(Materielssystemesexploitation materielssystemesexploitation) {
        this.materielssystemesexploitation = materielssystemesexploitation;
    }

    public Methodologie getMethodologie() {
        return methodologie;
    }

    public void setMethodologie(Methodologie methodologie) {
        this.methodologie = methodologie;
    }

    public Bdd getBdd() {
        return bdd;
    }

    public void setBdd(Bdd bdd) {
        this.bdd = bdd;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Outils getOutils() {
        return outils;
    }

    public void setOutils(Outils outils) {
        this.outils = outils;
    }

    public Modelisation getModelisation() {
        return modelisation;
    }

    public void setModelisation(Modelisation modelisation) {
        this.modelisation = modelisation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeDeProfil != null ? idTypeDeProfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profilgl)) {
            return false;
        }
        Profilgl other = (Profilgl) object;
        if ((this.idTypeDeProfil == null && other.idTypeDeProfil != null) || (this.idTypeDeProfil != null && !this.idTypeDeProfil.equals(other.idTypeDeProfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Profilgl[ idTypeDeProfil=" + idTypeDeProfil + " ]";
    }

}
