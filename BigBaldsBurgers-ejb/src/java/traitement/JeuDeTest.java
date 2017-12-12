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
import entites.Produit;
import entites.Propriete;
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
        
        

        Droits d01 = new Droits("serveur");
        Droits d02 = new Droits("cuisinier");
        Droits d03 = new Droits("caissier");
        em.persist(d01);
        em.persist(d02);
        em.persist(d03);
        em.flush();
        
        Employe e01 = new Employe(001, "Ney", "Mar", "0606060606", "neymar@gmail.com", "neymar");
        Employe e02 = new Employe(002, "Cav", "Ani", "0606060607", "cavani@gmail.com", "cavani");
        Employe e03 = new Employe(003, "Mba", "ppé", "0606060608", "mbappe@gmail.com", "mbappe");
        em.persist(e01);
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
            
        
        Produit cocaCola33 = new Produit("Coca-Cola(33cl)", 2 , null, "boisson sucrée sans sucre.");
        Produit cocaCola50 = new Produit("Coca-Cola(50cl)", 2.5f , null, "boisson sucrée sans sucre.");
        Produit cocaColaL33 = new Produit("Coca-Cola light(33cl)", 2 , null, "boisson sans sucre gout sucré.");
        Produit cocaColaL50 = new Produit("Coca-Cola light(50cl)", 2.5f , null, "boisson sans sucre gout sucré.");
        Produit orangeJuice33 = new Produit("OrangeJuice(33cl)", 2 , null, "Fait d'orange de sibérie.");
        Produit orangeJuice50 = new Produit("OrangeJuice(33cl)", 2.5f , null, "Fait d'orange de sibérie.");
        Produit iceTea33 = new Produit("IceTea(33cl)", 2 , null, "Boisson Froide mais pas trop chaude.");
        Produit iceTea50 = new Produit("IceTea(50cl)", 2.5f , null, "Boisson Froide mais pas trop chaude.");
        Produit coors33 = new Produit("Coors(33cl)", 2.5f , null, "Pour mieux faire la course. l'abus de Coors est dangereux pour faire les courses.");
        Produit coors50 = new Produit("Coors(50cl)", 3.5f , null, "Pour mieux faire la course. l'abus de Coors est dangereux pour faire les courses.");
        Produit despe33 = new Produit("Desperados(33cl)", 2.5f , null, "un mexicain se cache à l'interieur de cette boisson.");
        Produit despe50 = new Produit("Desperados(50cl)", 3.5f , null, "un mexicain se cache à l'interieur de cette boisson.");
        Produit frite = new Produit("Frites", 2.5f , null, "frite fraiches maison.");
        Produit patatoes = new Produit("Patatoes", 2.5f , null, "Patatoes fraiches maison.");
        Produit saladeDeChauve = new Produit("Salade de Chauves", 2.5f , null, "Salade composé, recette secrete du chef.");
        Produit onionRings = new Produit("Onion Rings", 2f , null, "Onion fris dans notre huile de la veille.");
        Produit mozzaStick = new Produit("Mozza Stick", 2f , null, "Batonnet de Mozart uniquement quand il est là.");
        Produit brownie = new Produit("Brownie", 3 , null, "Brownie du chef fait avec son chocolat maison.");
        Produit mousseAuChocolat = new Produit("Mousse au chocolat", 3 , null, "Mousse du chef fait avec son chocolat maison.");
        Produit leBigBald = new Produit("Le Big Bald", 5.5f , null, "Notre Fameux Burger.");
        Produit leChrisBurger = new Produit("Le Chris Burger", 7.5f , null, "Inspiré maitre christophe, pour les amoureux de la viande.");
        Produit leVeganBald = new Produit("Le Vegan Bald", 6.5f , null, "Pour ceux qui ont qui ont rien compris à la vie et qui ne mangent pas de viande.");
        Produit leCheeseBald = new Produit("Le Big Bald", 5.5f , null, "Si vous etes fan de fromage, ce burger est pour vous.");
        
        
        em.persist(cocaCola33);
        em.persist(cocaCola50);
        em.persist(cocaColaL33);
        em.persist(cocaColaL50);
        em.persist(orangeJuice33);
        em.persist(orangeJuice50);
        em.persist(iceTea33);
        em.persist(iceTea50);
        em.persist(coors33);
        em.persist(coors50);
        em.persist(despe33);
        em.persist(despe50);
        em.persist(frite);
        em.persist(patatoes);
        em.persist(saladeDeChauve);
        em.persist(onionRings);
        em.persist(mozzaStick);
        em.persist(brownie);
        em.persist(mousseAuChocolat);
        em.persist(leBigBald);
        em.persist(leChrisBurger);
        em.persist(leVeganBald);
        em.persist(leCheeseBald);
        
        
        Propriete boisson33P = new Propriete("Soda", "33cl", "Volume");
        Propriete boisson50P = new Propriete("Soda", "50cl", "Volume");
        Propriete boissonA33P= new Propriete("Biere", "33cl", "Volume");
        Propriete boissonA50P= new Propriete("Biere", "50cl", "Volume");
        Propriete coorsP= new Propriete("Biere", "3.2%", "Pourcentage d'alcool");
        Propriete despeP= new Propriete("Biere", "6.3%", "Pourcentage d'alcool");
        Propriete friteP = new Propriete("Accompagnement", "300", "calories");
        Propriete patatoesP = new Propriete("Accompagnement", "300", "calories");
        Propriete saladeP = new Propriete("Accompagnement", "152", "calories");
        Propriete onionRigsP = new Propriete("Entree", "235", "calories");
        Propriete mozzaStickP = new Propriete("Entree", "262", "calories");
        Propriete mousseAuChocolatP = new Propriete("Dessert", "652", "calories");
        Propriete brownieP = new Propriete("Dessert", "453", "calories");
        Propriete leBigBaldP = new Propriete("Burger", "1450", "calories");
        Propriete leChrisBurgerP = new Propriete("Burger", "1320", "calories");
        Propriete leVeganBaldP = new Propriete("Burger", "965", "calories");
        Propriete leCheeseBaldP = new Propriete("Burger", "9453", "calories");
        
        em.persist(boisson33P);
        em.persist(boisson50P);
        em.persist(boissonA33P);
        em.persist(boissonA50P);
        em.persist(coorsP);
        em.persist(despeP);
        em.persist(friteP);
        em.persist(patatoesP);
        em.persist(saladeP);
        em.persist(onionRigsP);
        em.persist(mozzaStickP);
        em.persist(mousseAuChocolatP);
        em.persist(brownieP);
        em.persist(leBigBaldP);
        em.persist(leChrisBurgerP);
        em.persist(leVeganBaldP);
        em.persist(leCheeseBaldP);
        
        
        
    }
}
