/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Commande;
import entites.LigneDeCommande;
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
public class GestionPaiement implements GestionPaiementLocal {
    
    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Commande> findCommandeByStatusPret (String status){
        Query qr = em.createNamedQuery("entites.Commande.findCommandeByStatusPret");
        qr.setParameter("paramStatus", status);
        List<Commande> lCom = qr.getResultList();
        //System.out.println("gestionPaiement requete num commande :"+qr);
        return lCom;
    }
    
    @Override
    public List<LigneDeCommande> detailCommandeByEmplacement(String numEmplacement){
        Query qr = em.createNamedQuery("entites.LigneDeCommande.detailCommandeByEmplacement");
        qr.setParameter("paramNumEmplacement", numEmplacement);
        List<LigneDeCommande> detailCom = qr.getResultList();
        System.out.println("gestionPaiement requete num commande :"+qr);
        return detailCom;
    }
    
    
    
}
