/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.LigneDeCommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi312
 */
@Local
public interface GestionCuisineLocal {

    public List<LigneDeCommande> listeProduitsCuisine();
    
}
