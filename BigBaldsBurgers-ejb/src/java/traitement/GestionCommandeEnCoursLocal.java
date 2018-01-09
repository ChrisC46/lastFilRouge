
package traitement; 
 
import entites.Commande; 
import java.util.HashMap; 
 import javax.ejb.Local;


@Local 
public interface GestionCommandeEnCoursLocal { 
     
     public boolean checkIfCommandeEncours(String numeroTable); 
      
     public Commande selectCommandeForPlace(String numeroTable); 
      
     public void nouvelleCommande(String numeroTable, Commande cmde); 
      
     public HashMap<String, Commande> selectAllCommandesEnCours(); 
      
      public void libererPlace(Commande c); 
} 
