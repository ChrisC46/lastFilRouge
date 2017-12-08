/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.FamilleIngredient;
import entites.Ingredients;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tofi
 */
public class JeuDeTest {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AeroportPU");
        EntityManager em = emf.createEntityManager();
        
        FamilleIngredient legumes = new FamilleIngredient("legumes");
        FamilleIngredient viandes = new FamilleIngredient("viandes");
        FamilleIngredient pains = new FamilleIngredient("pains");
        FamilleIngredient liquides = new FamilleIngredient("liquides");
        FamilleIngredient fromages = new FamilleIngredient("fromages");
        FamilleIngredient sauces = new FamilleIngredient("sauces");
        
        Ingredients laitue = new Ingredients("laitue");
        Ingredients tomate = new Ingredients("tomate");
        Ingredients frites = new Ingredients("frites");
        Ingredients potatoes = new Ingredients("potatoes");
        Ingredients cornichon = new Ingredients("cornichon");
        Ingredients cheddar = new Ingredients("cheddar");
        Ingredients steackHC = new Ingredients("steackHC");
        Ingredients baldsSauce = new Ingredients("balds sauce");
        
         em.persist(legumes);
        em.persist(viandes);
        em.persist(pains);
        em.persist(liquides);
        em.persist(fromages);
        em.persist(sauces);
        
        em.close();
        emf.close();
    }
}
