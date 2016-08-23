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
import org.primefaces.context.RequestContext;

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

    public String validerInscription() {
        user.setVersion(1);
        user.setEnabled((short) 1);

        if (metier.ceUsernameEstIlUtiliseDeja(user.getUsername())) {
            FacesMessage msg2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, user.getUsername(), " est dèja utilisé. Merci de choisir un autre username!");
            RequestContext.getCurrentInstance().showMessageInDialog(msg2);
        } else {
            metier.addUtilisateur(user);
            FacesMessage msg3 = new FacesMessage(FacesMessage.SEVERITY_INFO, user.getNom(), " votre compte est créé avec succès. Merci!");
            RequestContext.getCurrentInstance().showMessageInDialog(msg3);
            //je dois fournir à rédigerCvBean le username pour continuer le reste
            return "candidats.AtoS?faces-redirect=true";
        }
        return null;
    }

    public String annulerInscription() {
     return "index.AtoS?faces-redirect=true";
    }
}
