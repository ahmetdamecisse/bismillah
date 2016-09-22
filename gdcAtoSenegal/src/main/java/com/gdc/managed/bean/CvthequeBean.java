/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.services.Imetier;
import java.io.Serializable;
import java.util.ArrayList;
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
        listeDesCvTrouves = metier.getALLutilisateur();
    }

    private String filiation;
    private String copetencesFonctionnelles;
    private String competencesTechniques;
    private Integer experience;
    private String localité;
    private List listeDesCvTrouves = new ArrayList();

    public CvthequeBean() {
    }

    public String rechercher() {
        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "cvthèque", " test de la fonction recherche.");
        RequestContext.getCurrentInstance().showMessageInDialog(msg1);
        return null;
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

    public List getListeDesCvTrouves() {
        return listeDesCvTrouves;
    }

    public void setListeDesCvTrouves(List listeDesCvTrouves) {
        this.listeDesCvTrouves = listeDesCvTrouves;
    }

}
