/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.dao;

import com.gdc.exceptions.pfcgdcexception;
import com.gdc.model.*;
import com.gdc.services.Cv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author a618092
 */
@Component
public class Daojpa implements Idao {

    private SessionFactory sessionFactory;

    @Override
    public List getALLutilisateur() {
        try {
            List list = getSessionFactory().getCurrentSession().createQuery("from Users").list();
            return list;
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getALLutilisateur(): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Users getUtilisateurById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addUtilisateur(Users u) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(u);
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode addUtilisateur(): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    public boolean ceUsernameEstIlUtiliseDeja(String username) {
        List<Users> users = getALLutilisateur();
        if (users.size() > 0) {
            for (Iterator<Users> iterator = users.iterator(); iterator.hasNext();) {
                Users next = iterator.next();
                if (next.getUsername().equalsIgnoreCase(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeUtilisateur(Integer idUtili) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateUtilisateur(Users u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getUtilisateurByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Users getUtilisateurByLoginAndPassporw(String login, String password) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Users where username= :leUsername and password= :lePassword")
                    .setParameter("leUsername", login)
                    .setParameter("lePassword", password).list();
            if (list.size() != 0) {
                return (Users) list.get(0);
            }
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getUtilisateurByLoginAndPassporw(): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getAllAdministrateur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addAdministrateur(Administrateur a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeAdministrateur(Integer idAdminAsupp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateAdministrateur(Users modifiant, Integer idAdminAmodifier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Administrateur getAdministrateurById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAdministrateurByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllCandidat() {
        return getSessionFactory().getCurrentSession().createQuery("from Candidat").list();
    }

    public void addCandidat(Candidat c) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(c);
        } catch (Throwable th) {
            System.out.println("erreur lors de l'ajout du du candidat" + c.getUsername());
            throw new pfcgdcexception(th, 3);
        }
    }

    public void removeCandidat(Candidat c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateCandidat(Users utilisateurModifinat, Integer idCandidatAmodifier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Candidat getCandidatById(String username) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Candidat where username= :leusername")
                    .setParameter("leusername", username).list();
            if (!list.isEmpty()) {
                return (Candidat) list.get(0);
            }
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getCandidatById: \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getCandidatByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getCandidatByFullName(String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getCandidatByCompetencesPrincipales(String cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getCandidatByCompetencesFontionnelles(String cf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getCandidatByNombreAnneesExperience(int nbreAnneeExp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllRecruteur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addRecruteur(Recruteur r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeRecruteur(Integer idRecruteurAsupp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateRecruteur(Users recruteurRemplaçant, Integer idRecruteurRemplace) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Recruteur getRecruteurById(String username) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Recruteur where username= :leusername")
                    .setParameter("leusername", username).list();
            if (!list.isEmpty()) {
                return (Recruteur) list.get(0);
            }
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getRecruteurById: \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getRecruteurByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllBdd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addBdd(Bdd bdd) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(bdd);
        } catch (Throwable th) {
            System.out.println("erreur lors de l'ajout de la bdd" + bdd.getProfilgl());
            throw new pfcgdcexception(th, 3);
        }
    }

    public void removeBdd(Bdd bdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateBdd(Bdd bdd, Integer idUtilsateurbddModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getBddById(Integer id) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Bdd where idTypeDeProfil= :lidTypeDeProfil")
                    .setParameter("lidTypeDeProfil", id).list();
            return list;
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getbddById: \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getBddByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllEntretien() {
          try {
            List list = getSessionFactory().getCurrentSession().createQuery("from Entretien").list();
            return list;
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getAllEntretien(): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public void addEntretien(Entretien e) {
        try {
            getSessionFactory().getCurrentSession().save(e);
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode addEntretien(): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    public void removeEntretien(Entretien e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateEntretien(Entretien e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Entretien getEntretienById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getEntretienByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllExperiencesprofessionnelles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addExperiencesprofessionnelles(Experiencesprofessionnelles e) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(e);
        } catch (Throwable th) {
            System.out.println("erreur lors de la persistence de l'objet experience pro" + e.getDescription());
            throw new pfcgdcexception(th, 10);
        }
    }

    public void removeExperiencesprofessionnelles(Experiencesprofessionnelles e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateExperiencesprofessionnelles(Experiencesprofessionnelles e, Integer idUtilsateurEpModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getExperiencesprofessionnellesById(Integer id) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Experiencesprofessionnelles where idTypeDeProfil= :lidTypeDeProfil")
                    .setParameter("lidTypeDeProfil", id).list();
            return list;
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getExperiencesprofessionnellesById: \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getExperiencesprofessionnellesByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllFichedeposte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addFichedeposte(Fichedeposte f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeFichedeposte(Fichedeposte f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateFichedeposte(Fichedeposte f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Fichedeposte getFichedeposteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getFichedeposteByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllFichedetest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addFichedetest(Fichedetest f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeFichedetest(Fichedetest f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateFichedetest(Fichedetest f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Fichedetest getFichedetestById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getFichedetestByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllFormation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addFormation(Formation f) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(f);
        } catch (Throwable th) {
            System.out.println("erreur lors de l'ajout de la formation" + f.getFormationPK().getNomDiplome());
            throw new pfcgdcexception(th, 6);
        }
    }

    public void removeFormation(Formation f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateFormation(Formation f, Integer idUtilsateurFormModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getFormationById(Integer id) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Formation where idTypeDeProfil= :lidTypeDeProfil")
                    .setParameter("lidTypeDeProfil", id).list();
            return list;
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getFormationById: \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getFormationByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllLangages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addLangages(Langages l) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(l);
        } catch (Throwable th) {
            System.out.println("erreur lors de la persistence de l'objet langage" + l.getProfilgl());
            throw new pfcgdcexception(th, 11);
        }
    }

    public void removeLangages(Langages l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateLangages(Langages l, Integer idUtilsateurLangageModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getLangagesById(Integer id) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Langages where idTypeDeProfil= :lidTypeDeProfil")
                    .setParameter("lidTypeDeProfil", id).list();
            return list;
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getLangagesByIdByID(): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getLangagesByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllLangue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addLangues(Langues l) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(l);
        } catch (Throwable th) {
            System.out.println("erreur lors de la persistence de l'objet Langues" + l.getProfilgl());
            throw new pfcgdcexception(th, 9);
        }
    }

    public void removeLangues(Langues l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateLangues(Langues l, Integer idUtilsateurLangueModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Langues getLanguesById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getLanguesByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllListequestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getListequestionByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllListereponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getListereponseByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllMaterielssystemesexploitation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addMaterielssystemesexploitation(Materielssystemesexploitation m) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(m);
        } catch (Throwable th) {
            System.out.println("erreur lors de la persistence de l'objet materiel et système d'exploitation" + m.getProfilgl());
            throw new pfcgdcexception(th, 8);
        }
    }

    public void removeMaterielssystemesexploitation(Materielssystemesexploitation m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateMaterielssystemesexploitation(Materielssystemesexploitation m, Integer idUtilsateurMSModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getMaterielssystemesexploitationById(Integer id) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Materielssystemesexploitation where idTypeDeProfil= :lidTypeDeProfil")
                    .setParameter("lidTypeDeProfil", id).list();
            return list;
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getMaterielssystemesexploitationById: \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getMaterielssystemesexploitationByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllMethodologie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addMethodologie(Methodologie m) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(m);
        } catch (Throwable th) {
            System.out.println("erreur lors de la persistence de l'objet méthodologie" + m.getProfilgl());
            throw new pfcgdcexception(th, 11);
        }
    }

    public void removeMethodologie(Methodologie m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateMethodologie(Methodologie m, Integer idUtilsateurMethoModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getMethodologieById(Integer id) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Methodologie where idTypeDeProfil= :lidTypeDeProfil")
                    .setParameter("lidTypeDeProfil", id).list();
            return list;
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getMethodologieById: \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getMethodologieByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllModelisation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addModelisation(Modelisation m) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(m);
        } catch (Throwable th) {
            System.out.println("erreur lors de la persistence de l'objet modélisation" + m.getProfilgl());
            throw new pfcgdcexception(th, 11);
        }
    }

    public void removeModelisation(Modelisation m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateModelisation(Modelisation m, Integer idUtilsateurModelModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getModelisationById(Integer id) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Modelisation where idTypeDeProfil= :lidTypeDeProfil")
                    .setParameter("lidTypeDeProfil", id).list();
            return list;
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getModelisationById: \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getModelisationByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllNotification() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addNotification(Notification n) {
        try {
            getSessionFactory().getCurrentSession().save(n);
        } catch (Throwable th) {
            System.out.println("erreur lors de la persistence de l'objet Notification" + n.getCorpsMessage());
            throw new pfcgdcexception(th, 10);
        }
    }

    public void removeNotification(Notification n) {
        //To change body of generated methods, choose Tools | Templates.
    }

    public void updateNotification(Notification n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Notification getNotificationById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getNotificationByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllOutils() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addOutils(Outils o) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(o);
        } catch (Throwable th) {
            System.out.println("erreur lors de la persistence de l'objet outil" + o.getProfilgl());
            throw new pfcgdcexception(th, 9);
        }
    }

    public void removeOutils(Outils o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateOutils(Outils o, Integer idUtilsateurOutilModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getOutilsById(Integer id) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Outils where idTypeDeProfil= :lidTypeDeProfil")
                    .setParameter("lidTypeDeProfil", id).list();
            return list;
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getOutilsById): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getOutilsByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllProil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addProfil(Profil p) {

        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(p);
        } catch (Throwable th) {
            System.out.println("erreur lors de l'ajout du profil");
            throw new pfcgdcexception(th, 5);
        }

    }

    public void removeProfil(Profil p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateProfil(Profil p, Integer idCandidatAmodifProfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Profil getProfilById(Integer id) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Profil where idTypeDeProfil= :lidTypeDeProfil")
                    .setParameter("lidTypeDeProfil", id).list();
            Profil p;
            if (!list.isEmpty()) {
                p = (Profil) list.get(0);
                return p;
            }
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getProfilById): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    public List getProfilByCompetence(String x, String y, String z) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getProfilByCompetenceFonctionnelle(String x, String y, String z) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllProfilgl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addProfilgl(Profilgl p) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(p);
        } catch (Throwable th) {
            System.out.println("erreur lors de l'ajout du profilGl");
            throw new pfcgdcexception(th, 5);
        }
    }

    public void removeProfilgl(Profilgl p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateProfilgl(Integer idUtilsateurProfilglModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Profilgl getProfilglById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getProfilglByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllQuestionsFi(Fichedetest f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List getAllAnswersFi(Fichedetest f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String quiSestConnecte(String username) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from UserRoles").list();
            if (!list.isEmpty()) {
                for (Iterator it = list.iterator(); it.hasNext();) {
                    UserRoles userRoles = (UserRoles) it.next();
                    if (userRoles.getUsername().getUsername().equalsIgnoreCase(username)) {
                        return userRoles.getRole();
                    }

                }
            }
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode quiSestConnecte): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    @Override
    public void addUserRole(UserRoles userRole) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(userRole);
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode addUserRole: \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    @Override
    public Profil getProfilByUsername(String leUsername) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Candidat where username= :leUsername")
                    .setParameter("leUsername", leUsername).list();
            if (list.size() != 0) {
                Candidat candidat = (Candidat) list.get(0);
                return candidat.getIdTypeDeProfil();
            }
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getProfilByUsername(): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    @Override
    public List getLangueById(Integer id) {
        try {
            List list = getSessionFactory().getCurrentSession()
                    .createQuery("from Langues where idTypeDeProfil= :lidTypeDeProfil")
                    .setParameter("lidTypeDeProfil", id).list();
            return list;
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode getLanguesByID(): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        return null;
    }

    @Override
    public List getAllOffresemploi() {
        return getSessionFactory().getCurrentSession().createQuery("from Offresemploi").list();
    }

    @Override
    public void addOffresemploi(Offresemploi o) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(o);
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode addOffresemploi: \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }

    @Override
    public void removeOffresemploi(Offresemploi o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOffresemploi(Offresemploi o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Notification getOffresemploiById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getOffresemploiByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List chargertousLesCV(List listeDesUtilisateurs, List listeDesCandidatsDeLaBase) {
        List<Cv> lesCvTrouves = new ArrayList();
        //Les composantes du CV
        Materielssystemesexploitation materielssystemesexploitation = null;
        Materielssystemesexploitation materielssystemesexploitation2 = null;
        Materielssystemesexploitation materielssystemesexploitation3 = null;
        Experiencesprofessionnelles experiencesprofessionnelles2 = null;
        Experiencesprofessionnelles experiencesprofessionnelles = null;
        Experiencesprofessionnelles experiencesprofessionnelles3 = null;
        Bdd bdd2 = null;
        Bdd bdd = null;
        Bdd bdd3 = null;
        Modelisation modelisation2 = null;
        Modelisation modelisation = null;
        Modelisation modelisation3 = null;
        Methodologie methodologie2 = null;
        Methodologie methodologie = null;
        Methodologie methodologie3 = null;
        Outils outils2 = null;
        Outils outils = null;
        Outils outils3 = null;
        Langages langages2 = null;
        Langages langages = null;
        Langages langages3 = null;
        Langues langue2 = null;
        Langues langues = null;
        Langues langue3 = null;
        Formation formation2 = null;
        Formation formation = null;
        Formation formation3 = null;
        Profil profilRecup = null;
        Users users = null;

        if (!listeDesUtilisateurs.isEmpty() && !listeDesCandidatsDeLaBase.isEmpty()) {
            for (Iterator it = listeDesUtilisateurs.iterator(); it.hasNext();) {
                users = (Users) it.next();
                for (Iterator<Candidat> it1 = listeDesCandidatsDeLaBase.iterator(); it1.hasNext();) {
                    Candidat candi = it1.next();
                    if (candi.getUsername().equalsIgnoreCase(users.getUsername())) {
                        //*************************************************
                        profilRecup = getProfilByUsername(users.getUsername());
                        if (profilRecup != null) {
                            if (getFormationById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                                formation = (Formation) getFormationById(profilRecup.getIdTypeDeProfil()).get(0);
                                formation2 = (Formation) getFormationById(profilRecup.getIdTypeDeProfil()).get(1);
                                formation3 = (Formation) getFormationById(profilRecup.getIdTypeDeProfil()).get(2);
                            }
                            if (getFormationById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                                formation = (Formation) getFormationById(profilRecup.getIdTypeDeProfil()).get(0);
                            }
                            if (getFormationById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                                formation = (Formation) getFormationById(profilRecup.getIdTypeDeProfil()).get(0);
                                formation2 = (Formation) getFormationById(profilRecup.getIdTypeDeProfil()).get(1);
                            }
                            //*************reintialisation des langues
                            if (getLangueById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                                langues = (Langues) getLangueById(profilRecup.getIdTypeDeProfil()).get(0);
                                langue2 = (Langues) getLangueById(profilRecup.getIdTypeDeProfil()).get(1);
                                langue3 = (Langues) getLangueById(profilRecup.getIdTypeDeProfil()).get(2);
                            }
                            if (getLangueById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                                langues = (Langues) getLangueById(profilRecup.getIdTypeDeProfil()).get(0);
                            }
                            if (getLangueById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                                langues = (Langues) getLangueById(profilRecup.getIdTypeDeProfil()).get(0);
                                langue2 = (Langues) getLangueById(profilRecup.getIdTypeDeProfil()).get(1);
                            }//******************************************************************************
                            //*************reintialisation des langages
                            if (getLangagesById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                                langages = (Langages) getLangagesById(profilRecup.getIdTypeDeProfil()).get(0);
                                langages2 = (Langages) getLangagesById(profilRecup.getIdTypeDeProfil()).get(1);
                                langages3 = (Langages) getLangagesById(profilRecup.getIdTypeDeProfil()).get(2);
                            }
                            if (getLangagesById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                                langages = (Langages) getLangagesById(profilRecup.getIdTypeDeProfil()).get(0);
                            }
                            if (getLangagesById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                                langages = (Langages) getLangagesById(profilRecup.getIdTypeDeProfil()).get(0);
                                langages2 = (Langages) getLangagesById(profilRecup.getIdTypeDeProfil()).get(1);
                            }//******************************************************************************
                            //*************reintialisation des outils
                            if (getOutilsById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                                outils = (Outils) getOutilsById(profilRecup.getIdTypeDeProfil()).get(0);
                                outils2 = (Outils) getOutilsById(profilRecup.getIdTypeDeProfil()).get(1);
                                outils3 = (Outils) getOutilsById(profilRecup.getIdTypeDeProfil()).get(2);
                            }
                            if (getOutilsById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                                outils = (Outils) getOutilsById(profilRecup.getIdTypeDeProfil()).get(0);
                            }
                            if (getOutilsById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                                outils = (Outils) getOutilsById(profilRecup.getIdTypeDeProfil()).get(0);
                                outils2 = (Outils) getOutilsById(profilRecup.getIdTypeDeProfil()).get(1);
                            }//******************************************************************************
                            //*************reintialisation des methodologies
                            if (getMethodologieById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                                methodologie = (Methodologie) getMethodologieById(profilRecup.getIdTypeDeProfil()).get(0);
                                methodologie2 = (Methodologie) getMethodologieById(profilRecup.getIdTypeDeProfil()).get(1);
                                methodologie3 = (Methodologie) getMethodologieById(profilRecup.getIdTypeDeProfil()).get(2);
                            }
                            if (getMethodologieById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                                methodologie = (Methodologie) getMethodologieById(profilRecup.getIdTypeDeProfil()).get(0);
                            }
                            if (getMethodologieById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                                methodologie = (Methodologie) getMethodologieById(profilRecup.getIdTypeDeProfil()).get(0);
                                methodologie2 = (Methodologie) getMethodologieById(profilRecup.getIdTypeDeProfil()).get(1);
                            }//******************************************************************************
                            //*************reintialisation des modelisations
                            if (getModelisationById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                                modelisation = (Modelisation) getModelisationById(profilRecup.getIdTypeDeProfil()).get(0);
                                modelisation2 = (Modelisation) getModelisationById(profilRecup.getIdTypeDeProfil()).get(1);
                                modelisation3 = (Modelisation) getModelisationById(profilRecup.getIdTypeDeProfil()).get(2);
                            }
                            if (getModelisationById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                                modelisation = (Modelisation) getModelisationById(profilRecup.getIdTypeDeProfil()).get(0);
                            }
                            if (getModelisationById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                                modelisation = (Modelisation) getModelisationById(profilRecup.getIdTypeDeProfil()).get(0);
                                modelisation2 = (Modelisation) getModelisationById(profilRecup.getIdTypeDeProfil()).get(1);
                            }//******************************************************************************
                            //*************reintialisation des bdd
                            if (getBddById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                                bdd = (Bdd) getBddById(profilRecup.getIdTypeDeProfil()).get(0);
                                bdd2 = (Bdd) getBddById(profilRecup.getIdTypeDeProfil()).get(1);
                                bdd3 = (Bdd) getBddById(profilRecup.getIdTypeDeProfil()).get(2);
                            }
                            if (getBddById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                                bdd = (Bdd) getBddById(profilRecup.getIdTypeDeProfil()).get(0);
                            }
                            if (getBddById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                                bdd = (Bdd) getBddById(profilRecup.getIdTypeDeProfil()).get(0);
                                bdd2 = (Bdd) getBddById(profilRecup.getIdTypeDeProfil()).get(1);
                            }//******************************************************************************
                            //*************reintialisation des experiences professionnelles
                            if (getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                                experiencesprofessionnelles = (Experiencesprofessionnelles) getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(0);
                                experiencesprofessionnelles2 = (Experiencesprofessionnelles) getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(1);
                                experiencesprofessionnelles3 = (Experiencesprofessionnelles) getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(2);
                            }
                            if (getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                                experiencesprofessionnelles = (Experiencesprofessionnelles) getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(0);
                            }
                            if (getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                                experiencesprofessionnelles = (Experiencesprofessionnelles) getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(0);
                                experiencesprofessionnelles2 = (Experiencesprofessionnelles) getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(1);
                            }//******************************************************************************
                            //*************reintialisation des os
                            if (getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                                materielssystemesexploitation = (Materielssystemesexploitation) getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(0);
                                materielssystemesexploitation2 = (Materielssystemesexploitation) getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(1);
                                materielssystemesexploitation3 = (Materielssystemesexploitation) getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(2);
                            }
                            if (getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                                materielssystemesexploitation = (Materielssystemesexploitation) getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(0);
                            }
                            if (getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                                materielssystemesexploitation = (Materielssystemesexploitation) getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(0);
                                materielssystemesexploitation2 = (Materielssystemesexploitation) getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(1);
                            }//******************************************************************************
                        }
                        //On construit un cv et on l'ajoute dans la liste
                        Cv unCv = new Cv(users, materielssystemesexploitation, materielssystemesexploitation2, materielssystemesexploitation3, experiencesprofessionnelles2, experiencesprofessionnelles, experiencesprofessionnelles3, bdd2, bdd, bdd3, modelisation2, modelisation, modelisation3, methodologie2, methodologie, methodologie3, outils2, outils, outils3, langages2, langages, langages3, langue2, langues, langue3, formation2, formation, formation3, profilRecup);
                        lesCvTrouves.add(unCv);
                    }
                }
            }
        }
        return lesCvTrouves;
    }

    @Override
    public void addsuiviEntretien(Suivreentrtien se) {
      try {
            getSessionFactory().getCurrentSession().save(se);
        } catch (HibernateException th) {
            System.err.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
            System.err.println("Erreurs lors de l'execution de la méthode addsuiviEntretien(): \n");
            th.printStackTrace();
            System.err.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
    }
}
