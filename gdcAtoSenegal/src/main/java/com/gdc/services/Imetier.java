/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.services;

import com.gdc.model.*;
import java.util.List;

/**
 *
 * @author a618092
 */
public interface Imetier {

    //Utilisateur
    public List getALLutilisateur();

    public Users getUtilisateurById(Integer id);

    public void addUtilisateur(Users u);

    public void addUserRole(UserRoles userRole);
    
      public void updateUserRole(UserRoles userRole);

    public void removeUtilisateur(Integer idUtili);

    public void updateUtilisateur(Users u);

    public List getUtilisateurByName(String nom);

    public Users getUtilisateurByLoginAndPassporw(String login, String password);

    //Administrateur
    public List getAllAdministrateur();

    public void addAdministrateur(Administrateur a);

    public void removeAdministrateur(Integer idAdminAsupp);

    public void updateAdministrateur(Users modifiant, Integer idAdminAmodifier);

    public Administrateur getAdministrateurById(Integer id);

    public List getAdministrateurByName(String nom);

    //Candidat
    public List getAllCandidat();

    public void addCandidat(Candidat c);

    public void removeCandidat(Candidat c);

    public void updateCandidat(Users utilisateurModifinat, Integer idCandidatAmodifier);

    public Candidat getCandidatById(String username);

    public List getCandidatByName(String nom);

    public List getCandidatByFullName(String nom, String prenom);

    public List getCandidatByCompetencesPrincipales(String cp);

    public List getCandidatByCompetencesFontionnelles(String cf);

    public List getCandidatByNombreAnneesExperience(int nbreAnneeExp);

    //Recruteur
    public List getAllRecruteur();

    public void addRecruteur(Recruteur r);

    public void removeRecruteur(Integer idRecruteurAsupp);

    public void updateRecruteur(Users recruteurRemplaçant, Integer idRecruteurRemplace);

    public Recruteur getRecruteurById(String username);

    public List getRecruteurByName(String nom);

    //BDD
    public List getAllBdd();

    public void addBdd(Bdd bdd);

    public void removeBdd(Bdd bdd);

    public void updateBdd(Bdd bdd, Integer idUtilsateurbddModif);

    public List getBddById(Integer id);

    public List getBddByName(String nom);

    //Entretien
    public List getAllEntretien();

    public void addEntretien(Entretien e);

    public void removeEntretien(Entretien e);

    public void updateEntretien(Entretien e);

    public Entretien getEntretienById(Integer id);

    public List getEntretienByName(String nom);
    
    public void addsuiviEntretien(Suivreentrtien se);

    //Experiencesprofessionnelles
    public List getAllExperiencesprofessionnelles();

    public void addExperiencesprofessionnelles(Experiencesprofessionnelles e);

    public void removeExperiencesprofessionnelles(Experiencesprofessionnelles e);

    public void updateExperiencesprofessionnelles(Experiencesprofessionnelles e, Integer idUtilsateurEpModif);

    public List getExperiencesprofessionnellesById(Integer id);

    public List getExperiencesprofessionnellesByName(String nom);

    //Fichedeposte
    public List getAllFichedeposte();

    public void addFichedeposte(Fichedeposte f);

    public void removeFichedeposte(Fichedeposte f);

    public void updateFichedeposte(Fichedeposte f);

    public Fichedeposte getFichedeposteById(Integer id);

    public List getFichedeposteByName(String nom);

    //Fichedetest
    public List getAllFichedetest();

    public void addFichedetest(Fichedetest f);

    public void removeFichedetest(Fichedetest f);

    public void updateFichedetest(Fichedetest f);

    public Fichedetest getFichedetestById(Integer id);

    public List getFichedetestByName(String nom);

    //Formation
    public List getAllFormation();

    public void addFormation(Formation f);

    public void removeFormation(Formation f);

    public void updateFormation(Formation f, Integer idUtilsateurFormModif);

    public List getFormationById(Integer id);

    public List getFormationByName(String nom);

    //Langages
    public List getAllLangages();

    public void addLangages(Langages l);

    public void removeLangages(Langages l);

    public void updateLangages(Langages l, Integer idUtilsateurLangageModif);

    public List getLangagesById(Integer id);

    public List getLangagesByName(String nom);

    //Langues
    public List getAllLangue();

    public void addLangues(Langues l);

    public void removeLangues(Langues l);

    public void updateLangues(Langues l, Integer idUtilsateurLangueModif);

    public Langues getLanguesById(Integer id);

    public List getLanguesByName(String nom);

    public List getLangueById(Integer id);

    //Listedequestion
    public List getAllListequestion();

    public List getListequestionByName(String nom);

    //Liste de réponses
    public List getAllListereponse();

    public List getListereponseByName(String nom);

    //Materiels et OS
    public List getAllMaterielssystemesexploitation();

    public void addMaterielssystemesexploitation(Materielssystemesexploitation m);

    public void removeMaterielssystemesexploitation(Materielssystemesexploitation m);

    public void updateMaterielssystemesexploitation(Materielssystemesexploitation m, Integer idUtilsateurMSModif);

    public List getMaterielssystemesexploitationById(Integer id);

    public List getMaterielssystemesexploitationByName(String nom);

    //Methodologie
    public List getAllMethodologie();

    public void addMethodologie(Methodologie m);

    public void removeMethodologie(Methodologie m);

    public void updateMethodologie(Methodologie m, Integer idUtilsateurMethoModif);

    public List getMethodologieById(Integer id);

    public List getMethodologieByName(String nom);

    //Modelisation
    public List getAllModelisation();

    public void addModelisation(Modelisation m);

    public void removeModelisation(Modelisation m);

    public void updateModelisation(Modelisation m, Integer idUtilsateurModelModif);

    public List getModelisationById(Integer id);

    public List getModelisationByName(String nom);

    //Notification
    public List getAllNotification();

    public void addNotification(Notification n);

    public void removeNotification(Notification n);

    public void updateNotification(Notification n);

    public Notification getNotificationById(Integer id);

    public List getNotificationByName(String nom);

    //Outils
    public List getAllOutils();

    public void addOutils(Outils o);

    public void removeOutils(Outils o);

    public void updateOutils(Outils o, Integer idUtilsateurOutilModif);

    public List getOutilsById(Integer id);

    public List getOutilsByName(String nom);

    //Profils
    public List getAllProil();

    public void addProfil(Profil p);

    public void removeProfil(Profil p);

    public void updateProfil(Profil p, Integer idCandidatAmodifProfil);

    public Profil getProfilById(Integer id);

    public Profil getProfilByUsername(String username);

    public List getProfilByCompetence(String x, String y, String z);

    public List getProfilByCompetenceFonctionnelle(String x, String y, String z);

    //Profilgl
    public List getAllProfilgl();

    public void addProfilgl(Profilgl p);

    public void removeProfilgl(Profilgl p);

    public void updateProfilgl(Integer idUtilsateurProfilglModif);

    public Profilgl getProfilglById(Integer id);

    public List getProfilglByName(String nom);

    //Les classes faisant référence à des tables associatives ne sont pas manipulées directement. 
    //La manipulation se fait à partir des classes correspondantes aux tables formant la table associative.
    //les différentes réponses possibles pour une question
    //Les questions d'une fiche de test donnée
    public List getAllQuestionsFi(Fichedetest f);

    //Correction d'une fiche de test donnée
    public List getAllAnswersFi(Fichedetest f);

    //login
    public String quiSestConnecte(String login);

    //test d'existence de username
    public boolean ceUsernameEstIlUtiliseDeja(String username);

    //Offres d'emploi
    public List getAllOffresemploi();

    public void addOffresemploi(Offresemploi o);

    public void removeOffresemploi(Offresemploi o);

    public void updateOffresemploi(Offresemploi o);

    public Notification getOffresemploiById(Integer id);

    public List getOffresemploiByName(String nom);

    //Charger tous les cv
    public List chargertousLesCV(List listeDesUtilisateurs, List listeDesCandidatsDeLaBase);

}
