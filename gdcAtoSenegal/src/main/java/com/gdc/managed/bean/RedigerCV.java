/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.*;
import com.gdc.services.Imetier;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author a618092
 */
@ManagedBean(name = "redigerCV")
@ViewScoped
public class RedigerCV implements Serializable {

    //Spring User Service is injected...
    @ManagedProperty(value = "#{Metier}")
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
    }

    private Users user = new Users();
    private Candidat candidat = new Candidat();
    private Profilgl profilgl = new Profilgl();
    private Profil profil = new Profil();
    private Materielssystemesexploitation materielssystemesexploitation = new Materielssystemesexploitation();
    private Materielssystemesexploitation materielssystemesexploitation2 = new Materielssystemesexploitation();
    private Materielssystemesexploitation materielssystemesexploitation3 = new Materielssystemesexploitation();
    private Formation formation = new Formation();
    private Formation formation2 = new Formation();
    private Formation formation3 = new Formation();
    private Outils outils = new Outils();
    private Outils outils2 = new Outils();
    private Outils outils3 = new Outils();
    private Experiencesprofessionnelles experiencesprofessionnelles = new Experiencesprofessionnelles();
    private Experiencesprofessionnelles experiencesprofessionnelles2 = new Experiencesprofessionnelles();
    private Experiencesprofessionnelles experiencesprofessionnelles3 = new Experiencesprofessionnelles();
    private Langages langage = new Langages();
    private Langages langage2 = new Langages();
    private Langages langage3 = new Langages();
    private Methodologie methodologie = new Methodologie();
    private Methodologie methodologie2 = new Methodologie();
    private Methodologie methodologie3 = new Methodologie();
    private Modelisation modelisation = new Modelisation();
    private Modelisation modelisation2 = new Modelisation();
    private Modelisation modelisation3 = new Modelisation();
    private Bdd bdd = new Bdd();
    private Bdd bdd2 = new Bdd();
    private Bdd bdd3 = new Bdd();
    private Langues langues = new Langues();
    private String loginConnexion;
    private String passwordConnexion;

    public String getLoginConnexion() {
        return loginConnexion;
    }

    public void setLoginConnexion(String loginConnexion) {
        this.loginConnexion = loginConnexion;
    }

    public String getPasswordConnexion() {
        return passwordConnexion;
    }

    public void setPasswordConnexion(String passwordConnexion) {
        this.passwordConnexion = passwordConnexion;
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

    public Outils getOutils2() {
        return outils2;
    }

    public void setOutils2(Outils outils2) {
        this.outils2 = outils2;
    }

    public Outils getOutils3() {
        return outils3;
    }

    public void setOutils3(Outils outils3) {
        this.outils3 = outils3;
    }

    public Experiencesprofessionnelles getExperiencesprofessionnelles2() {
        return experiencesprofessionnelles2;
    }

    public void setExperiencesprofessionnelles2(Experiencesprofessionnelles experiencesprofessionnelles2) {
        this.experiencesprofessionnelles2 = experiencesprofessionnelles2;
    }

    public Experiencesprofessionnelles getExperiencesprofessionnelles3() {
        return experiencesprofessionnelles3;
    }

    public void setExperiencesprofessionnelles3(Experiencesprofessionnelles experiencesprofessionnelles3) {
        this.experiencesprofessionnelles3 = experiencesprofessionnelles3;
    }

    public Langages getLangage2() {
        return langage2;
    }

    public void setLangage2(Langages langage2) {
        this.langage2 = langage2;
    }

    public Langages getLangage3() {
        return langage3;
    }

    public void setLangage3(Langages langage3) {
        this.langage3 = langage3;
    }

    public Methodologie getMethodologie2() {
        return methodologie2;
    }

    public void setMethodologie2(Methodologie methodologie2) {
        this.methodologie2 = methodologie2;
    }

    public Methodologie getMethodologie3() {
        return methodologie3;
    }

    public void setMethodologie3(Methodologie methodologie3) {
        this.methodologie3 = methodologie3;
    }

    public Modelisation getModelisation2() {
        return modelisation2;
    }

    public void setModelisation2(Modelisation modelisation2) {
        this.modelisation2 = modelisation2;
    }

    public Modelisation getModelisation3() {
        return modelisation3;
    }

    public void setModelisation3(Modelisation modelisation3) {
        this.modelisation3 = modelisation3;
    }

    public Bdd getBdd2() {
        return bdd2;
    }

    public void setBdd2(Bdd bdd2) {
        this.bdd2 = bdd2;
    }

    public Bdd getBdd3() {
        return bdd3;
    }

    public void setBdd3(Bdd bdd3) {
        this.bdd3 = bdd3;
    }

    public Langues getLangues2() {
        return langues2;
    }

    public void setLangues2(Langues langues2) {
        this.langues2 = langues2;
    }

    public Langues getLangues3() {
        return langues3;
    }

    public void setLangues3(Langues langues3) {
        this.langues3 = langues3;
    }
    private Langues langues2 = new Langues();
    private Langues langues3 = new Langues();

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

    public void enregistrer() {
        //----------------Les insertions se feront dans cette partie-----------------------------------------------------------------
        FacesMessage msg = new FacesMessage("Successful", "Bonjour :" + user.getPrenom() + " " + "votre cv a été crée avec succès");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void anuuler() {
        //----------------Les insertions se feront dans cette partie-----------------------------------------------------------------
        FacesMessage msg = new FacesMessage("Successful", "Bonjour :" + user.getPrenom() + " " + "votre cv a été crée avec succès");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String controlConnexion() {
        Users userRecup = metier.getUtilisateurByLoginAndPassporw(loginConnexion, passwordConnexion);
        if (userRecup != null) {
            user = userRecup;
            return "candidats.AtoS?faces-redirect=true";
        } else {
            FacesMessage msg2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authentification ratée.", "username ou mot de passe incorrect!");
            RequestContext.getCurrentInstance().showMessageInDialog(msg2);
        }
        return null;

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
