/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.services;

import com.gdc.model.Bdd;
import com.gdc.model.BddPK;
import com.gdc.model.Candidat;
import com.gdc.model.Experiencesprofessionnelles;
import com.gdc.model.ExperiencesprofessionnellesPK;
import com.gdc.model.Formation;
import com.gdc.model.FormationPK;
import com.gdc.model.Langages;
import com.gdc.model.LangagesPK;
import com.gdc.model.Langues;
import com.gdc.model.LanguesPK;
import com.gdc.model.Materielssystemesexploitation;
import com.gdc.model.MaterielssystemesexploitationPK;
import com.gdc.model.Methodologie;
import com.gdc.model.MethodologiePK;
import com.gdc.model.Modelisation;
import com.gdc.model.ModelisationPK;
import com.gdc.model.Outils;
import com.gdc.model.OutilsPK;
import com.gdc.model.Profil;
import com.gdc.model.Profilgl;
import com.gdc.model.Users;

/**
 *
 * @author a618092
 */
public class Cv {

    //Les composantes du CV
    private Users user;
    private Materielssystemesexploitation materielssystemesexploitation;
    private Materielssystemesexploitation materielssystemesexploitation2;
    private Materielssystemesexploitation materielssystemesexploitation3;
    private Experiencesprofessionnelles experiencesprofessionnelles2;
    private Experiencesprofessionnelles experiencesprofessionnelles;
    private Experiencesprofessionnelles experiencesprofessionnelles3;
    private Bdd bdd2;
    private Bdd bdd;
    private Bdd bdd3;
    private Modelisation modelisation2;
    private Modelisation modelisation;
    private Modelisation modelisation3;
    private Methodologie methodologie2;
    private Methodologie methodologie;
    private Methodologie methodologie3;
    private Outils outils2;
    private Outils outils;
    private Outils outils3;
    private Langages langages2;
    private Langages langages;
    private Langages langages3;
    private Langues langue2;
    private Langues langues;
    private Langues langue3;
    private Formation formation2;
    private Formation formation;
    private Formation formation3;
    private Profil profilRecup;

    public Cv(Users user, Materielssystemesexploitation materielssystemesexploitation, Materielssystemesexploitation materielssystemesexploitation2, Materielssystemesexploitation materielssystemesexploitation3, Experiencesprofessionnelles experiencesprofessionnelles2, Experiencesprofessionnelles experiencesprofessionnelles, Experiencesprofessionnelles experiencesprofessionnelles3, Bdd bdd2, Bdd bdd, Bdd bdd3, Modelisation modelisation2, Modelisation modelisation, Modelisation modelisation3, Methodologie methodologie2, Methodologie methodologie, Methodologie methodologie3, Outils outils2, Outils outils, Outils outils3, Langages langages2, Langages langages, Langages langages3, Langues langue2, Langues langues, Langues langue3, Formation formation2, Formation formation, Formation formation3, Profil profilRecup) {
        this.user = user;
        this.materielssystemesexploitation = materielssystemesexploitation;
        this.materielssystemesexploitation2 = materielssystemesexploitation2;
        this.materielssystemesexploitation3 = materielssystemesexploitation3;
        this.experiencesprofessionnelles2 = experiencesprofessionnelles2;
        this.experiencesprofessionnelles = experiencesprofessionnelles;
        this.experiencesprofessionnelles3 = experiencesprofessionnelles3;
        this.bdd2 = bdd2;
        this.bdd = bdd;
        this.bdd3 = bdd3;
        this.modelisation2 = modelisation2;
        this.modelisation = modelisation;
        this.modelisation3 = modelisation3;
        this.methodologie2 = methodologie2;
        this.methodologie = methodologie;
        this.methodologie3 = methodologie3;
        this.outils2 = outils2;
        this.outils = outils;
        this.outils3 = outils3;
        this.langages2 = langages2;
        this.langages = langages;
        this.langages3 = langages3;
        this.langue2 = langue2;
        this.langues = langues;
        this.langue3 = langue3;
        this.formation2 = formation2;
        this.formation = formation;
        this.formation3 = formation3;
        this.profilRecup = profilRecup;
    }
    
    

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Materielssystemesexploitation getMaterielssystemesexploitation() {
        return materielssystemesexploitation;
    }

    public void setMaterielssystemesexploitation(Materielssystemesexploitation materielssystemesexploitation) {
        this.materielssystemesexploitation = materielssystemesexploitation;
    }

    public Materielssystemesexploitation getMaterielssystemesexploitation2() {
        return materielssystemesexploitation2;
    }

    public void setMaterielssystemesexploitation2(Materielssystemesexploitation materielssystemesexploitation2) {
        this.materielssystemesexploitation2 = materielssystemesexploitation2;
    }

    public Materielssystemesexploitation getMaterielssystemesexploitation3() {
        return materielssystemesexploitation3;
    }

    public void setMaterielssystemesexploitation3(Materielssystemesexploitation materielssystemesexploitation3) {
        this.materielssystemesexploitation3 = materielssystemesexploitation3;
    }

    public Experiencesprofessionnelles getExperiencesprofessionnelles2() {
        return experiencesprofessionnelles2;
    }

    public void setExperiencesprofessionnelles2(Experiencesprofessionnelles experiencesprofessionnelles2) {
        this.experiencesprofessionnelles2 = experiencesprofessionnelles2;
    }

    public Experiencesprofessionnelles getExperiencesprofessionnelles() {
        return experiencesprofessionnelles;
    }

    public void setExperiencesprofessionnelles(Experiencesprofessionnelles experiencesprofessionnelles) {
        this.experiencesprofessionnelles = experiencesprofessionnelles;
    }

    public Experiencesprofessionnelles getExperiencesprofessionnelles3() {
        return experiencesprofessionnelles3;
    }

    public void setExperiencesprofessionnelles3(Experiencesprofessionnelles experiencesprofessionnelles3) {
        this.experiencesprofessionnelles3 = experiencesprofessionnelles3;
    }

    public Bdd getBdd2() {
        return bdd2;
    }

    public void setBdd2(Bdd bdd2) {
        this.bdd2 = bdd2;
    }

    public Bdd getBdd() {
        return bdd;
    }

    public void setBdd(Bdd bdd) {
        this.bdd = bdd;
    }

    public Bdd getBdd3() {
        return bdd3;
    }

    public void setBdd3(Bdd bdd3) {
        this.bdd3 = bdd3;
    }

    public Modelisation getModelisation2() {
        return modelisation2;
    }

    public void setModelisation2(Modelisation modelisation2) {
        this.modelisation2 = modelisation2;
    }

    public Modelisation getModelisation() {
        return modelisation;
    }

    public void setModelisation(Modelisation modelisation) {
        this.modelisation = modelisation;
    }

    public Modelisation getModelisation3() {
        return modelisation3;
    }

    public void setModelisation3(Modelisation modelisation3) {
        this.modelisation3 = modelisation3;
    }

    public Methodologie getMethodologie2() {
        return methodologie2;
    }

    public void setMethodologie2(Methodologie methodologie2) {
        this.methodologie2 = methodologie2;
    }

    public Methodologie getMethodologie() {
        return methodologie;
    }

    public void setMethodologie(Methodologie methodologie) {
        this.methodologie = methodologie;
    }

    public Methodologie getMethodologie3() {
        return methodologie3;
    }

    public void setMethodologie3(Methodologie methodologie3) {
        this.methodologie3 = methodologie3;
    }

    public Outils getOutils2() {
        return outils2;
    }

    public void setOutils2(Outils outils2) {
        this.outils2 = outils2;
    }

    public Outils getOutils() {
        return outils;
    }

    public void setOutils(Outils outils) {
        this.outils = outils;
    }

    public Outils getOutils3() {
        return outils3;
    }

    public void setOutils3(Outils outils3) {
        this.outils3 = outils3;
    }

    public Langages getLangages2() {
        return langages2;
    }

    public void setLangages2(Langages langages2) {
        this.langages2 = langages2;
    }

    public Langages getLangages() {
        return langages;
    }

    public void setLangages(Langages langages) {
        this.langages = langages;
    }

    public Langages getLangages3() {
        return langages3;
    }

    public void setLangages3(Langages langages3) {
        this.langages3 = langages3;
    }

    public Langues getLangue2() {
        return langue2;
    }

    public void setLangue2(Langues langue2) {
        this.langue2 = langue2;
    }

    public Langues getLangues() {
        return langues;
    }

    public void setLangues(Langues langues) {
        this.langues = langues;
    }

    public Langues getLangue3() {
        return langue3;
    }

    public void setLangue3(Langues langue3) {
        this.langue3 = langue3;
    }

    public Formation getFormation2() {
        return formation2;
    }

    public void setFormation2(Formation formation2) {
        this.formation2 = formation2;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Formation getFormation3() {
        return formation3;
    }

    public void setFormation3(Formation formation3) {
        this.formation3 = formation3;
    }

    public Profil getProfilRecup() {
        return profilRecup;
    }

    public void setProfilRecup(Profil profilRecup) {
        this.profilRecup = profilRecup;
    }

}
