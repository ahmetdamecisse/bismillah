/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.services.Cv;
import com.gdc.services.Imetier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

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
        //Charger les Cv
        List listeDesUtilisateurs = metier.getALLutilisateur();
        List listeDesCandidatsDeLaBase = metier.getAllCandidat();
        listeDesCvDesCandidatsTrouves = metier.chargertousLesCV(listeDesUtilisateurs, listeDesCandidatsDeLaBase);
    }

    private String filiation;
    private String copetencesFonctionnelles;
    private String competencesTechniques;
    private Integer experience;
    private String localité;
    private List<Cv> listeDesCvDesCandidatsTrouves = new ArrayList();

    public CvthequeBean() {
    }

    public String rechercher() {
         Integer val = null;
        //Esk un candidat ayant la filiaition renseignée existe
        
        //Esk un candidat ayant les competences fonctionnelles demandées existent
        
        //Esk un candidat ayant les compétences techniques demandées existent
        
        //Esk un candidat ayant le nombre d'années d'expériences demandé existe
        for (int i = 0; i < listeDesCvDesCandidatsTrouves.size(); i++) {
            Cv cv = listeDesCvDesCandidatsTrouves.get(i);
             val=cv.getProfilRecup().getNombreAnneesExperience();
            if (val.compareTo(experience)==-1) {
                listeDesCvDesCandidatsTrouves.remove(cv);
            }
        }
        //Esk un candidat habitant la localité renseignée existe
        //-------------------------------------------------------
        
//        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "cvthèque", filiation + "|" + competencesTechniques + "|" + copetencesFonctionnelles + "|" + experience + "|" + localité);
//        RequestContext.getCurrentInstance().showMessageInDialog(msg1);
        return "cvtheque.AtoS?faces-redirect=true";
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

    public List getListeDesCvDesCandidatsTrouves() {
        return listeDesCvDesCandidatsTrouves;
    }

    public void setListeDesCvDesCandidatsTrouves(List listeDesCvDesCandidatsTrouves) {
        this.listeDesCvDesCandidatsTrouves = listeDesCvDesCandidatsTrouves;
    }

}
