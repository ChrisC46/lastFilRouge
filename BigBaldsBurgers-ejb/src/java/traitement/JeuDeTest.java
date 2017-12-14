/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.BigBaldsBurgers;
import entites.Carte;
import entites.CategorieFormule;
import entites.CategorieProduit;
import entites.Disponibilite;
import entites.Droits;
import entites.Emplacement;
import entites.Employe;
import entites.FamilleIngredient;
import entites.Formule;
import entites.Ingredients;
import entites.LigneDeCommande;
import entites.Produit;
import entites.Promotion;
import entites.Propriete;
import entites.Specification;
import entites.Status;
import entites.Tva;
import entites.TypeCuisson;
import entites.TypeDePaiement;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        Ingredients bunBurger = new Ingredients("Bun Burger");

        Date today = new GregorianCalendar(2017, 11, 11).getTime();
        Tva tvaAlcool = new Tva("tvaAlcool", 20.00F, today);
        Tva tvaCarte = new Tva("tvaCarte", 10.00F, today);
        Tva tvaFormule = new Tva("tvaFormule", 10.00F, today);
        em.persist(tvaAlcool);
        em.persist(tvaCarte);
        em.persist(tvaFormule);

        TypeCuisson bleu = new TypeCuisson("Bleu");
        TypeCuisson saignant = new TypeCuisson("Saignant");
        TypeCuisson aPoint = new TypeCuisson("A point");
        TypeCuisson bienCuit = new TypeCuisson("Bien cuit");
        TypeCuisson roseVolailles = new TypeCuisson("Rose");
        em.persist(bleu);
        em.persist(saignant);
        em.persist(aPoint);
        em.persist(bienCuit);
        em.persist(roseVolailles);

        Carte nomCarte = new Carte("BigBaldsBurgers");
        em.persist(nomCarte);

        CategorieFormule carteFormule = new CategorieFormule("Les menus des BigBalds");
        CategorieFormule carteResto = new CategorieFormule("La carte des BigBalds");
        em.persist(carteFormule);
        em.persist(carteResto);
        carteFormule.setCarte(nomCarte);
        carteResto.setCarte(nomCarte);

        Date promoStart = new GregorianCalendar(2017, 11, 11, 10, 00).getTime();
        Date promoEnd = new GregorianCalendar(2018, 0, 14, 23, 59).getTime();
        Promotion promo = new Promotion(10.00F, promoStart, promoEnd);
        em.persist(promo);

        CategorieProduit cuisine = new CategorieProduit("cuisine");
        CategorieProduit bar = new CategorieProduit("bar");
        em.persist(cuisine);
        em.persist(bar);

        TypeDePaiement cb = new TypeDePaiement("CB");
        TypeDePaiement cheque = new TypeDePaiement("cheque");
        TypeDePaiement especes = new TypeDePaiement("especes");
        TypeDePaiement ticketResto = new TypeDePaiement("ticket resto");
        em.persist(cb);
        em.persist(cheque);
        em.persist(especes);
        em.persist(ticketResto);

        Status staTransmis = new Status("commande transmise", "Votre commande est transmise à la cuisine, un instant de patience :-)");
        Status staEnPrepa = new Status("commande en preparation", "Le chef accepte votre challenge, il active sa team");
        Status staPret = new Status("commande prete", "Challenge réussi ! Votre commande est prête");
        Status staSelect = new Status("selection en cours", "Faite vos jeux ! A tous les coups on se regale");
        Status staTableDispo = new Status("table disponible");
        Status staTablePasDispo = new Status("table non disponible");
        Status staTableClean = new Status("table à debarasser");
        em.persist(staEnPrepa);
        em.persist(staPret);
        em.persist(staSelect);
        em.persist(staTableClean);
        em.persist(staTableDispo);
        em.persist(staTablePasDispo);
        em.persist(staTransmis);

        Emplacement table01 = new Emplacement("01", 4);
        Emplacement table02 = new Emplacement("02", 2);
        Emplacement table03 = new Emplacement("03", 6);
        Emplacement table04 = new Emplacement("04", 4);
        Emplacement table05 = new Emplacement("05", 8);
        em.persist(table01);
        em.persist(table02);
        em.persist(table03);
        em.persist(table04);
        em.persist(table05);

        BigBaldsBurgers bbg = new BigBaldsBurgers("BigBaldsBurgers", "1 rue de la soif 75008 PARIS", "0172607631", "bigbaldsburgers@bbg.fr", "12345678900043", "www.bigbaldsburgers.com", "X");
        em.persist(bbg);

        Specification ketchup = new Specification("ketchup");
        Specification sansSel = new Specification("sans sel");
        Specification mayo = new Specification("mayonnaise");
        em.persist(ketchup);
        em.persist(sansSel);
        em.persist(mayo);

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
        bunBurger.setFamilleIngredient(pains);

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
        em.persist(oeuf);
        em.persist(bunBurger);
     

        Produit cocaCola33 = new Produit("Coca-Cola(33cl)", 2, null, "boisson sucrée sans sucre.");
        Produit cocaCola50 = new Produit("Coca-Cola(50cl)", 2.5f, null, "boisson sucrée sans sucre.");
        Produit cocaColaL33 = new Produit("Coca-Cola light(33cl)", 2, null, "boisson sans sucre gout sucré.");
        Produit cocaColaL50 = new Produit("Coca-Cola light(50cl)", 2.5f, null, "boisson sans sucre gout sucré.");
        Produit orangeJuice33 = new Produit("OrangeJuice(33cl)", 2, null, "Fait d'orange de sibérie.");
        Produit orangeJuice50 = new Produit("OrangeJuice(33cl)", 2.5f, null, "Fait d'orange de sibérie.");
        Produit iceTea33 = new Produit("IceTea(33cl)", 2, null, "Boisson Froide mais pas trop chaude.");
        Produit iceTea50 = new Produit("IceTea(50cl)", 2.5f, null, "Boisson Froide mais pas trop chaude.");
        Produit coors33 = new Produit("Coors(33cl)", 2.5f, null, "Pour mieux faire la course. l'abus de Coors est dangereux pour faire les courses.");
        Produit coors50 = new Produit("Coors(50cl)", 3.5f, null, "Pour mieux faire la course. l'abus de Coors est dangereux pour faire les courses.");
        Produit despe33 = new Produit("Desperados(33cl)", 2.5f, null, "un mexicain se cache à l'interieur de cette boisson.");
        Produit despe50 = new Produit("Desperados(50cl)", 3.5f, null, "un mexicain se cache à l'interieur de cette boisson.");
        Produit frite = new Produit("Frites", 2.5f, null, "frite fraiches maison.");
        Produit patatoes = new Produit("Patatoes", 2.5f, null, "Patatoes fraiches maison.");
        Produit saladeDeChauve = new Produit("Salade de Chauves", 2.5f, null, "Salade composé, recette secrete du chef.");
        Produit onionRings = new Produit("Onion Rings", 2f, null, "Onion fris dans notre huile de la veille.");
        Produit mozzaStick = new Produit("Mozza Stick", 2f, null, "Batonnet de Mozart uniquement quand il est là.");
        Produit brownie = new Produit("Brownie", 3, null, "Brownie du chef fait avec son chocolat maison.");
        Produit mousseAuChocolat = new Produit("Mousse au chocolat", 3, null, "Mousse du chef fait avec son chocolat maison.");
        Produit leBigBald = new Produit("Le Big Bald", 5.5f, null, "Notre Fameux Burger.");
        Produit leChrisBurger = new Produit("Le Chris Burger", 7.5f, null, "Inspiré maitre christophe, pour les amoureux de la viande.");
        Produit leVeganBald = new Produit("Le Vegan Bald", 6.5f, null, "Pour ceux qui ont qui ont rien compris à la vie et qui ne mangent pas de viande.");
        Produit leCheeseBald = new Produit("Le Big Bald", 5.5f, null, "Si vous etes fan de fromage, ce burger est pour vous.");

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
        
        leBigBald.getIngredients().add(oeuf);
        leBigBald.getIngredients().add(steackHC);
        leBigBald.getIngredients().add(tomate);
        leBigBald.getIngredients().add(laitue);
        leBigBald.getIngredients().add(cheddar);
        leBigBald.getIngredients().add(pickles);
        leBigBald.getIngredients().add(sauceBalds);
        leBigBald.getIngredients().add(bunBurger);

        
        leChrisBurger.getIngredients().add(steackHC);
        leChrisBurger.getIngredients().add(mozarella);
        leChrisBurger.getIngredients().add(bacon);
        leChrisBurger.getIngredients().add(sauceGorgon);
        leChrisBurger.getIngredients().add(oignonCara);
          
        leVeganBald.getIngredients().add(laitue);
        leVeganBald.getIngredients().add(tomate);
        leVeganBald.getIngredients().add(sauceCeasar);
        leVeganBald.getIngredients().add(cornichon);
        leVeganBald.getIngredients().add(oignonCara);
        leVeganBald.getIngredients().add(bunBurger);
          
        leCheeseBald.getIngredients().add(steackHC);
        leCheeseBald.getIngredients().add(mozarella);
        leCheeseBald.getIngredients().add(sauceGorgon);
        leCheeseBald.getIngredients().add(cheddar);
        leCheeseBald.getIngredients().add(oeuf);
        leCheeseBald.getIngredients().add(pickles);
        leCheeseBald.getIngredients().add(bunBurger);
          
        Propriete boisson33P = new Propriete("Soda", "33cl", "Volume");
        Propriete boisson50P = new Propriete("Soda", "50cl", "Volume");
        Propriete boissonA33P = new Propriete("Biere", "33cl", "Volume");
        Propriete boissonA50P = new Propriete("Biere", "50cl", "Volume");
        Propriete coorsP = new Propriete("Biere", "3.2%", "Pourcentage d'alcool");
        Propriete despeP = new Propriete("Biere", "6.3%", "Pourcentage d'alcool");
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

        cocaCola33.getProprietes().add(boisson33P);
        cocaCola50.getProprietes().add(boisson50P);
        cocaColaL33.getProprietes().add(boisson33P);
        cocaColaL50.getProprietes().add(boisson50P);
        orangeJuice33.getProprietes().add(boisson33P);
        orangeJuice50.getProprietes().add(boisson50P);
        iceTea33.getProprietes().add(boisson33P);
        iceTea50.getProprietes().add(boisson50P);
        coors33.getProprietes().add(boisson33P);
        coors50.getProprietes().add(boisson50P);
        despe33.getProprietes().add(boisson33P);
        despe50.getProprietes().add(boisson50P);
        coors33.getProprietes().add(boissonA33P);
        coors50.getProprietes().add(boissonA50P);
        despe33.getProprietes().add(boissonA33P);
        despe50.getProprietes().add(boissonA50P);
        frite.getProprietes().add(friteP);
        patatoes.getProprietes().add(patatoesP);
        saladeDeChauve.getProprietes().add(saladeP);
        mozzaStick.getProprietes().add(mozzaStickP);
        onionRings.getProprietes().add(onionRigsP);
        mousseAuChocolat.getProprietes().add(mousseAuChocolatP);
        brownie.getProprietes().add(brownieP);
        leBigBald.getProprietes().add(leBigBaldP);
        leCheeseBald.getProprietes().add(leCheeseBaldP);
        leChrisBurger.getProprietes().add(leChrisBurgerP);
        leVeganBald.getProprietes().add(leVeganBaldP);
        
        
        
        
        
        
        Formule formule1 = new Formule("StartBaldMeal", "Entrée + burger + boisson(33cl) au choix", 12.99f, null);
        Formule formule2 = new Formule("EndtBaldMeal", "Burger + désert + boisson(33cl) au choix", 13.99f, null);
        Formule formule3 = new Formule("FullBaldMeal", "Entrée + burger + désert + boisson(33cl) au choix", 15.99f, null);
        em.persist(formule1);
        em.persist(formule2);
        em.persist(formule3);
        
        formule1.setCategorieFormule(carteFormule);
        formule2.setCategorieFormule(carteFormule);
        formule3.setCategorieFormule(carteFormule);
 
        onionRings.getFormules().add(formule1);
        onionRings.getFormules().add(formule3);
        mozzaStick.getFormules().add(formule1);
        mozzaStick.getFormules().add(formule3);
        brownie.getFormules().add(formule2);
        brownie.getFormules().add(formule3);
        mousseAuChocolat.getFormules().add(formule2);
        mousseAuChocolat.getFormules().add(formule3);
        leBigBald.getFormules().add(formule1);
        leBigBald.getFormules().add(formule2);
        leBigBald.getFormules().add(formule3);
        leChrisBurger.getFormules().add(formule1);
        leChrisBurger.getFormules().add(formule2);
        leChrisBurger.getFormules().add(formule3);
        leVeganBald.getFormules().add(formule1);
        leVeganBald.getFormules().add(formule2);
        leVeganBald.getFormules().add(formule3);
        leCheeseBald.getFormules().add(formule1);
        leCheeseBald.getFormules().add(formule2);
        leCheeseBald.getFormules().add(formule3);
        cocaCola33.getFormules().add(formule1);
        cocaCola33.getFormules().add(formule2);
        cocaCola33.getFormules().add(formule3);
        cocaColaL33.getFormules().add(formule1);
        cocaColaL33.getFormules().add(formule2);
        cocaColaL33.getFormules().add(formule3);
        orangeJuice33.getFormules().add(formule1);
        orangeJuice33.getFormules().add(formule2);
        orangeJuice33.getFormules().add(formule3);
        iceTea33.getFormules().add(formule1);
        iceTea33.getFormules().add(formule2);
        iceTea33.getFormules().add(formule3);

        Disponibilite dispo = new Disponibilite(true);
        Disponibilite pasDispo = new Disponibilite(false);
        em.persist(dispo);
        em.persist(pasDispo);

        laitue.setDisponibilite(dispo);
        tomate.setDisponibilite(dispo);
        frites.setDisponibilite(dispo);
        potatoes.setDisponibilite(dispo);
        cornichon.setDisponibilite(dispo);
        oignonCara.setDisponibilite(dispo);
        oignonFrit.setDisponibilite(dispo);
        oignonRouge.setDisponibilite(dispo);
        pickles.setDisponibilite(dispo);
        cheddar.setDisponibilite(dispo);
        emmental.setDisponibilite(dispo);
        mozarella.setDisponibilite(dispo);
        steackHC.setDisponibilite(dispo);
        bacon.setDisponibilite(dispo);
        sauceBalds.setDisponibilite(dispo);
        sauceCeasar.setDisponibilite(dispo);
        sauceGorgon.setDisponibilite(dispo);
        bunBurger.setDisponibilite(dispo);

        cocaCola33.setCategorieFormuleProduit(carteFormule);
        cocaCola50.setCategorieFormuleProduit(carteFormule);
        cocaColaL33.setCategorieFormuleProduit(carteFormule);
        cocaColaL50.setCategorieFormuleProduit(carteFormule);
        iceTea33.setCategorieFormuleProduit(carteFormule);
        iceTea50.setCategorieFormuleProduit(carteFormule);
        coors33.setCategorieFormuleProduit(carteFormule);
        coors50.setCategorieFormuleProduit(carteFormule);
        despe33.setCategorieFormuleProduit(carteFormule);
        despe50.setCategorieFormuleProduit(carteFormule);
        frite.setCategorieFormuleProduit(carteFormule);
        patatoes.setCategorieFormuleProduit(carteFormule);
        saladeDeChauve.setCategorieFormuleProduit(carteFormule);
        onionRings.setCategorieFormuleProduit(carteFormule);
        mozzaStick.setCategorieFormuleProduit(carteFormule);
        brownie.setCategorieFormuleProduit(carteFormule);
        mousseAuChocolat.setCategorieFormuleProduit(carteFormule);
        leBigBald.setCategorieFormuleProduit(carteFormule);
        leChrisBurger.setCategorieFormuleProduit(carteFormule);
        leVeganBald.setCategorieFormuleProduit(carteFormule);
        leCheeseBald.setCategorieFormuleProduit(carteFormule);

        
        LigneDeCommande lCde1 = new LigneDeCommande(1, 5.5f);
        LigneDeCommande lCde2 = new LigneDeCommande(1, 12.99f);
        em.persist(lCde1);
        em.persist(lCde2);
   
        lCde1.setProduit(leBigBald);
        lCde2.setFormule(formule1);
    }
}
