/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.dao;

import com.gdc.exceptions.pfcgdcexception;
import com.gdc.model.*;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addEntretien(Entretien e) {
        try {
            getSessionFactory().getCurrentSession().saveOrUpdate(e);
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
              p=(Profil) list.get(0);
              return  p;
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

    public String loginControl(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
