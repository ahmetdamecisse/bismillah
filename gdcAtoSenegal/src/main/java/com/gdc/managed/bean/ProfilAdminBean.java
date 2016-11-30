/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.Users;
import com.gdc.services.Imetier;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cisseahmet
 */
@ManagedBean(name = "profilAdminBean")
@SessionScoped
public class ProfilAdminBean implements Serializable {

    //Spring User Service is injected...
    @ManagedProperty(value = "#{Metier}")
    Imetier metier;

    //Injecting Managed beans
    @ManagedProperty(value = "#{redigerCV}")
    private RedigerCV redigerCV;

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

    public void enregistrer() {
        //CE username  et ce password ne sont pas deja utilise?
        //update userRole

        //update utilisateur
        Users user=new Users();
        user=redigerCV.getUser();
        user.setPassword("admin2");
        metier.updateUtilisateur(user);
        System.out.println(user);
    }

    public void annuler() {
        System.out.println("Bonjour!");
    }

    /**
     * Creates a new instance of ProfilAdminBean
     */
    public ProfilAdminBean() {
    }

}
