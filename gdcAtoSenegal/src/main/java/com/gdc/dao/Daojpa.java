/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.dao;


import com.gdc.model.*;
import java.io.Serializable;
import org.hibernate.SessionFactory;

/**
 *
 * @author a618092
 */
public class Daojpa implements Idao{
    
private SessionFactory sessionFactory;

@Override
 public void addUser(Users user) { 
  getSessionFactory().getCurrentSession().save(user);
 } 

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
