/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Commande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tofi
 */
@Local
public interface GestionPaiementlLocal {

    public List<Commande> findCommandeByStatusPret();
    
}
