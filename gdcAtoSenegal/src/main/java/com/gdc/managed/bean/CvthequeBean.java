/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.Bdd;
import com.gdc.model.Experiencesprofessionnelles;
import com.gdc.model.Formation;
import com.gdc.model.Langages;
import com.gdc.model.Langues;
import com.gdc.model.Materielssystemesexploitation;
import com.gdc.model.Methodologie;
import com.gdc.model.Modelisation;
import com.gdc.model.Outils;
import com.gdc.model.Profil;
import com.gdc.model.Users;
import com.gdc.services.Cv;
import com.gdc.services.Imetier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author a618092
 */
@ManagedBean(name = "cvthequeBean")
@SessionScoped
public class CvthequeBean implements Serializable {

    /**
     * Creates a new instance of CvthequeBean
     */
    //Spring User Service is injected...
    @ManagedProperty(value = "#{Metier}")
    Imetier metier;

    //Injecting Managed beans
    @ManagedProperty(value = "#{redigerCV}")
    private RedigerCV redigerCV;

    @PostConstruct
    public void init() {
        //ça concerne seulement les uers qui ont le role Candidat
        listeDesCandidatsTrouves = metier.getALLutilisateur();
        //Charger les
        listeDesCvDesCandidatsTrouves = chargertousLesCV();
    }

    private String filiation;
    private String copetencesFonctionnelles;
    private String competencesTechniques;
    private Integer experience;
    private String localité;
    private List listeDesCandidatsTrouves = new ArrayList();
    private List<Cv> listeDesCvDesCandidatsTrouves = new ArrayList();

    public CvthequeBean() {
    }

    public String rechercher() {
        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "cvthèque", " test de la fonction recherche.");
        RequestContext.getCurrentInstance().showMessageInDialog(msg1);
        return null;
    }

    public List chargertousLesCV() {

        List<Cv> lesCvTrouves = new ArrayList();
        //Les composantes du CV
        Materielssystemesexploitation materielssystemesexploitation = null;
        Materielssystemesexploitation materielssystemesexploitation2 = null;
        Materielssystemesexploitation materielssystemesexploitation3 = null;
        Experiencesprofessionnelles experiencesprofessionnelles2 = null;
        Experiencesprofessionnelles experiencesprofessionnelles = null;
        Experiencesprofessionnelles experiencesprofessionnelles3 = null;
        Bdd bdd2 = null;
        Bdd bdd = null;
        Bdd bdd3 = null;
        Modelisation modelisation2 = null;
        Modelisation modelisation = null;
        Modelisation modelisation3 = null;
        Methodologie methodologie2 = null;
        Methodologie methodologie = null;
        Methodologie methodologie3 = null;
        Outils outils2 = null;
        Outils outils = null;
        Outils outils3 = null;
        Langages langages2 = null;
        Langages langages = null;
        Langages langages3 = null;
        Langues langue2 = null;
        Langues langues = null;
        Langues langue3 = null;
        Formation formation2 = null;
        Formation formation = null;
        Formation formation3 = null;
        Profil profilRecup = null;
        Users users = null;

        if (!listeDesCandidatsTrouves.isEmpty()) {
            for (Iterator it = listeDesCandidatsTrouves.iterator(); it.hasNext();) {
                users = (Users) it.next();
                //*************************************************
                profilRecup = metier.getProfilByUsername(users.getUsername());
                if (profilRecup != null) {
                    if (metier.getFormationById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        formation = (Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(0);
                        formation2 = (Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(1);
                        formation3 = (Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(2);
                    }
                    if (metier.getFormationById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        formation = (Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(0);
                    }
                    if (metier.getFormationById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        formation = (Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(0);
                        formation2 = (Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(1);
                    }
                    //*************reintialisation des langues
                    if (metier.getLangueById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        langues = (Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(0);
                        langue2 = (Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(1);
                        langue3 = (Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(2);
                    }
                    if (metier.getLangueById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        langues = (Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(0);
                    }
                    if (metier.getLangueById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        langues = (Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(0);
                        langue2 = (Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(1);
                    }//******************************************************************************
                    //*************reintialisation des langages
                    if (metier.getLangagesById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        langages = (Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(0);
                        langages2 = (Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(1);
                        langages3 = (Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(2);
                    }
                    if (metier.getLangagesById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        langages = (Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(0);
                    }
                    if (metier.getLangagesById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        langages = (Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(0);
                        langages2 = (Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(1);
                    }//******************************************************************************
                    //*************reintialisation des outils
                    if (metier.getOutilsById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        outils = (Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(0);
                        outils2 = (Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(1);
                        outils3 = (Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(2);
                    }
                    if (metier.getOutilsById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        outils = (Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(0);
                    }
                    if (metier.getOutilsById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        outils = (Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(0);
                        outils2 = (Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(1);
                    }//******************************************************************************
                    //*************reintialisation des methodologies
                    if (metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        methodologie = (Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(0);
                        methodologie2 = (Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(1);
                        methodologie3 = (Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(2);
                    }
                    if (metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        methodologie = (Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(0);
                    }
                    if (metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        methodologie = (Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(0);
                        methodologie2 = (Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(1);
                    }//******************************************************************************
                    //*************reintialisation des modelisations
                    if (metier.getModelisationById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        modelisation = (Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(0);
                        modelisation2 = (Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(1);
                        modelisation3 = (Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(2);
                    }
                    if (metier.getModelisationById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        modelisation = (Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(0);
                    }
                    if (metier.getModelisationById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        modelisation = (Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(0);
                        modelisation2 = (Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(1);
                    }//******************************************************************************
                    //*************reintialisation des bdd
                    if (metier.getBddById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        bdd = (Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(0);
                        bdd2 = (Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(1);
                        bdd3 = (Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(2);
                    }
                    if (metier.getBddById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        bdd = (Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(0);
                    }
                    if (metier.getBddById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        bdd = (Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(0);
                        bdd2 = (Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(1);
                    }//******************************************************************************
                    //*************reintialisation des experiences professionnelles
                    if (metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        experiencesprofessionnelles = (Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(0);
                        experiencesprofessionnelles2 = (Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(1);
                        experiencesprofessionnelles3 = (Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(2);
                    }
                    if (metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        experiencesprofessionnelles = (Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(0);
                    }
                    if (metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        experiencesprofessionnelles = (Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(0);
                        experiencesprofessionnelles2 = (Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(1);
                    }//******************************************************************************
                    //*************reintialisation des os
                    if (metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        materielssystemesexploitation = (Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(0);
                        materielssystemesexploitation2 = (Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(1);
                        materielssystemesexploitation3 = (Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(2);
                    }
                    if (metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        materielssystemesexploitation = (Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(0);
                    }
                    if (metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        materielssystemesexploitation = (Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(0);
                        materielssystemesexploitation2 = (Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(1);
                    }//******************************************************************************
                }
                //On construit un cv et on l'ajoute dans la liste
                Cv unCv = new Cv(users, materielssystemesexploitation, materielssystemesexploitation2, materielssystemesexploitation3, experiencesprofessionnelles2, experiencesprofessionnelles, experiencesprofessionnelles3, bdd2, bdd, bdd3, modelisation2, modelisation, modelisation3, methodologie2, methodologie, methodologie3, outils2, outils, outils3, langages2, langages, langages3, langue2, langues, langue3, formation2, formation, formation3, profilRecup);
                lesCvTrouves.add(unCv);
            }
        }
        return lesCvTrouves;
    }

    public Imetier getMetier() {
        return metier;
    }

    public void setMetier(Imetier metier) {
        this.metier = metier;
    }

    public RedigerCV getRedigerCV() {
        return redigerCV;
    }

    public void setRedigerCV(RedigerCV redigerCV) {
        this.redigerCV = redigerCV;
    }

    public String getFiliation() {
        return filiation;
    }

    public void setFiliation(String filiation) {
        this.filiation = filiation;
    }

    public String getCopetencesFonctionnelles() {
        return copetencesFonctionnelles;
    }

    public void setCopetencesFonctionnelles(String copetencesFonctionnelles) {
        this.copetencesFonctionnelles = copetencesFonctionnelles;
    }

    public String getCompetencesTechniques() {
        return competencesTechniques;
    }

    public void setCompetencesTechniques(String competencesTechniques) {
        this.competencesTechniques = competencesTechniques;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getLocalité() {
        return localité;
    }

    public void setLocalité(String localité) {
        this.localité = localité;
    }

    public List getListeDesCandidatsTrouves() {
        return listeDesCandidatsTrouves;
    }

    public void setListeDesCandidatsTrouves(List listeDesCandidatsTrouves) {
        this.listeDesCandidatsTrouves = listeDesCandidatsTrouves;
    }

    public List getListeDesCvDesCandidatsTrouves() {
        return listeDesCvDesCandidatsTrouves;
    }

    public void setListeDesCvDesCandidatsTrouves(List listeDesCvDesCandidatsTrouves) {
        this.listeDesCvDesCandidatsTrouves = listeDesCvDesCandidatsTrouves;
    }

}
