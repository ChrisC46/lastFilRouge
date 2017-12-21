/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Commande;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tofi
 */
@Stateless
public class GestionPaiement implements GestionPaiementlLocal {
    
    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;

    public List<Commande> findCommandeByStatusPret (){
        Query qr = em.createNamedQuery("entites.Commande.findCommandeByStatusPret");
        List<Commande> lCom = qr.getResultList();
        return lCom;
    }
    
    
}
