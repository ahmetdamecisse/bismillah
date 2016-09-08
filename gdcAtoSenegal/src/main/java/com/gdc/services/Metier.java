/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.services;

import com.gdc.dao.Idao;
import com.gdc.model.*;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author a618092
 */
@Service
@Transactional(readOnly = true)
public class Metier implements Imetier {

    private Idao daojpa;

    public Idao getDaojpa() {
        return daojpa;
    }

    public void setDaojpa(Idao daojpa) {
        this.daojpa = daojpa;
    }

    @Override
    public List getALLutilisateur() {
        return getDaojpa().getALLutilisateur();
    }

    @Override
    public Users getUtilisateurById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addUtilisateur(Users u) {
        getDaojpa().addUtilisateur(u);
    }

    @Override
    public void removeUtilisateur(Integer idUtili) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUtilisateur(Users u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getUtilisateurByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getUtilisateurByLoginAndPassporw(String login, String password) {
        return getDaojpa().getUtilisateurByLoginAndPassporw(login, password);
    }

    @Override
    public List getAllAdministrateur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addAdministrateur(Administrateur a) {
        getDaojpa().addAdministrateur(a);
    }

    @Override
    public void removeAdministrateur(Integer idAdminAsupp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAdministrateur(Users modifiant, Integer idAdminAmodifier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrateur getAdministrateurById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAdministrateurByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllCandidat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addCandidat(Candidat c) {
        getDaojpa().addCandidat(c);
    }

    @Override
    public void removeCandidat(Candidat c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCandidat(Users utilisateurModifinat, Integer idCandidatAmodifier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Candidat getCandidatById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getCandidatByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getCandidatByFullName(String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getCandidatByCompetencesPrincipales(String cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getCandidatByCompetencesFontionnelles(String cf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getCandidatByNombreAnneesExperience(int nbreAnneeExp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllRecruteur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addRecruteur(Recruteur r) {
        getDaojpa().addRecruteur(r);
    }

    @Override
    public void removeRecruteur(Integer idRecruteurAsupp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRecruteur(Users recruteurRemplaçant, Integer idRecruteurRemplace) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Recruteur getRecruteurById(String username) {
        return getDaojpa().getRecruteurById(username);
    }

    @Override
    public List getRecruteurByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllBdd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addBdd(Bdd bdd) {
        getDaojpa().addBdd(bdd);
    }

    @Override
    public void removeBdd(Bdd bdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBdd(Bdd bdd, Integer idUtilsateurbddModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getBddById(Integer id) {
        return getDaojpa().getBddById(id);
    }

    @Override
    public List getBddByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllEntretien() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addEntretien(Entretien e) {
        getDaojpa().addEntretien(e);
    }

    @Override
    public void removeEntretien(Entretien e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEntretien(Entretien e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entretien getEntretienById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getEntretienByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllExperiencesprofessionnelles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addExperiencesprofessionnelles(Experiencesprofessionnelles e) {
        getDaojpa().addExperiencesprofessionnelles(e);
    }

    @Override
    public void removeExperiencesprofessionnelles(Experiencesprofessionnelles e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateExperiencesprofessionnelles(Experiencesprofessionnelles e, Integer idUtilsateurEpModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getExperiencesprofessionnellesById(Integer id) {
        return getDaojpa().getExperiencesprofessionnellesById(id);
    }

    @Override
    public List getExperiencesprofessionnellesByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllFichedeposte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addFichedeposte(Fichedeposte f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeFichedeposte(Fichedeposte f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFichedeposte(Fichedeposte f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fichedeposte getFichedeposteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getFichedeposteByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllFichedetest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addFichedetest(Fichedetest f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeFichedetest(Fichedetest f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFichedetest(Fichedetest f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fichedetest getFichedetestById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getFichedetestByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllFormation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addFormation(Formation f) {
        getDaojpa().addFormation(f);
    }

    @Override
    public void removeFormation(Formation f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFormation(Formation f, Integer idUtilsateurFormModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getFormationById(Integer id) {
        return getDaojpa().getFormationById(id);
    }

    @Override
    public List getFormationByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllLangages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addLangages(Langages l) {
        getDaojpa().addLangages(l);
    }

    @Override
    public void removeLangages(Langages l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLangages(Langages l, Integer idUtilsateurLangageModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getLangagesById(Integer id) {
        return getDaojpa().getLangagesById(id);
    }

    @Override
    public List getLangagesByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllLangue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addLangues(Langues l) {
        getDaojpa().addLangues(l);
    }

    @Override
    public void removeLangues(Langues l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLangues(Langues l, Integer idUtilsateurLangueModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Langues getLanguesById(Integer id) {
        return getDaojpa().getLanguesById(id);
    }

    @Override
    public List getLanguesByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllListequestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getListequestionByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllListereponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getListereponseByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllMaterielssystemesexploitation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addMaterielssystemesexploitation(Materielssystemesexploitation m) {
        getDaojpa().addMaterielssystemesexploitation(m);
    }

    @Override
    public void removeMaterielssystemesexploitation(Materielssystemesexploitation m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMaterielssystemesexploitation(Materielssystemesexploitation m, Integer idUtilsateurMSModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getMaterielssystemesexploitationById(Integer id) {
        return getDaojpa().getMaterielssystemesexploitationById(id);
    }

    @Override
    public List getMaterielssystemesexploitationByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllMethodologie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addMethodologie(Methodologie m) {
        getDaojpa().addMethodologie(m);
    }

    @Override
    public void removeMethodologie(Methodologie m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMethodologie(Methodologie m, Integer idUtilsateurMethoModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getMethodologieById(Integer id) {
        return getDaojpa().getMethodologieById(id);
    }

    @Override
    public List getMethodologieByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllModelisation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addModelisation(Modelisation m) {
        getDaojpa().addModelisation(m);
    }

    @Override
    public void removeModelisation(Modelisation m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateModelisation(Modelisation m, Integer idUtilsateurModelModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getModelisationById(Integer id) {
        return getDaojpa().getModelisationById(id);
    }

    @Override
    public List getModelisationByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllNotification() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNotification(Notification n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeNotification(Notification n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateNotification(Notification n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Notification getNotificationById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getNotificationByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllOutils() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addOutils(Outils o) {
        getDaojpa().addOutils(o);
    }

    @Override
    public void removeOutils(Outils o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOutils(Outils o, Integer idUtilsateurOutilModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getOutilsById(Integer id) {
        return getDaojpa().getOutilsById(id);
    }

    @Override
    public List getOutilsByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllProil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addProfil(Profil p) {
        getDaojpa().addProfil(p);
    }

    @Override
    public void removeProfil(Profil p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProfil(Profil p, Integer idCandidatAmodifProfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profil getProfilById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getProfilByCompetence(String x, String y, String z) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getProfilByCompetenceFonctionnelle(String x, String y, String z) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllProfilgl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = false)
    @Override
    public void addProfilgl(Profilgl p) {
        getDaojpa().addProfilgl(p);
    }

    @Override
    public void removeProfilgl(Profilgl p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProfilgl(Integer idUtilsateurProfilglModif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Profilgl getProfilglById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getProfilglByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllQuestionsFi(Fichedetest f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAllAnswersFi(Fichedetest f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String loginControl(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ceUsernameEstIlUtiliseDeja(String username) {
        return daojpa.ceUsernameEstIlUtiliseDeja(username);
    }

    @Transactional(readOnly = false)
    @Override
    public void addUserRole(UserRoles userRole) {
        getDaojpa().addUserRole(userRole);
    }

    @Override
    public Profil getProfilByUsername(String username) {
        return getDaojpa().getProfilByUsername(username);
    }

    @Override
    public List getLangueById(Integer id) {
        return getDaojpa().getLangueById(id);
    }

    @Override
    public List getAllOffresemploi() {
        return getDaojpa().getAllOffresemploi();
    }

    @Transactional(readOnly = false)
    @Override
    public void addOffresemploi(Offresemploi o) {
        getDaojpa().addOffresemploi(o);
        }

        @Override
        public void removeOffresemploi
        (Offresemploi o
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void updateOffresemploi
        (Offresemploi o
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Notification getOffresemploiById
        (Integer id
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List getOffresemploiByName
        (String nom
        
            ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
