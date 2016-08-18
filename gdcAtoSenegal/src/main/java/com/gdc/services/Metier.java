/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.services;

import com.gdc.dao.Idao;
import com.gdc.model.*;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author a618092
 */
@Transactional(readOnly = true)
public class Metier implements Imetier{
    private Idao daojpa;

    @Transactional(readOnly = false)
    @Override
    public void addUser(Users user) {
     daojpa.addUser(user);
    }

    public Idao getDaojpa() {
        return daojpa;
    }

    public void setDaojpa(Idao daojpa) {
        this.daojpa = daojpa;
    }
}
