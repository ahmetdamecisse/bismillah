
import com.gdc.model.*;
import com.gdc.services.Imetier;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author a618092
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class redigercvTest {
    
    @Autowired
    private Imetier metier;
       
    //à completer ça ne marche pas pour l'instant
//    @Test
//    public void ajoutUtilisateurCandidatProfilGl3() {
//        Users user1 = new Users("username2", "DIOP", "kDiop", "KM", "diop@gmail.com", "771047524", "diop48", "IGL", new Date(1990, 11, 20), Short.parseShort("1"), 1);
//        Profil profil = new Profil(null);
//        Profilgl profilgl1 = new Profilgl();
//        Candidat candidat = new Candidat();
//        Formation formation1 = new Formation();
//        Formation formation2 = new Formation();
//        Formation formation3 = new Formation();
//        Bdd bdd1 = new Bdd();
//        Bdd bdd2 = new Bdd();
//        Bdd bdd3 = new Bdd();
//    }

//    @Test
//    public void ajoutUtilisateurCandidatProfilGl2() {
//
//        Users user1 = new Users("username1", "DIOP", "kDiop", "KM", "diop@gmail.com", "771047524", "diop48", "IGL", new Date(1990, 11, 20), Short.parseShort("1"), 1);
//        dao.addUtilisateur(user1);
//
//        Profil profil = new Profil(null);
//        dao.addProfil(profil); // à ne pas upprimer car ça permet d'avoir l'id du profil du candidat à crée
//        System.out.println("******************************************************************************");
//        System.out.println("Apres persisyence de profil " + profil);
//
//        Profilgl profilgl1 = new Profilgl(profil.getIdTypeDeProfil());
//        System.out.println("******************************************************************************");
//        System.out.println("Avant persisyence de profil gl " + profilgl1);
//        profilgl1.setProfil(profil);//pour régler les conflits de relation pouvant subvenir entre profil et profil gl oneTOone
//        dao.addProfilgl(profilgl1);//persistence du profil gl
//
//        Candidat candidat = new Candidat(user1.getUsername());
//        candidat.setIdTypeDeProfil(profil);//pour régler les conflits de relation pouvant subvenir
//        candidat.setUsers(user1);//pour régler les conflits de relation pouvant subvenir
//        dao.addCandidat(candidat);
//
//        Formation formation1 = new Formation(profilgl1.getIdTypeDeProfil());
//        formation1.setProfilgl(profilgl1);
//        formation1.setNomDiplome("Licence");
//        dao.addFormation(formation1);
//
//        Formation formation2 = new Formation(profilgl1.getIdTypeDeProfil());
//        formation2.setProfilgl(profilgl1);
//        formation2.setNomDiplome("Master");
//        dao.addFormation(formation2);
//
//        Bdd bdd = new Bdd(profilgl1.getIdTypeDeProfil());//la base de donneees à persister
//        bdd.setProfilgl(profilgl1);//pour régler les conflits de relation pouvant subvenir entre bdd et profil gl oneTOone
//        bdd.setDomaine("SQL server");
//        dao.addBdd(bdd);//persistence de la bdd (commentaire valide pour tous le reste des composants de profilGL)
//
//        Bdd bdd1 = new Bdd(profilgl1.getIdTypeDeProfil());//la base de donneees à persister
//        bdd1.setProfilgl(profilgl1);//pour régler les conflits de relation pouvant subvenir entre bdd et profil gl oneTOone
//        bdd1.setDomaine("Oracle");
//        dao.addBdd(bdd1);//persistence de la bdd (commentaire valide pour tous le reste des composants de profilGL)
//
//        Materielssystemesexploitation mse1 = new Materielssystemesexploitation(profilgl1.getIdTypeDeProfil());
//        mse1.setProfilgl(profilgl1);
//        mse1.setDomaine("Windows");
//        dao.addMaterielssystemesexploitation(mse1);
//
//        Materielssystemesexploitation mse2 = new Materielssystemesexploitation(profilgl1.getIdTypeDeProfil());
//        mse2.setProfilgl(profilgl1);
//        mse2.setDomaine("Linux");
//        dao.addMaterielssystemesexploitation(mse2);
//
//        Methodologie metho = new Methodologie(profilgl1.getIdTypeDeProfil());
//        metho.setProfilgl(profilgl1);
//        metho.setDomaine("metho1");
//        dao.addMethodologie(metho);
//
//        Methodologie metho1 = new Methodologie(profilgl1.getIdTypeDeProfil());
//        metho1.setProfilgl(profilgl1);
//        metho1.setDomaine("metho2");
//        dao.addMethodologie(metho1);
//
//        Modelisation model = new Modelisation(profilgl1.getIdTypeDeProfil());
//        model.setProfilgl(profilgl1);
//        model.setDomaine("Model1");
//        dao.addModelisation(model);
//
//        Modelisation model2 = new Modelisation(profilgl1.getIdTypeDeProfil());
//        model2.setProfilgl(profilgl1);
//        model2.setDomaine("Model2");
//        dao.addModelisation(model2);
//
//        Outils outil = new Outils(profilgl1.getIdTypeDeProfil());
//        outil.setProfilgl(profilgl1);
//        outil.setDomaine("outil 1");
//        dao.addOutils(outil);
//
//        Outils outil2 = new Outils(profilgl1.getIdTypeDeProfil());
//        outil2.setProfilgl(profilgl1);
//        outil2.setDomaine("outil 2");
//        dao.addOutils(outil2);
//
//        Langages lang = new Langages(profilgl1.getIdTypeDeProfil());
//        lang.setProfilgl(profilgl1);
//        lang.setDomaine("java");
//        dao.addLangages(lang);
//
//        Langages lang2 = new Langages(profilgl1.getIdTypeDeProfil());
//        lang2.setProfilgl(profilgl1);
//        lang2.setDomaine("XML");
//        dao.addLangages(lang2);
//
//        Langues langue = new Langues(profilgl1.getIdTypeDeProfil());
//        langue.setProfilgl(profilgl1);
//        langue.setNom("fr");
//        dao.addLangues(langue);
//
//        Langues langue2 = new Langues(profilgl1.getIdTypeDeProfil());
//        langue2.setProfilgl(profilgl1);
//        langue2.setNom("En");
//        dao.addLangues(langue2);
//    }
       @Test
     public void tousLesUtilisateurs() {
         
     // affichage les utilisateurs
     List<Users> users = metier.getALLutilisateur();
        
     System.out.println("******************************************************************************");
     System.out.println("******************************************************************************");
     System.out.println("******************************************************************************");
        
     System.out.println("*********************Lies des utilisateurs******************************");
         
     System.out.println(users);
     }                    
}
