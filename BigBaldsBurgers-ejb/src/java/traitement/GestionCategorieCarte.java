/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.CategorieFormule;
import entites.Formule;
import entites.Ingredients;
import entites.Produit;
import entites.Propriete;
<<<<<<< HEAD
import entites.Specification;
import entites.TypeCuisson;
=======
>>>>>>> master
import java.util.HashSet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import outils.CustomedException;

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
    public List<Produit> getBoissonByFormule(String nomCategorie, String nomFormule){
        Query qr = em.createNamedQuery("entites.Produit.getBoissonByFormule");
        qr.setParameter("paramNom", nomCategorie);
        qr.setParameter("paramForm", nomFormule);
        qr.setParameter("paramVolume", "33cl");
        List<Produit> produits = qr.getResultList();
        System.out.println("requete produit by formule :  " + qr);
        return produits;        
    }
    
     @Override
    public List<Produit> getProduitByFormule(String nomCategorie, String nomFormule){
        Query qr = em.createNamedQuery("entites.Produit.getByFormule");
        qr.setParameter("paramNom", nomCategorie);
        qr.setParameter("paramForm", nomFormule);        
        List<Produit> produits = qr.getResultList();
        System.out.println("requete produit by formule :  " + qr);
        return produits;        
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
    
    @Override
    public List<Propriete> getProprieteByProd(String id){
        Query qr = em.createNamedQuery("entites.Propriete.getByProd");
        qr.setParameter("paramNom", id);
        List<Propriete> proprietes = qr.getResultList();
        //Tris Produit Uniques
         HashSet<Propriete> uniqueValues = new HashSet(proprietes);
        proprietes.clear();
        for(Propriete pro :uniqueValues){
            proprietes.add(pro);
        }
        System.out.println("requete : " + qr.toString() );
        return proprietes;
    }
    
     @Override
    public List<Ingredients> getIngredientsByProd(String id){
        Query qr = em.createNamedQuery("entites.Ingredients.getByProd");
        qr.setParameter("paramNom", id);
        List<Ingredients> ingredients = qr.getResultList();
        //Tris Produit Uniques
         HashSet<Ingredients> uniqueValues = new HashSet(ingredients);
        ingredients.clear();
        for(Ingredients ing :uniqueValues){
            ingredients.add(ing);
        }
        System.out.println("requete : " + qr.toString() );
        return ingredients;
    }
    
    @Override
    public TypeCuisson getCuissonByNom(String typeCuisson){
        Query qr = em.createNamedQuery("entites.TypeCuisson.getByNom");
        qr.setParameter("paramID", typeCuisson);
        TypeCuisson cuisson = (TypeCuisson)qr.getSingleResult();
        return cuisson;
    }
    
   
    
    
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    
    
}
