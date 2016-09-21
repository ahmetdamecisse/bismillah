/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.services.Imetier;
import java.io.Serializable;
import java.math.BigInteger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import com.gdc.model.Entretien;

/**
 *
 * @author a618092
 */
@ManagedBean(name = "entretienBean")
@SessionScoped
public class EntretienBean implements Serializable {

    /**
     * Creates a new instance of EntretienBean
     */
    //Spring User Service is injected...
    @ManagedProperty(value = "#{Metier}")
    Imetier metier;

    //Injecting Managed beans
    @ManagedProperty(value = "#{redigerCV}")
    private RedigerCV redigerCV;
    private Entretien entretien=new Entretien();
    
    
    public EntretienBean() {
    }

    public String fixerEntretienCandidat() {
        // entretien.setVersion(1);
        entretien.setUsername(metier.getRecruteurById(redigerCV.getUser().getUsername()));
        entretien.setResultat(BigInteger.ZERO);
        
        metier.addEntretien(entretien);
        
        FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "Entretien", "Enregistré avec succès.");
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

    public Entretien getEntretien() {
        return entretien;
    }

    public void setEntretien(Entretien entretien) {
        this.entretien = entretien;
    }
    
}
