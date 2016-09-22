/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.*;
import com.gdc.services.Imetier;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author a618092
 */
@ManagedBean(name = "redigerCV")
@SessionScoped
public class RedigerCV implements Serializable {

    //Spring User Service is injected...
    @ManagedProperty(value = "#{Metier}")
    Imetier metier;

    public Imetier getMetier() {
        return metier;
    }

    public void setMetier(Imetier metier) {
        this.metier = metier;
    }
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * Creates a new instance of RedigerCV
     */
    public RedigerCV() {
    }

    private Users user = new Users();
    private Candidat candidat = new Candidat();
    private Profilgl profilgl = new Profilgl();
    private Profil profil = new Profil();
    private Materielssystemesexploitation materielssystemesexploitation = new Materielssystemesexploitation();
    private Materielssystemesexploitation materielssystemesexploitation2 = new Materielssystemesexploitation();
    private Materielssystemesexploitation materielssystemesexploitation3 = new Materielssystemesexploitation();
    private MaterielssystemesexploitationPK materielssystemesexploitationpk = new MaterielssystemesexploitationPK();
    private MaterielssystemesexploitationPK materielssystemesexploitationpk2 = new MaterielssystemesexploitationPK();
    private MaterielssystemesexploitationPK materielssystemesexploitationpk3 = new MaterielssystemesexploitationPK();
    private Formation formation = new Formation();
    private Formation formation2 = new Formation();
    private Formation formation3 = new Formation();
    private FormationPK formationpk = new FormationPK();
    private FormationPK formationpk2 = new FormationPK();
    private FormationPK formationpk3 = new FormationPK();
    private Outils outils = new Outils();
    private Outils outils2 = new Outils();
    private Outils outils3 = new Outils();
    private OutilsPK outilspk = new OutilsPK();
    private OutilsPK outilspk2 = new OutilsPK();
    private OutilsPK outilspk3 = new OutilsPK();
    private Experiencesprofessionnelles experiencesprofessionnelles = new Experiencesprofessionnelles();
    private Experiencesprofessionnelles experiencesprofessionnelles2 = new Experiencesprofessionnelles();
    private Experiencesprofessionnelles experiencesprofessionnelles3 = new Experiencesprofessionnelles();
    private ExperiencesprofessionnellesPK experiencesprofessionnellespk = new ExperiencesprofessionnellesPK();
    private ExperiencesprofessionnellesPK experiencesprofessionnellespk2 = new ExperiencesprofessionnellesPK();
    private ExperiencesprofessionnellesPK experiencesprofessionnellespk3 = new ExperiencesprofessionnellesPK();
    private Langages langage = new Langages();
    private Langages langage2 = new Langages();
    private Langages langage3 = new Langages();
    private LangagesPK langagepk = new LangagesPK();
    private LangagesPK langagepk2 = new LangagesPK();
    private LangagesPK langagepk3 = new LangagesPK();
    private Methodologie methodologie = new Methodologie();
    private Methodologie methodologie2 = new Methodologie();
    private Methodologie methodologie3 = new Methodologie();
    private MethodologiePK methodologiepk = new MethodologiePK();
    private MethodologiePK methodologiepk2 = new MethodologiePK();
    private MethodologiePK methodologiepk3 = new MethodologiePK();
    private Modelisation modelisation = new Modelisation();
    private Modelisation modelisation2 = new Modelisation();
    private Modelisation modelisation3 = new Modelisation();
    private ModelisationPK modelisationPK = new ModelisationPK();
    private ModelisationPK modelisationPK2 = new ModelisationPK();
    private ModelisationPK modelisationPK3 = new ModelisationPK();
    private Bdd bdd = new Bdd();
    private Bdd bdd2 = new Bdd();
    private Bdd bdd3 = new Bdd();
    private BddPK bddPK = new BddPK();
    private BddPK bddPK2 = new BddPK();
    private BddPK bddPK3 = new BddPK();
    private Langues langues = new Langues();
    private Langues langues2 = new Langues();
    private Langues langues3 = new Langues();
    private LanguesPK languesPK = new LanguesPK();
    private LanguesPK languesPK2 = new LanguesPK();
    private LanguesPK languesPK3 = new LanguesPK();
    private String loginConnexion;
    private String passwordConnexion;

    public MaterielssystemesexploitationPK getMaterielssystemesexploitationpk() {
        return materielssystemesexploitationpk;
    }

    public void setMaterielssystemesexploitationpk(MaterielssystemesexploitationPK materielssystemesexploitationpk) {
        this.materielssystemesexploitationpk = materielssystemesexploitationpk;
    }

    public MaterielssystemesexploitationPK getMaterielssystemesexploitationpk2() {
        return materielssystemesexploitationpk2;
    }

    public void setMaterielssystemesexploitationpk2(MaterielssystemesexploitationPK materielssystemesexploitationpk2) {
        this.materielssystemesexploitationpk2 = materielssystemesexploitationpk2;
    }

    public MaterielssystemesexploitationPK getMaterielssystemesexploitationpk3() {
        return materielssystemesexploitationpk3;
    }

    public void setMaterielssystemesexploitationpk3(MaterielssystemesexploitationPK materielssystemesexploitationpk3) {
        this.materielssystemesexploitationpk3 = materielssystemesexploitationpk3;
    }

    public FormationPK getFormationpk() {
        return formationpk;
    }

    public void setFormationpk(FormationPK formationpk) {
        this.formationpk = formationpk;
    }

    public FormationPK getFormationpk2() {
        return formationpk2;
    }

    public void setFormationpk2(FormationPK formationpk2) {
        this.formationpk2 = formationpk2;
    }

    public FormationPK getFormationpk3() {
        return formationpk3;
    }

    public void setFormationpk3(FormationPK formationpk3) {
        this.formationpk3 = formationpk3;
    }

    public OutilsPK getOutilspk() {
        return outilspk;
    }

    public void setOutilspk(OutilsPK outilspk) {
        this.outilspk = outilspk;
    }

    public OutilsPK getOutilspk2() {
        return outilspk2;
    }

    public void setOutilspk2(OutilsPK outilspk2) {
        this.outilspk2 = outilspk2;
    }

    public OutilsPK getOutilspk3() {
        return outilspk3;
    }

    public void setOutilspk3(OutilsPK outilspk3) {
        this.outilspk3 = outilspk3;
    }

    public ExperiencesprofessionnellesPK getExperiencesprofessionnellespk() {
        return experiencesprofessionnellespk;
    }

    public void setExperiencesprofessionnellespk(ExperiencesprofessionnellesPK experiencesprofessionnellespk) {
        this.experiencesprofessionnellespk = experiencesprofessionnellespk;
    }

    public ExperiencesprofessionnellesPK getExperiencesprofessionnellespk2() {
        return experiencesprofessionnellespk2;
    }

    public void setExperiencesprofessionnellespk2(ExperiencesprofessionnellesPK experiencesprofessionnellespk2) {
        this.experiencesprofessionnellespk2 = experiencesprofessionnellespk2;
    }

    public ExperiencesprofessionnellesPK getExperiencesprofessionnellespk3() {
        return experiencesprofessionnellespk3;
    }

    public void setExperiencesprofessionnellespk3(ExperiencesprofessionnellesPK experiencesprofessionnellespk3) {
        this.experiencesprofessionnellespk3 = experiencesprofessionnellespk3;
    }

    public LangagesPK getLangagepk() {
        return langagepk;
    }

    public void setLangagepk(LangagesPK langagepk) {
        this.langagepk = langagepk;
    }

    public LangagesPK getLangagepk2() {
        return langagepk2;
    }

    public void setLangagepk2(LangagesPK langagepk2) {
        this.langagepk2 = langagepk2;
    }

    public LangagesPK getLangagepk3() {
        return langagepk3;
    }

    public void setLangagepk3(LangagesPK langagepk3) {
        this.langagepk3 = langagepk3;
    }

    public MethodologiePK getMethodologiepk() {
        return methodologiepk;
    }

    public void setMethodologiepk(MethodologiePK methodologiepk) {
        this.methodologiepk = methodologiepk;
    }

    public MethodologiePK getMethodologiepk2() {
        return methodologiepk2;
    }

    public void setMethodologiepk2(MethodologiePK methodologiepk2) {
        this.methodologiepk2 = methodologiepk2;
    }

    public MethodologiePK getMethodologiepk3() {
        return methodologiepk3;
    }

    public void setMethodologiepk3(MethodologiePK methodologiepk3) {
        this.methodologiepk3 = methodologiepk3;
    }

    public ModelisationPK getModelisationPK() {
        return modelisationPK;
    }

    public void setModelisationPK(ModelisationPK modelisationPK) {
        this.modelisationPK = modelisationPK;
    }

    public ModelisationPK getModelisationPK2() {
        return modelisationPK2;
    }

    public void setModelisationPK2(ModelisationPK modelisationPK2) {
        this.modelisationPK2 = modelisationPK2;
    }

    public ModelisationPK getModelisationPK3() {
        return modelisationPK3;
    }

    public void setModelisationPK3(ModelisationPK modelisationPK3) {
        this.modelisationPK3 = modelisationPK3;
    }

    public BddPK getBddPK() {
        return bddPK;
    }

    public void setBddPK(BddPK bddPK) {
        this.bddPK = bddPK;
    }

    public BddPK getBddPK2() {
        return bddPK2;
    }

    public void setBddPK2(BddPK bddPK2) {
        this.bddPK2 = bddPK2;
    }

    public BddPK getBddPK3() {
        return bddPK3;
    }

    public void setBddPK3(BddPK bddPK3) {
        this.bddPK3 = bddPK3;
    }

    public LanguesPK getLanguesPK() {
        return languesPK;
    }

    public void setLanguesPK(LanguesPK languesPK) {
        this.languesPK = languesPK;
    }

    public LanguesPK getLanguesPK2() {
        return languesPK2;
    }

    public void setLanguesPK2(LanguesPK languesPK2) {
        this.languesPK2 = languesPK2;
    }

    public LanguesPK getLanguesPK3() {
        return languesPK3;
    }

    public void setLanguesPK3(LanguesPK languesPK3) {
        this.languesPK3 = languesPK3;
    }

    public String getLoginConnexion() {
        return loginConnexion;
    }

    public void setLoginConnexion(String loginConnexion) {
        this.loginConnexion = loginConnexion;
    }

    public String getPasswordConnexion() {
        return passwordConnexion;
    }

    public void setPasswordConnexion(String passwordConnexion) {
        this.passwordConnexion = passwordConnexion;
    }

    public Materielssystemesexploitation getMaterielssystemesexploitation2() {
        return materielssystemesexploitation2;
    }

    public void setMaterielssystemesexploitation2(Materielssystemesexploitation materielssystemesexploitation2) {
        this.materielssystemesexploitation2 = materielssystemesexploitation2;
    }

    public Materielssystemesexploitation getMaterielssystemesexploitation3() {
        return materielssystemesexploitation3;
    }

    public void setMaterielssystemesexploitation3(Materielssystemesexploitation materielssystemesexploitation3) {
        this.materielssystemesexploitation3 = materielssystemesexploitation3;
    }

    public Outils getOutils2() {
        return outils2;
    }

    public void setOutils2(Outils outils2) {
        this.outils2 = outils2;
    }

    public Outils getOutils3() {
        return outils3;
    }

    public void setOutils3(Outils outils3) {
        this.outils3 = outils3;
    }

    public Experiencesprofessionnelles getExperiencesprofessionnelles2() {
        return experiencesprofessionnelles2;
    }

    public void setExperiencesprofessionnelles2(Experiencesprofessionnelles experiencesprofessionnelles2) {
        this.experiencesprofessionnelles2 = experiencesprofessionnelles2;
    }

    public Experiencesprofessionnelles getExperiencesprofessionnelles3() {
        return experiencesprofessionnelles3;
    }

    public void setExperiencesprofessionnelles3(Experiencesprofessionnelles experiencesprofessionnelles3) {
        this.experiencesprofessionnelles3 = experiencesprofessionnelles3;
    }

    public Langages getLangage2() {
        return langage2;
    }

    public void setLangage2(Langages langage2) {
        this.langage2 = langage2;
    }

    public Langages getLangage3() {
        return langage3;
    }

    public void setLangage3(Langages langage3) {
        this.langage3 = langage3;
    }

    public Methodologie getMethodologie2() {
        return methodologie2;
    }

    public void setMethodologie2(Methodologie methodologie2) {
        this.methodologie2 = methodologie2;
    }

    public Methodologie getMethodologie3() {
        return methodologie3;
    }

    public void setMethodologie3(Methodologie methodologie3) {
        this.methodologie3 = methodologie3;
    }

    public Modelisation getModelisation2() {
        return modelisation2;
    }

    public void setModelisation2(Modelisation modelisation2) {
        this.modelisation2 = modelisation2;
    }

    public Modelisation getModelisation3() {
        return modelisation3;
    }

    public void setModelisation3(Modelisation modelisation3) {
        this.modelisation3 = modelisation3;
    }

    public Bdd getBdd2() {
        return bdd2;
    }

    public void setBdd2(Bdd bdd2) {
        this.bdd2 = bdd2;
    }

    public Bdd getBdd3() {
        return bdd3;
    }

    public void setBdd3(Bdd bdd3) {
        this.bdd3 = bdd3;
    }

    public Langues getLangues2() {
        return langues2;
    }

    public void setLangues2(Langues langues2) {
        this.langues2 = langues2;
    }

    public Langues getLangues3() {
        return langues3;
    }

    public void setLangues3(Langues langues3) {
        this.langues3 = langues3;
    }

    public Formation getFormation2() {
        return formation2;
    }

    public void setFormation2(Formation formation2) {
        this.formation2 = formation2;
    }

    public Formation getFormation3() {
        return formation3;
    }

    public void setFormation3(Formation formation3) {
        this.formation3 = formation3;
    }

    private boolean skip;

    public Profilgl getProfilgl() {
        return profilgl;
    }

    public void setProfilgl(Profilgl profilgl) {
        this.profilgl = profilgl;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Materielssystemesexploitation getMaterielssystemesexploitation() {
        return materielssystemesexploitation;
    }

    public void setMaterielssystemesexploitation(Materielssystemesexploitation materielssystemesexploitation) {
        this.materielssystemesexploitation = materielssystemesexploitation;
    }

    public Outils getOutils() {
        return outils;
    }

    public void setOutils(Outils outils) {
        this.outils = outils;
    }

    public Experiencesprofessionnelles getExperiencesprofessionnelles() {
        return experiencesprofessionnelles;
    }

    public void setExperiencesprofessionnelles(Experiencesprofessionnelles experiencesprofessionnelles) {
        this.experiencesprofessionnelles = experiencesprofessionnelles;
    }

    public Langages getLangage() {
        return langage;
    }

    public void setLangage(Langages langage) {
        this.langage = langage;
    }

    public Methodologie getMethodologie() {
        return methodologie;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setMethodologie(Methodologie methodologie) {
        this.methodologie = methodologie;
    }

    public Modelisation getModelisation() {
        return modelisation;
    }

    public void setModelisation(Modelisation modelisation) {
        this.modelisation = modelisation;
    }

    public Bdd getBdd() {
        return bdd;
    }

    public void setBdd(Bdd bdd) {
        this.bdd = bdd;
    }

    public Langues getLangues() {
        return langues;
    }

    public void setLangues(Langues langues) {
        this.langues = langues;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public void enregistrer() {
        //----------------Le candidat a un profil--------------
        metier.addProfil(profil); // à ne pas upprimer car ça permet d'avoir l'id du profil du candidat à crée
        //----------------le profil est de type GL-------------
        profilgl.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        profilgl.setProfil(profil);//pour régler les conflits de relation pouvant subvenir entre profil et profil gl oneTOone
        metier.addProfilgl(profilgl);
        //----------------un candidat ayant un profil de type GL peut être crée maintenant-------------
        candidat.setUsername(user.getUsername());
        candidat.setIdTypeDeProfil(profil);
        candidat.setUsers(user);
        metier.addCandidat(candidat);
        //----------------Diplôme 1 du candidat-------------
        formationpk.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (formationpk.getNomDiplome() == null) {
            formationpk.setNomDiplome(user.getUsername() + " le diplôme est important à préciser");
        }
        formation.setFormationPK(formationpk);
        formation.setProfilgl(profilgl);
        metier.addFormation(formation);
        //----------------Diplôme 2 du candidat-------------
        formationpk2.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (formationpk2.getNomDiplome() == null) {
            formationpk2.setNomDiplome(user.getUsername() + " le diplôme est important à préciser");
        }
        formation2.setFormationPK(formationpk2);
        formation2.setProfilgl(profilgl);
        metier.addFormation(formation2);
        //----------------Diplôme 3 du candidat-------------
        formationpk3.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (formationpk3.getNomDiplome() == null) {
            formationpk3.setNomDiplome(user.getUsername() + " le diplôme est important à préciser");
        }
        formation3.setFormationPK(formationpk3);
        formation3.setProfilgl(profilgl);
        metier.addFormation(formation3);
        //******************Fin Persistence du parcours académique
        //langue parlé 1
        languesPK.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (languesPK.getNom() == null) {
            languesPK.setNom(user.getUsername() + "la langue est importante");
        }
        langues.setLanguesPK(languesPK);
        langues.setProfilgl(profilgl);
        metier.addLangues(langues);
        //langue parlée 2
        languesPK2.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (languesPK2.getNom() == null) {
            languesPK2.setNom(user.getUsername() + "la langue est importante");
        }
        langues2.setLanguesPK(languesPK2);
        langues2.setProfilgl(profilgl);
        metier.addLangues(langues2);
        //langue parlée 3
        languesPK3.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (languesPK3.getNom() == null) {
            languesPK3.setNom(user.getUsername() + "la langue est importante");
        }
        langues3.setLanguesPK(languesPK3);
        langues3.setProfilgl(profilgl);
        metier.addLangues(langues3);
        //langage 1
        langagepk.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (langagepk.getDomaine() == null) {
            langagepk.setDomaine(user.getUsername() + "la langue est importante");
        }
        langage.setLangagesPK(langagepk);
        langage.setProfilgl(profilgl);
        metier.addLangages(langage);
        //langage 2
        langagepk2.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (langagepk2.getDomaine() == null) {
            langagepk2.setDomaine(user.getUsername() + "la langue est importante");
        }
        langage2.setLangagesPK(langagepk2);
        langage2.setProfilgl(profilgl);
        metier.addLangages(langage2);
        //langage 3
        langagepk3.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (langagepk3.getDomaine() == null) {
            langagepk3.setDomaine(user.getUsername() + "la langue est importante");
        }
        langage3.setLangagesPK(langagepk3);
        langage3.setProfilgl(profilgl);
        metier.addLangages(langage3);
        //outil 1
        outilspk.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (outilspk.getDomaine() == null) {
            outilspk.setDomaine(user.getUsername() + "la langue est importante");
        }
        outils.setOutilsPK(outilspk);
        outils.setProfilgl(profilgl);
        metier.addOutils(outils);
        //outil 2
        outilspk2.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (outilspk2.getDomaine() == null) {
            outilspk2.setDomaine(user.getUsername() + "la langue est importante");
        }
        outils2.setOutilsPK(outilspk2);
        outils2.setProfilgl(profilgl);
        metier.addOutils(outils2);
        //outil 3
        outilspk3.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (outilspk3.getDomaine() == null) {
            outilspk3.setDomaine(user.getUsername() + "la langue est importante");
        }
        outils3.setOutilsPK(outilspk3);
        outils3.setProfilgl(profilgl);
        metier.addOutils(outils3);
        //méthodologie 1
        methodologiepk.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (methodologiepk.getDomaine() == null) {
            methodologiepk.setDomaine(user.getUsername() + "la langue est importante");
        }
        methodologie.setMethodologiePK(methodologiepk);
        methodologie.setProfilgl(profilgl);
        metier.addMethodologie(methodologie);
        //méthodologie 2
        methodologiepk2.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (methodologiepk2.getDomaine() == null) {
            methodologiepk2.setDomaine(user.getUsername() + "la langue est importante");
        }
        methodologie2.setMethodologiePK(methodologiepk2);
        methodologie2.setProfilgl(profilgl);
        metier.addMethodologie(methodologie2);
        //méthodologie 3
        methodologiepk3.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (methodologiepk3.getDomaine() == null) {
            methodologiepk3.setDomaine(user.getUsername() + "la langue est importante");
        }
        methodologie3.setMethodologiePK(methodologiepk3);
        methodologie3.setProfilgl(profilgl);
        metier.addMethodologie(methodologie3);
        //modelisation 1
        modelisationPK.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (modelisationPK.getDomaine() == null) {
            modelisationPK.setDomaine(user.getUsername() + "la langue est importante");
        }
        modelisation.setModelisationPK(modelisationPK);
        modelisation.setProfilgl(profilgl);
        metier.addModelisation(modelisation);
        //modelisation 2
        modelisationPK2.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (modelisationPK2.getDomaine() == null) {
            modelisationPK2.setDomaine(user.getUsername() + "la langue est importante");
        }
        modelisation2.setModelisationPK(modelisationPK2);
        modelisation2.setProfilgl(profilgl);
        metier.addModelisation(modelisation2);
        //modelisation 3
        modelisationPK3.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (modelisationPK3.getDomaine() == null) {
            modelisationPK3.setDomaine(user.getUsername() + "la langue est importante");
        }
        modelisation3.setModelisationPK(modelisationPK3);
        modelisation3.setProfilgl(profilgl);
        metier.addModelisation(modelisation3);
        //  base de données 1
        bddPK.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (bddPK.getDomaine() == null) {
            bddPK.setDomaine(user.getUsername() + "la langue est importante");
        }
        bdd.setBddPK(bddPK);
        bdd.setProfilgl(profilgl);
        metier.addBdd(bdd);
        //  base de données 2
        bddPK2.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (bddPK2.getDomaine() == null) {
            bddPK2.setDomaine(user.getUsername() + "la langue est importante");
        }
        bdd2.setBddPK(bddPK2);
        bdd2.setProfilgl(profilgl);
        metier.addBdd(bdd2);
        //  base de données 3
        bddPK3.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (bddPK3.getDomaine() == null) {
            bddPK3.setDomaine(user.getUsername() + "la langue est importante");
        }
        bdd3.setBddPK(bddPK3);
        bdd3.setProfilgl(profilgl);
        metier.addBdd(bdd3);
        //  materiels et os 1
        materielssystemesexploitationpk.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (materielssystemesexploitationpk.getDomaine() == null) {
            materielssystemesexploitationpk.setDomaine(user.getUsername() + "la langue est importante");
        }
        materielssystemesexploitation.setMaterielssystemesexploitationPK(materielssystemesexploitationpk);
        materielssystemesexploitation.setProfilgl(profilgl);
        metier.addMaterielssystemesexploitation(materielssystemesexploitation);
        //  materiels et os 2
        materielssystemesexploitationpk2.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (materielssystemesexploitationpk2.getDomaine() == null) {
            materielssystemesexploitationpk2.setDomaine(user.getUsername() + "la langue est importante");
        }
        materielssystemesexploitation2.setMaterielssystemesexploitationPK(materielssystemesexploitationpk2);
        materielssystemesexploitation2.setProfilgl(profilgl);
        metier.addMaterielssystemesexploitation(materielssystemesexploitation2);
        //  materiels et os 3
        materielssystemesexploitationpk3.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (materielssystemesexploitationpk3.getDomaine() == null) {
            materielssystemesexploitationpk3.setDomaine(user.getUsername() + "la langue est importante");
        }
        materielssystemesexploitation3.setMaterielssystemesexploitationPK(materielssystemesexploitationpk3);
        materielssystemesexploitation3.setProfilgl(profilgl);
        metier.addMaterielssystemesexploitation(materielssystemesexploitation3);
        // experience profess 1
        experiencesprofessionnellespk.setIdTypeDeProfil(profil.getIdTypeDeProfil());
        if (experiencesprofessionnellespk.getDatededebut() == null) {
            experiencesprofessionnellespk.setDatededebut(new Date());
        }
        if (experiencesprofessionnellespk.getDatefin() == null) {
            experiencesprofessionnellespk.setDatefin(new Date());
        }
        experiencesprofessionnelles.setExperiencesprofessionnellesPK(experiencesprofessionnellespk);
        experiencesprofessionnelles.setProfilgl(profilgl);
        metier.addExperiencesprofessionnelles(experiencesprofessionnelles);
    }

    public String annuler() {
        return "candidats.AtoS?faces-redirect=true";
    }

    public String controlConnexion() {
        String roleDeCeluiQuisestConneste = null;
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(loginConnexion, passwordConnexion);
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
            //***********************Après la connexion, on reinitialise le formulaire
            Users userRecup = metier.getUtilisateurByLoginAndPassporw(loginConnexion, passwordConnexion);
            roleDeCeluiQuisestConneste = metier.quiSestConnecte(loginConnexion);
            if (userRecup != null) {
                //*************reintialisation du user
                setUser(userRecup);
                Profil profilRecup = metier.getProfilByUsername(userRecup.getUsername());
                if (profilRecup != null) {
                    //*************reintialisation du profil
                    setProfil(profilRecup);
                    //*************reintialisation des formations
                    if (metier.getFormationById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        setFormation((Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(0));
                        setFormationpk(getFormation().getFormationPK());
                        setFormation2((Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(1));
                        setFormationpk2(getFormation2().getFormationPK());
                        setFormation3((Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(2));
                        setFormationpk3(getFormation3().getFormationPK());
                    }
                    if (metier.getFormationById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        setFormation((Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(0));
                        setFormationpk(getFormation().getFormationPK());
                    }
                    if (metier.getFormationById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        setFormation((Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(0));
                        setFormationpk(getFormation().getFormationPK());
                        setFormation2((Formation) metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(1));
                        setFormationpk3(getFormation2().getFormationPK());
                    }
                    //*************reintialisation des langues
                    if (metier.getLangueById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        setLangues((Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(0));
                        setLanguesPK(getLangues().getLanguesPK());
                        setLangues2((Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(1));
                        setLanguesPK2(getLangues2().getLanguesPK());
                        setLangues3((Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(2));
                        setLanguesPK3(getLangues3().getLanguesPK());
                    }
                    if (metier.getLangueById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        setLangues((Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(0));
                        setLanguesPK(getLangues().getLanguesPK());
                    }
                    if (metier.getLangueById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        setLangues((Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(0));
                        setLanguesPK(getLangues().getLanguesPK());
                        setLangues2((Langues) metier.getLangueById(profilRecup.getIdTypeDeProfil()).get(1));
                        setLanguesPK2(getLangues2().getLanguesPK());
                    }//******************************************************************************
                    //*************reintialisation des langages
                    if (metier.getLangagesById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        setLangage((Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(0));
                        setLangagepk(getLangage().getLangagesPK());
                        setLangage2((Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(1));
                        setLangagepk2(getLangage2().getLangagesPK());
                        setLangage3((Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(2));
                        setLangagepk3(getLangage3().getLangagesPK());
                    }
                    if (metier.getLangagesById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        setLangage((Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(0));
                        setLangagepk(getLangage().getLangagesPK());
                    }
                    if (metier.getLangagesById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        setLangage((Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(0));
                        setLangagepk(getLangage().getLangagesPK());
                        setLangage2((Langages) metier.getLangagesById(profilRecup.getIdTypeDeProfil()).get(1));
                        setLangagepk2(getLangage2().getLangagesPK());
                    }//******************************************************************************
                    //*************reintialisation des outils
                    if (metier.getOutilsById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        setOutils((Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(0));
                        setOutilspk(getOutils().getOutilsPK());
                        setOutils2((Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(1));
                        setOutilspk2(getOutils2().getOutilsPK());
                        setOutils3((Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(2));
                        setOutilspk3(getOutils3().getOutilsPK());
                    }
                    if (metier.getOutilsById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        setOutils((Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(0));
                        setOutilspk(getOutils().getOutilsPK());
                    }
                    if (metier.getOutilsById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        setOutils((Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(0));
                        setOutilspk(getOutils().getOutilsPK());
                        setOutils2((Outils) metier.getOutilsById(profilRecup.getIdTypeDeProfil()).get(1));
                        setOutilspk2(getOutils2().getOutilsPK());
                    }//******************************************************************************
                    //*************reintialisation des methodologies
                    if (metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        setMethodologie((Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(0));
                        setMethodologiepk(getMethodologie().getMethodologiePK());
                        setMethodologie2((Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(1));
                        setMethodologiepk2(getMethodologie2().getMethodologiePK());
                        setMethodologie3((Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(2));
                        setMethodologiepk3(getMethodologie3().getMethodologiePK());
                    }
                    if (metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        setMethodologie((Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(0));
                        setMethodologiepk(getMethodologie().getMethodologiePK());
                    }
                    if (metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        setMethodologie((Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(0));
                        setMethodologiepk(getMethodologie().getMethodologiePK());
                        setMethodologie2((Methodologie) metier.getMethodologieById(profilRecup.getIdTypeDeProfil()).get(1));
                        setMethodologiepk2(getMethodologie2().getMethodologiePK());
                    }//******************************************************************************
                    //*************reintialisation des modelisations
                    if (metier.getModelisationById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        setModelisation((Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(0));
                        setModelisationPK(getModelisation().getModelisationPK());
                        setModelisation2((Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(1));
                        setModelisationPK2(getModelisation2().getModelisationPK());
                        setModelisation3((Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(2));
                        setModelisationPK3(getModelisation3().getModelisationPK());
                    }
                    if (metier.getModelisationById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        setModelisation((Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(0));
                        setModelisationPK(getModelisation().getModelisationPK());
                    }
                    if (metier.getModelisationById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        setModelisation((Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(0));
                        setModelisationPK(getModelisation().getModelisationPK());
                        setModelisation2((Modelisation) metier.getModelisationById(profilRecup.getIdTypeDeProfil()).get(1));
                        setModelisationPK(getModelisation2().getModelisationPK());
                    }//******************************************************************************
                    //*************reintialisation des bdd
                    if (metier.getBddById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        setBdd((Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(0));
                        setBddPK(getBdd().getBddPK());
                        setBdd2((Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(1));
                        setBddPK2(getBdd2().getBddPK());
                        setBdd3((Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(2));
                        setBddPK3(getBdd3().getBddPK());
                    }
                    if (metier.getBddById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        setBdd((Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(0));
                        setBddPK(getBdd().getBddPK());
                    }
                    if (metier.getBddById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        setBdd((Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(0));
                        setBddPK(getBdd().getBddPK());
                        setBdd2((Bdd) metier.getBddById(profilRecup.getIdTypeDeProfil()).get(1));
                        setBddPK2(getBdd2().getBddPK());
                    }//******************************************************************************
                    //*************reintialisation des experiences professionnelles
                    if (metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        setExperiencesprofessionnelles((Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(0));
                        setExperiencesprofessionnellespk(getExperiencesprofessionnelles().getExperiencesprofessionnellesPK());
                        setExperiencesprofessionnelles2((Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(1));
                        setExperiencesprofessionnellespk2(getExperiencesprofessionnelles2().getExperiencesprofessionnellesPK());
                        setExperiencesprofessionnelles3((Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(2));
                        setExperiencesprofessionnellespk3(getExperiencesprofessionnelles3().getExperiencesprofessionnellesPK());
                    }
                    if (metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        setExperiencesprofessionnelles((Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(0));
                        setExperiencesprofessionnellespk(getExperiencesprofessionnelles().getExperiencesprofessionnellesPK());
                    }
                    if (metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        setExperiencesprofessionnelles((Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(0));
                        setExperiencesprofessionnellespk(getExperiencesprofessionnelles().getExperiencesprofessionnellesPK());
                        setExperiencesprofessionnelles2((Experiencesprofessionnelles) metier.getExperiencesprofessionnellesById(profilRecup.getIdTypeDeProfil()).get(1));
                        setExperiencesprofessionnellespk2(getExperiencesprofessionnelles2().getExperiencesprofessionnellesPK());
                    }//******************************************************************************
                    //*************reintialisation des os
                    if (metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
                        setMaterielssystemesexploitation((Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(0));
                        setMaterielssystemesexploitationpk(getMaterielssystemesexploitation().getMaterielssystemesexploitationPK());
                        setMaterielssystemesexploitation2((Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(1));
                        setMaterielssystemesexploitationpk2(getMaterielssystemesexploitation2().getMaterielssystemesexploitationPK());
                        setMaterielssystemesexploitation3((Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(2));
                        setMaterielssystemesexploitationpk3(getMaterielssystemesexploitation3().getMaterielssystemesexploitationPK());
                    }
                    if (metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).size() == 1) {
                        setMaterielssystemesexploitation((Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(0));
                        setMaterielssystemesexploitationpk(getMaterielssystemesexploitation().getMaterielssystemesexploitationPK());
                    }
                    if (metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).size() == 2) {
                        setMaterielssystemesexploitation((Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(0));
                        setMaterielssystemesexploitationpk(getMaterielssystemesexploitation().getMaterielssystemesexploitationPK());
                        setMaterielssystemesexploitation2((Materielssystemesexploitation) metier.getMaterielssystemesexploitationById(profilRecup.getIdTypeDeProfil()).get(1));
                        setMaterielssystemesexploitationpk2(getMaterielssystemesexploitation2().getMaterielssystemesexploitationPK());
                    }//******************************************************************************
                }
            }

        } catch (AuthenticationException e) {
            e.printStackTrace();
            FacesMessage msgerreur = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authentification ratée.", "nom d'utilisateur ou mot de passe incorrect!");
            RequestContext.getCurrentInstance().showMessageInDialog(msgerreur);
        }
        if (roleDeCeluiQuisestConneste.equalsIgnoreCase("ROLE_CANDIDAT")) {
            return "candidats.AtoS?faces-redirect=true";
        } else if (roleDeCeluiQuisestConneste.equalsIgnoreCase("ROLE_RECRUTEUR")) {
            return "employeur.AtoS?faces-redirect=true";
        } else {
            return "admin.AtoS?faces-redirect=true";
        }
    }

    public String controlDeConnexion() {
        SecurityContextHolder.clearContext();
        return "index.AtoS?faces-redirect=true";
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }
}
