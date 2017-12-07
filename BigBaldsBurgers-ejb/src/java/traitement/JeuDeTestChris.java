/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.FamilleIngredient;
import entites.Ingredients;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tofi
 */
@Stateless
public class JeuDeTestChris implements JeuDeTestChrisLocal {

    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
 private EntityManager em;
 
 @Override
 public void creerDonnees(){
 FamilleIngredient legumes = new FamilleIngredient("legumes");
        FamilleIngredient viandes = new FamilleIngredient("viandes");
        FamilleIngredient pains = new FamilleIngredient("pains");
        FamilleIngredient liquides = new FamilleIngredient("liquides");
        FamilleIngredient fromages = new FamilleIngredient("fromages");
        FamilleIngredient sauces = new FamilleIngredient("sauces");
       
        Ingredients laitue = new Ingredients("laitue");
        Ingredients tomate = new Ingredients("tomate");
        Ingredients cornichon = new Ingredients("cornichon");
        Ingredients cheddar = new Ingredients("cheddar");
        Ingredients steackHC = new Ingredients("steackHC");
        Ingredients baldsSauce = new Ingredients("balds sauce");
        
        
       
 }
}
