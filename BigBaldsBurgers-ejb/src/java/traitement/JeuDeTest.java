/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Droits;
import entites.Employe;
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
public class JeuDeTest implements JeuDeTestLocal {

    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;

    @Override
    public void creerDonnees() {
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
        Ingredients sauceBalds = new Ingredients("balds sauce");
        Ingredients oignonRouge = new Ingredients("oignons rouge");
        Ingredients oignonCara = new Ingredients("oignons caramélisés");
        Ingredients emmental = new Ingredients("emmental");
        Ingredients bacon = new Ingredients("bacon");
        Ingredients oeuf = new Ingredients("oeuf");
        Ingredients oignonFrit = new Ingredients("oignons frits");
        Ingredients pickles = new Ingredients("pickles");
        Ingredients sauceGorgon = new Ingredients("sauce gorgonzola");
        Ingredients sauceCeasar = new Ingredients("sauce caesar");
        Ingredients mozarella = new Ingredients("mozzarella");
        
        Employe e01 = new Employe(001, "Ney", "Mar", "0606060606", "neymar@gmail.com", "neymar");
        Employe e02 = new Employe(002, "Cav", "Ani", "0606060607", "cavani@gmail.com", "cavani");
        Employe e03 = new Employe(003, "Mba", "ppé", "0606060608", "mbappe@gmail.com", "mbappe");
        em.persist(e01);
        em.persist(e02);
        em.persist(e03);
        em.flush();

        Droits d01 = new Droits("serveur");
        Droits d02 = new Droits("cuisinier");
        Droits d03 = new Droits("caissier");
        em.persist(d01);
        em.persist(e02);
        em.persist(e03);
        em.flush();
        
        laitue.setFamilleIngredient(legumes);
        tomate.setFamilleIngredient(legumes);
        frites.setFamilleIngredient(legumes);
        potatoes.setFamilleIngredient(legumes);
        cornichon.setFamilleIngredient(legumes);
        oignonRouge.setFamilleIngredient(legumes);
        oignonFrit.setFamilleIngredient(legumes);
        oignonCara.setFamilleIngredient(legumes);
        pickles.setFamilleIngredient(legumes);
        cheddar.setFamilleIngredient(fromages);
        emmental.setFamilleIngredient(fromages);
        mozarella.setFamilleIngredient(fromages);
        steackHC.setFamilleIngredient(viandes);
        bacon.setFamilleIngredient(viandes);
        sauceBalds.setFamilleIngredient(sauces);
        sauceCeasar.setFamilleIngredient(sauces);
        sauceGorgon.setFamilleIngredient(sauces);

        em.persist(legumes);
        em.persist(viandes);
        em.persist(pains);
        em.persist(liquides);
        em.persist(fromages);
        em.persist(sauces);
        em.persist(laitue);
        em.persist(tomate);
        em.persist(frites);
        em.persist(potatoes);
        em.persist(cornichon);
        em.persist(oignonCara);
        em.persist(oignonFrit);
        em.persist(oignonRouge);
        em.persist(pickles);
        em.persist(cheddar);
        em.persist(emmental);
        em.persist(mozarella);
        em.persist(steackHC);
        em.persist(bacon);
        em.persist(sauceBalds);
        em.persist(sauceCeasar);
        em.persist(sauceGorgon);

    
    }
}
