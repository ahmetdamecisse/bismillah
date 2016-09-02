
import com.gdc.model.*;
import com.gdc.services.Imetier;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Ahmet CISSE
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class testsDaoMetier {

    @Autowired
    private Imetier metier;

//    @Test
//    public void FormationsDuCandidatQuiSestConnecte() {
//        Users userRecup = metier.getUtilisateurByLoginAndPassporw("baba2", "baba2");
//        if (userRecup != null) {
//            Profil profilRecup = metier.getProfilByUsername(userRecup.getUsername());
//            if (profilRecup != null) {
//                if (metier.getFormationById(profilRecup.getIdTypeDeProfil()).size() >= 3) {
//                    System.err.println(metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(0));
//                    System.err.println(metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(1));
//                    System.err.println(metier.getFormationById(profilRecup.getIdTypeDeProfil()).get(2));
//                    System.out.println("****Formations du candidat Quia pour login: baba2 et pour mot de passe :baba2***");
//                }
//            }
//        }
//    }
//
//    @Test
//    public void tousLesUtilisateurs() {
//
//        // affichage les utilisateurs
//        List<Users> users = metier.getALLutilisateur();
//        System.out.println("*********************La liste des utilisateurs******************************");
//        System.out.println(users);
//        System.out.println("*********************Fin de liste des utilisateurs******************************");
//    }
}
