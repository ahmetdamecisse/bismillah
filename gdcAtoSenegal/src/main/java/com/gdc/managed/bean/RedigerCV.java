/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdc.managed.bean;

import com.gdc.model.*;
import com.gdc.services.Imetier;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author a618092
 */
@ManagedBean(name="redigerCV")
@RequestScoped
public class RedigerCV {
    
    //Spring User Service is injected...
 @ManagedProperty(value="#{Metier}")
 Imetier metier;
 
 public Imetier getMetier() {
        return metier;
    }

    public void setMetier(Imetier metier) {
        this.metier = metier;
    }
/**
     * Creates a new instance of RedigerCV
     */
    public RedigerCV() {
    } private Users user = new Users();
    private Candidat candidat = new Candidat();
    private Profilgl profilgl = new Profilgl();
    private Profil profil = new Profil();
    private Materielssystemesexploitation materielssystemesexploitation = new Materielssystemesexploitation();
    private Formation formation = new Formation();
    private Formation formation2 = new Formation();

    public Formation getFormation2() {
        return formation2;
    }

    public void setFormation2(Formation formation2) {
        this.formation2 = formation2;
    }

    public Formation getFormation3() {
        return formation3;
    }

    public void setFormation3(Formation formation3) {
        this.formation3 = formation3;
    }
    private Formation formation3 = new Formation();
    private Outils outils = new Outils();
    private Experiencesprofessionnelles experiencesprofessionnelles = new Experiencesprofessionnelles();
    private Langages langage = new Langages();
    private Methodologie methodologie = new Methodologie();
    private Modelisation modelisation = new Modelisation();
    private Bdd bdd = new Bdd();

    private boolean skip;
  

    public Profilgl getProfilgl() {
        return profilgl;
    }

    public void setProfilgl(Profilgl profilgl) {
        this.profilgl = profilgl;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Materielssystemesexploitation getMaterielssystemesexploitation() {
        return materielssystemesexploitation;
    }

    public void setMaterielssystemesexploitation(Materielssystemesexploitation materielssystemesexploitation) {
        this.materielssystemesexploitation = materielssystemesexploitation;
    }

    public Outils getOutils() {
        return outils;
    }

    public void setOutils(Outils outils) {
        this.outils = outils;
    }

    public Experiencesprofessionnelles getExperiencesprofessionnelles() {
        return experiencesprofessionnelles;
    }

    public void setExperiencesprofessionnelles(Experiencesprofessionnelles experiencesprofessionnelles) {
        this.experiencesprofessionnelles = experiencesprofessionnelles;
    }

    public Langages getLangage() {
        return langage;
    }

    public void setLangage(Langages langage) {
        this.langage = langage;
    }

    public Methodologie getMethodologie() {
        return methodologie;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setMethodologie(Methodologie methodologie) {
        this.methodologie = methodologie;
    }

    public Modelisation getModelisation() {
        return modelisation;
    }

    public void setModelisation(Modelisation modelisation) {
        this.modelisation = modelisation;
    }

    public Bdd getBdd() {
        return bdd;
    }

    public void setBdd(Bdd bdd) {
        this.bdd = bdd;
    }

    public Langues getLangues() {
        return langues;
    }

    public void setLangues(Langues langues) {
        this.langues = langues;
    }
    private Langues langues = new Langues();

    public Candidat getCandidat() {
        return candidat;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public void save() {
        //----------------Les insertions se feront dans cette partie-----------------------------------------------------------------
        FacesMessage msg = new FacesMessage("Successful", "Bonjour :" + user.getPrenom()+" "+"votre cv a été crée avec succès");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }
}
