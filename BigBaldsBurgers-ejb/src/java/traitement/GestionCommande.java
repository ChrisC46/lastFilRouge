/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Commande;
import entites.Emplacement;
import entites.LigneDeCommande;
import entites.Produit;
import entites.Specification;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import outils.CustomedException;

/**
 *
 * @author Tofi
 */
@Stateful
public class GestionCommande implements GestionCommandeLocal {
    
    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;

  

    private HashMap<String, LigneDeCommande> panier;

    @PostConstruct
    public void init() {
        panier = new HashMap<>();
    }

    @Override
    public void ajouter(String reference) {
        if (reference != null) {
            reference = reference.trim();
        }

        if (panier.containsKey(reference)) {
            LigneDeCommande lp = panier.get(reference);

            int newQte = lp.getQteCommande() + 1;
            if (newQte > lp.getProduit().getQteCommande()) {
                newQte = lp.getProduit().getQteCommande();
            }
            lp.setQteCommande(newQte);
        } else {
            Produit p = em.find(Produit.class, reference);
            try {
                LigneDeCommande nlp = new LigneDeCommande(p);
                panier.put(reference, nlp);
            } catch (IllegalArgumentException ex) {

            }
        }
    }

    @Override
    public void dec(String reference) {
        LigneDeCommande lp = panier.get(reference);
        if (lp.getQteCommande() > 1) {
            reference = reference.trim();

            int newQte = lp.getQteCommande() - 1;

            lp.setQteCommande(newQte);
        }
    }

    @Override
    public void del(String reference) {
        this.panier.remove(reference);
    }

    @Override
    public Collection<LigneDeCommande> getListe() {
        return panier.values();
    }

    @Override
    public int getNombreProduit() {
        int somme = 0;
        for (LigneDeCommande lp : panier.values()) {
            somme += lp.getQteCommande();
        }
        return somme;
    }
    
    @Override
    public List<Commande> selectAllCommandesValideesFromDB() {
        Query qr = em.createNamedQuery("persistence.entites.Commande.selectCommandesByStatus");
        qr.setParameter("paramCodeEtat", "");
        List<Commande> lc = qr.getResultList();
        for (Commande c : lc) {
            em.refresh(c);
        }
        return lc;
    }
    
    @Override
    public Commande selectCommandeForPlace(String numeroTable) {
        GestionCommandeEnCoursLocal commandesEnCours = lookupCommandesEnCoursLocal();
        Commande cmde = commandesEnCours.selectCommandeForPlace(numeroTable);
        return cmde;
    }
    
    
    @Override
    public void instancierCommande(String numeroTable) {
        GestionCommandeEnCoursLocal commandesEnCours = lookupCommandesEnCoursLocal();
        if (!commandesEnCours.checkIfCommandeEncours(numeroTable)) {

            GestionEmplacementLocal gestionPlaces = lookupGestionEmplacementLocal();
            try {
                Emplacement place = gestionPlaces.selectionEmplacement(numeroTable);
                gestionPlaces.setEtatOccupe(place);
                Commande cmde = new Commande(place);
                commandesEnCours.nouvelleCommande(numeroTable, cmde);
            } catch (CustomedException ex) {
                System.out.println("ECHEC installation client dans gestion Commande  message : " + ex);
            }
        }
    }
    
    
    
    public void ajouterProduit(String numeroTable, String idProduit, List<Long> specification) throws CustomedException {
        Commande c = selectCommandeForPlace(numeroTable);
        LigneDeCommande lc = new LigneDeCommande();
        c.getLigneDeCo().add(lc);
        Produit p = lookupGestionCategorieCarteLocal().getProdById(idProduit);
        lc.setProduit(p);
        lc.setPrixLigneDeCo(p.getPrix());
        lc.getProduit().setTva(p.getTva());     
        if (!specification.isEmpty()) {
            for (Long spe : specification) {
                Specification sp = lookupGestionCategorieCarteLocal().getSpecificationByID(spe);
                lc.getCommentSpec().add(sp);
            }
        }
        lc.setCommande(c);
    }
    
     private GestionCategorieCarteLocal lookupGestionCategorieCarteLocal() {
        try {
            Context c = new InitialContext();
            return (GestionCategorieCarteLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionCatalogue!metiers.GestionCatalogueLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
     private GestionEmplacementLocal lookupGestionEmplacementLocal() {
        try {
            Context c = new InitialContext();
            return (GestionEmplacementLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionEmplacementLocal!traitement.GestionEmplacementLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private GestionCommandeEnCoursLocal lookupCommandesEnCoursLocal() {
        try {
            Context c = new InitialContext();
            return (GestionCommandeEnCoursLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionCommandeEnCours!traitement.GestionCommandeEnCoursLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    

}
