/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.CategorieFormule;
import entites.Formule;
import entites.Produit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi317
 */
@Stateless
public class GestionCategorieCarte implements GestionCategorieCarteLocal {
    
    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;


    @Override
    public List<CategorieFormule> getAllCat() {
        Query qr = em.createNamedQuery("entites.CategorieFormule.AllCat");
        List<CategorieFormule> allCat = qr.getResultList();
        return allCat;
    }
    
    @Override
    public List<Formule> getAllFormule() {
        Query qr = em.createNamedQuery("entites.Formule.AllFormule");
        List <Formule> allFormule = qr.getResultList();
        return allFormule;        
    }
    
    
    @Override
    public Produit getProdById(String id) {
        Query qr = em.createNamedQuery("entites.Produit.getById");
        qr.setParameter("paramNom", id);
        Produit prod = (Produit) qr.getSingleResult();
        return prod;
    }
    
    @Override
    public Formule getFormuleById(String id) {
        Query qr = em.createNamedQuery("entites.Formule.FormuleById");
        qr.setParameter("paramNom", id);
        Formule formule = (Formule) qr.getSingleResult();
        return formule;
    }
    
    
    @Override
    public List<Produit> getProduitByProP(String nomPropriete){
        Query qr = em.createNamedQuery("entites.Produit.getByProp");
        qr.setParameter("paramNom", nomPropriete);
        List<Produit> produits = qr.getResultList();
        //Tris Produit Uniques
        HashSet<Produit> uniqueValues = new HashSet(produits);
        produits.clear();
        for(Produit prod :uniqueValues){
            produits.add(prod);
        }
        System.out.println("requete : " + qr.toString() );
        return produits;
    }
    

    public void persist(Object object) {
        em.persist(object);
    }
    
    
    
}
