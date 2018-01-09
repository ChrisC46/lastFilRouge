/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.LigneDeCommande;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Tofi
 */
@Local
public interface GestionCommandeLocal {

    public Collection<LigneDeCommande> getListe();

    public int getNombreProduit();

    public void ajouter(String reference);
    
    public void del(String reference);

    public void dec(String reference);
}
