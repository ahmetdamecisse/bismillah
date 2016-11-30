/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author cisseahmet
 */
@ManagedBean(name = "candidatsAdminBean")
@SessionScoped
public class CandidatsAdminBean implements Serializable{

    /**
     * Creates a new instance of CandidatsAdminBean
     */
    public CandidatsAdminBean() {
    }
    
}
