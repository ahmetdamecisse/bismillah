/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.UserRoles;
import com.gdc.model.Users;
import com.gdc.services.Imetier;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author a618092
 */
@ManagedBean(name = "inscriptionBean")
@SessionScoped
public class InscriptionBean implements Serializable{

    //Spring User Service is injected...
    @ManagedProperty(value = "#{Metier}")
    Imetier metier;

    //Injecting Managed beans
    @ManagedProperty(value = "#{redigerCV}")
    private RedigerCV redigerCV;

    public void setRedigerCV(RedigerCV redigerCV) {
        this.redigerCV = redigerCV;
    }

    public RedigerCV getRedigerCV() {
        return redigerCV;
    }

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
        } else if (!user.getMail().contains("@") || !user.getMail().contains(".")) {
            FacesMessage msg4 = new FacesMessage(FacesMessage.SEVERITY_INFO, user.getMail(), " Addresse Email invalide");
            RequestContext.getCurrentInstance().showMessageInDialog(msg4);
        } else {
            metier.addUtilisateur(user);
            //je dois fournir à rédigerCvBean le username pour continuer le reste 
            //c'est ce qui justifie l'instruction suivante
            redigerCV.setUser(user);
            //je donne un droit à l'utilisateur nouvellement créé.
            UserRoles usrRoles=new UserRoles("ROLE_CANDIDAT", user);
            metier.addUserRole(usrRoles);
            return "candidats.AtoS?faces-redirect=true";
        }

        return null;
    }

    public String annulerInscription() {
        return "index.AtoS?faces-redirect=true";
    }
}
