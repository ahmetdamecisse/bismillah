/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.Offresemploi;
import com.gdc.services.Imetier;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

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

    /**
     * Creates a new instance of OffresEmploiBean
     */
    public OffresEmploiBean() {
    }
}
