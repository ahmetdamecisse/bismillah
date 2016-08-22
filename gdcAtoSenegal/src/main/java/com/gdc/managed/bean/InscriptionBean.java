/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.Users;
import com.gdc.services.Imetier;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author a618092
 */
@ManagedBean(name = "inscriptionBean")
@ViewScoped
public class InscriptionBean {

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
     * Creates a new instance of InscriptionBean
     */
    public InscriptionBean() {
    }

     private Users user = new Users();

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
     public void validerInscription() {
       FacesMessage msg = new FacesMessage("Validation", "Bonjour!" + " " + "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
     }
     public String annulerInscription() {
         return "annulerInscription";
     }
}
