/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.Candidat;
import com.gdc.model.Offresemploi;
import com.gdc.services.Imetier;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DefaultTreeNode;

/**
 *
 * @author a618092
 */
@ManagedBean(name = "notificationsBean")
@SessionScoped
public class NotificationsBean implements Serializable {

    /**
     * Creates a new instance of NotificationsBean
     */
    //Spring User Service is injected...
    @ManagedProperty(value = "#{Metier}")
    Imetier metier;

    @PostConstruct
    public void init() {
        listecandidats = metier.getAllCandidat();
        root = new DefaultTreeNode(new Candidat());
        if (!listecandidats.isEmpty()) {
            for (int i = 0; i < listecandidats.size(); i++) {
                DefaultTreeNode unCandidat = new DefaultTreeNode(listecandidats.get(i), root);
            }
        }
    }

    private List listecandidats;
    private DefaultTreeNode root;
    private Candidat selectedCandidat;

    public Candidat getSelectedCandidat() {
        return selectedCandidat;
    }

    public void setSelectedCandidat(Candidat selectedCandidat) {
        this.selectedCandidat = selectedCandidat;
    }

    public List getListecandidats() {
        return listecandidats;
    }

    public Imetier getMetier() {
        return metier;
    }

    public void setMetier(Imetier metier) {
        this.metier = metier;
    }

    public void setListecandidats(List listecandidats) {
        this.listecandidats = listecandidats;
    }

    public DefaultTreeNode getRoot() {
        return root;
    }

    public void setRoot(DefaultTreeNode root) {
        this.root = root;
    }

    public NotificationsBean() {
    }

}
