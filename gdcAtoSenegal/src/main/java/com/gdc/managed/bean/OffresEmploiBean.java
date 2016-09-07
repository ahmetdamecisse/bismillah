/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.Offresemploi;
import com.gdc.model.Recruteur;
import com.gdc.services.Imetier;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author a618092@ManagedBean
 */
@ManagedBean(name = "offresEmploiBean")
@SessionScoped
public class OffresEmploiBean {

    //Spring User Service is injected...
    @ManagedProperty(value = "#{Metier}")
    Imetier metier;

    public Imetier getMetier() {
        return metier;
    }

    public void setMetier(Imetier metier) {
        this.metier = metier;
    }

    //Injecting Managed beans
    @ManagedProperty(value = "#{redigerCV}")
    private RedigerCV redigerCV;

    public void setRedigerCV(RedigerCV redigerCV) {
        this.redigerCV = redigerCV;
    }

    public RedigerCV getRedigerCV() {
        return redigerCV;
    }

    private Offresemploi offresemploi = new Offresemploi();

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
        //persistance
        Recruteur recruteur = new Recruteur("ahmet");
        offresemploi.setUsername(recruteur);
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

    public void viderFormulaireOffreEmploi() {
    }
}
