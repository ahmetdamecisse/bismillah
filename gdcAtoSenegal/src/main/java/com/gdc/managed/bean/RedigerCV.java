/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gdc.managed.bean;

import com.gdc.services.Imetier;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author a618092
 */
@ManagedBean(name="redigerCV")
@RequestScoped
public class RedigerCV {

    /**
     * Creates a new instance of RedigerCV
     */
    public RedigerCV() {
    }
    //Spring User Service is injected...
 @ManagedProperty(value="#{Metier}")
 Imetier metier;

}
