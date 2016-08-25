/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gdc.managed.bean;

import com.gdc.model.*;
import com.gdc.services.Imetier;
import java.io.Serializable;
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
        //----------------MAJ du user--------------
        profil = new Profil(null);
        metier.addProfil(profil); // à ne pas upprimer car ça permet d'avoir l'id du profil du candidat à crée
        profilgl = new Profilgl(profil.getIdTypeDeProfil());
        profilgl.setProfil(profil);//pour régler les conflits de relation pouvant subvenir entre profil et profil gl oneTOone
        metier.addProfilgl(profilgl);
        candidat = new Candidat(user.getUsername());
        candidat.setIdTypeDeProfil(profil);
        candidat.setUsers(user);
        metier.addCandidat(candidat);
        //******************Persistence du parcours académique
    }

    public void anuuler() {
        //----------------Les insertions se feront dans cette partie-----------------------------------------------------------------
        FacesMessage msg = new FacesMessage("Successful", "Bonjour :" + user.getPrenom() + " " + "votre cv a été crée avec succès");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public String controlConnexion() {

        try {
            Authentication request = new UsernamePasswordAuthenticationToken(loginConnexion, passwordConnexion);
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);

            Users userRecup = metier.getUtilisateurByLoginAndPassporw(loginConnexion, passwordConnexion);

            if (userRecup != null) {
                setUser(userRecup);
            }

        } catch (AuthenticationException e) {
            e.printStackTrace();
            FacesMessage msgerreur = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authentification ratée.", "nom d'utilisateur ou mot de passe incorrect!");
            RequestContext.getCurrentInstance().showMessageInDialog(msgerreur);
        }
        return "candidats.AtoS?faces-redirect=true";
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
