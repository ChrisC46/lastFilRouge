/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Commande;
import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author cdi317
 */
@Local
public interface GestionCommandeEnCoursLocal {
    
     public boolean checkIfCommandeEncours(String numeroTable);
     
     public Commande selectCommandeForPlace(String numeroTable);
     
     public void nouvelleCommande(String numeroTable, Commande cmde);
     
     public HashMap<String, Commande> selectAllCommandesEnCours();
     
      public void libererPlace(Commande c);
}
