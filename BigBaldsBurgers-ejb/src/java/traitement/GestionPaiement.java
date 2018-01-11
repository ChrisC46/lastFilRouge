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
import utils.PriceCalculation;

/**
 *
 * @author Tofi
 */
@Stateless
public class GestionPaiement implements GestionPaiementLocal {

    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;

    @Override
    public List<Commande> findCommandeByStatusPret(String status) {
        Query qr = em.createNamedQuery("entites.Commande.findCommandeByStatusPret");
        qr.setParameter("paramStatus", status);
        List<Commande> lCom = qr.getResultList();
        //System.out.println("gestionPaiement requete num commande :"+qr);
        return lCom;
    }

    @Override
    public List<LigneDeCommande> detailCommandeByEmplacement(String numEmplacement) {
        Query qr = em.createNamedQuery("entites.LigneDeCommande.detailCommandeByEmplacement");
        qr.setParameter("paramNumEmplacement", numEmplacement);
        List<LigneDeCommande> detailCom = qr.getResultList();

        //System.out.println("gestionPaiement requete num commande :"+qr);
        return detailCom;
    }

    @Override
    public Float getTvaLigneDeCo(LigneDeCommande ligneDeCo) {
        Float tvaLigneDeCo = 0.00f;
        if (ligneDeCo.getFormule() != null) {
            tvaLigneDeCo = ligneDeCo.getFormule().getTva().getTaux();
//            Query qr = em.createNamedQuery("entites.Tva.findTVA");
//            qr.setParameter("paramNom", "tva formule");
//            tvaLigneDeCo = (Float) qr.getSingleResult();
        } else {
            if ("Biere".equals(ligneDeCo.getProduit().getProprietes().toString())) {

                Query qr = em.createNamedQuery("entites.Tva.findTVA");
                qr.setParameter("paramNom", "tva alcool");
                tvaLigneDeCo = (Float) qr.getSingleResult();
            } else {
                Query qr = em.createNamedQuery("entites.Tva.findTVA");
                qr.setParameter("paramNom", "tva carte");
                tvaLigneDeCo = (Float) qr.getSingleResult();
            }
        }
        return tvaLigneDeCo;
    }

    @Override
    public Float getPrixTTCFormule(LigneDeCommande ligneDeCo) {
        Float prixTTC = ligneDeCo.getQteCommande() * ligneDeCo.getFormule().getPrixTTC();
        Float newPrix = PriceCalculation.getRoundedPrice(prixTTC);
        return newPrix;
    }

    @Override
    public Float getPrixTTCProduit(LigneDeCommande ligneDeCo) {
        Float prixTTC = ligneDeCo.getQteCommande() * ligneDeCo.getProduit().getPrixTTC();
        Float newPrix = PriceCalculation.getRoundedPrice(prixTTC);
        return newPrix;
    }

    @Override
    public Float getPrixTotalHT(List<LigneDeCommande> ligneDeCo) {
        //List<Float> prixListHT = new ArrayList<>();
        Float totalHT = 0.00f;
        for (LigneDeCommande list : ligneDeCo) {
            totalHT += list.getPrixLigneDeCo();

        }
        Float newPrix = PriceCalculation.getRoundedPrice(totalHT);
        return newPrix;
    }

    @Override
    public Float getPrixTotalTTC(List<LigneDeCommande> ligneDeCo) {
        System.out.println("on est dans GP getprixtotalttc");
        Float totalTTC = 0f;
        for (LigneDeCommande list : ligneDeCo) {
            totalTTC += (list.getQteCommande() * (list.getFormule().getPrixTTC()))+ (list.getQteCommande() * (list.getProduit().getPrixTTC()));

        }
        System.out.println("detail list prixtotalTTC" + totalTTC);
//      Float newPrix = PriceCalculation.getRoundedPrice(totalTTC);
//        System.out.println("prix total TTC"+newPrix);
        return totalTTC;
    }

}
