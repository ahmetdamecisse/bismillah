/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.Offresemploi;
import com.gdc.services.Imetier;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;

/**
 *
 * @author a618092@ManagedBean
 */
@ManagedBean(name = "offresEmploiBean")
@SessionScoped
public class OffresEmploiBean implements Serializable {

    //Spring User Service is injected...
    @ManagedProperty(value = "#{Metier}")
    Imetier metier;

    //Injecting Managed beans
    @ManagedProperty(value = "#{redigerCV}")
    private RedigerCV redigerCV;

    @PostConstruct
    public void init() {
        listeDesOffresEmploi = metier.getAllOffresemploi();
        root = new DefaultTreeNode(new Offresemploi("intitulés", "descriptions", "types de contrat", "categories", "profils recherché", "diplomes demandes", "langues parlees", new Date(), new Date(), "prerequis du poste", "descriptions de la societe", Integer.MIN_VALUE));
        if (!listeDesOffresEmploi.isEmpty()) {
            for (int i = 0; i < listeDesOffresEmploi.size(); i++) {
                 DefaultTreeNode uneOffre1 = new DefaultTreeNode(listeDesOffresEmploi.get(i), root);
            }
        }
    }
//fghjkl
    public Imetier getMetier() {
        return metier;
    }

    public void setMetier(Imetier metier) {
        this.metier = metier;
    }

    public void setRedigerCV(RedigerCV redigerCV) {
        this.redigerCV = redigerCV;
    }

    public RedigerCV getRedigerCV() {
        return redigerCV;
    }

    private Offresemploi offresemploi = new Offresemploi();
    private List listeDesOffresEmploi;
    private Offresemploi selectedOffre;
    private DefaultTreeNode root;

    public DefaultTreeNode getRoot() {
        return root;
    }

    public void setRoot(DefaultTreeNode root) {
        this.root = root;
    }

    public Offresemploi getSelectedOffre() {
        return selectedOffre;
    }

    public void setSelectedOffre(Offresemploi selectedOffre) {
        this.selectedOffre = selectedOffre;
    }

    public List getListeDesOffresEmploi() {
        return listeDesOffresEmploi;
    }

    public void setListeDesOffresEmploi(List listeDesOffresEmploi) {
        this.listeDesOffresEmploi = listeDesOffresEmploi;
    }

    public Offresemploi getOffresemploi() {
        return offresemploi;
    }

    public void setOffresemploi(Offresemploi offresemploi) {
        this.offresemploi = offresemploi;
    }

    /**
     * Creates a new instance of OffresEmploiBean
     */
    public OffresEmploiBean() {
    }

    public String validerOffreEmploi() {
        //persistance avec le recruteur qui s'est connecté
        offresemploi.setUsername(metier.getRecruteurById(redigerCV.getUser().getUsername()));
        metier.addOffresemploi(offresemploi);
        //informations
        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement", " L'offre d'emploi est sauvegardée avec succès!");
        RequestContext.getCurrentInstance().showMessageInDialog(msg1);
        return null;
    }

    public String annulerOffreEmploi() {
        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Annulation", " Vous avez annulé la saisie de l'offre d'emploi!");
        RequestContext.getCurrentInstance().showMessageInDialog(msg1);
        return null;
    }

    public String postulerAuxOffreEmploi() {
         //persistance avec le candidat qui s'est connecté
        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Postulation", " Votre postulation à cette offre d'emploi est bien enregistrée!");
        RequestContext.getCurrentInstance().showMessageInDialog(msg1);
        return null;
    }

    public void viderFormulaireOffreEmploi() {
    }
}
