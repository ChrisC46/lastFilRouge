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
import entites.Commande;
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

        Status staTransmis = new Status("transmise", "Votre commande est transmise à la cuisine, un instant de patience :-)");
        Status staEnPrepa = new Status("preparation", "Le chef accepte votre challenge, il active sa team");
        Status staPret = new Status("prete", "Challenge réussi ! Votre commande est prête");
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
        
        table01.setDispoTable(staTablePasDispo);
        table02.setDispoTable(staTablePasDispo);
        table03.setDispoTable(staTablePasDispo);
        table04.setDispoTable(staTableDispo);
        table05.setDispoTable(staTableDispo);
        

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

        Employe e01 = new Employe(001, "Ney", "Mar", "0606060606", "neymar@gmail.com", "1111");
        Employe e02 = new Employe(002, "Cav", "Ani", "0606060607", "cavani@gmail.com", "2222");
        Employe e03 = new Employe(003, "Mba", "ppé", "0606060608", "mbappe@gmail.com", "3333");
        Employe e04 = new Employe(004,"all","acces","0000000000","allacces@gmail.com","1234");
        em.persist(e01);
        em.persist(e02);
        em.persist(e03);
        em.persist(e04);
        em.flush();
        
        e01.getTypeDroit().add(d01);
        e01.getTypeDroit().add(d03);
        e02.getTypeDroit().add(d02);
        e03.getTypeDroit().add(d03);
        e04.getTypeDroit().add(d03);
        e04.getTypeDroit().add(d02);
        e04.getTypeDroit().add(d01);

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
     

        Produit cocaCola = new Produit("Coca-Cola", 2, "images/cocacola.png", "boisson sucrée sans sucre.");
        Produit cocaColaL = new Produit("Coca-Cola light", 2, "images/cocaLight.png", "boisson sans sucre gout sucré.");
        Produit orangeJuice = new Produit("OrangeJuice", 2, "images/OrangeJuice.png", "Fait d'orange de sibérie.");
        Produit iceTea = new Produit("IceTea", 2, "images/Lipton.png", "Boisson Froide mais pas trop chaude.");
        Produit coors = new Produit("Coors", 2.5f, "images/coors.png", "Pour mieux faire la course. l'abus de Coors est dangereux pour faire les courses.");
        Produit despe = new Produit("Desperados", 2.5f, "images/despe.png", "un mexicain se cache à l'interieur de cette boisson.");
        Produit frite = new Produit("Frites", 2.5f, "images/frite.png", "frite fraiches maison.");
        Produit patatoes = new Produit("Patatoes", 2.5f, "images/potatoes.png", "Patatoes fraiches maison.");
        Produit saladeDeChauve = new Produit("Salade de Chauves", 2.5f, "images/salade.png", "Salade composé, recette secrete du chef.");
        Produit onionRings = new Produit("Onion Rings", 2f, "images/OnionRings.png", "Onion fris dans notre huile de la veille.");
        Produit mozzaStick = new Produit("Mozza Stick", 2f, "images/MozzarelaSticks.png", "Batonnet de Mozart uniquement quand il est là.");
        Produit brownie = new Produit("Brownie", 3, "images/Brownie.png", "Brownie du chef fait avec son chocolat maison.");
        Produit mousseAuChocolat = new Produit("Mousse au chocolat", 3, "images/mousse.png", "Mousse du chef fait avec son chocolat maison.");
        Produit leBigBald = new Produit("Le Big Bald", 5.5f, "images/Lebigbalds.png", "Notre Fameux Burger.");
        Produit leChrisBurger = new Produit("Le Chris Burger", 7.5f, "images/nom2.png", "Inspiré maitre christophe, pour les amoureux de la viande.");
        Produit leVeganBald = new Produit("Le Vegan Bald", 6.5f, "images/leVegan.png", "Pour ceux qui ont qui ont rien compris à la vie et qui ne mangent pas de viande.");
        Produit leCheeseBald = new Produit("Le cheese Bald", 5.5f, "images/nom4.png", "Si vous etes fan de fromage, ce burger est pour vous.");

        em.persist(cocaCola);
        em.persist(cocaColaL);
        em.persist(orangeJuice);
        em.persist(iceTea);
        em.persist(coors);
        em.persist(despe);
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
          
        Propriete boisson33P = new Propriete("Boisson", "33cl", "Volume");
        Propriete boisson50P = new Propriete("Boisson", "50cl", "Volume");
        Propriete boissonA33P = new Propriete("Boisson", "33cl", "Volume");
        Propriete boissonA50P = new Propriete("Boisson", "50cl", "Volume");
        Propriete coorsP = new Propriete("Biere", "3.2%", "Pourcentage d'alcool");
        Propriete despeP = new Propriete("Biere", "6.3%", "Pourcentage d'alcool");
        Propriete friteP = new Propriete("Accompagnement", "300", "calories");
        Propriete patatoesP = new Propriete("Accompagnement", "350", "calories");
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

        cocaCola.getProprietes().add(boisson33P);
        cocaCola.getProprietes().add(boisson50P);
        cocaColaL.getProprietes().add(boisson33P);
        cocaColaL.getProprietes().add(boisson50P);
        orangeJuice.getProprietes().add(boisson33P);
        orangeJuice.getProprietes().add(boisson50P);
        iceTea.getProprietes().add(boisson33P);
        iceTea.getProprietes().add(boisson50P);
        coors.getProprietes().add(boissonA33P);
        coors.getProprietes().add(boissonA50P);
        despe.getProprietes().add(boissonA33P);
        despe.getProprietes().add(boissonA50P);
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
        
        Formule formule1 = new Formule("StartBaldMeal", "Entrée + burger  + boisson(33cl) au choix", 12.99f, "images/FormuleFull.jpg");
        Formule formule2 = new Formule("EndBaldMeal", "Burger + déssert + boisson(33cl) au choix", 13.99f, "images/FormuleFull.jpg");
        Formule formule3 = new Formule("FullBaldMeal", "Entrée + burger + déssert + boisson(33cl) au choix", 15.99f, "images/FormuleFull.jpg");
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
        cocaCola.getFormules().add(formule1);
        cocaCola.getFormules().add(formule2);
        cocaCola.getFormules().add(formule3);
        cocaColaL.getFormules().add(formule1);
        cocaColaL.getFormules().add(formule2);
        cocaColaL.getFormules().add(formule3);
        orangeJuice.getFormules().add(formule1);
        orangeJuice.getFormules().add(formule2);
        orangeJuice.getFormules().add(formule3);
        iceTea.getFormules().add(formule1);
        iceTea.getFormules().add(formule2);
        iceTea.getFormules().add(formule3);

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

        cocaCola.setCategorieFormuleProduit(carteFormule);
        cocaColaL.setCategorieFormuleProduit(carteFormule);
        iceTea.setCategorieFormuleProduit(carteFormule);
        coors.setCategorieFormuleProduit(carteFormule);
        despe.setCategorieFormuleProduit(carteFormule);
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

        LigneDeCommande lCde11 = new LigneDeCommande(1, 5.5f);
        LigneDeCommande lCde12 = new LigneDeCommande(1, 12.99f);
        LigneDeCommande lCde2 = new LigneDeCommande(1, 13.99f);
        LigneDeCommande lCde31 = new LigneDeCommande(1, 15.99f);
        LigneDeCommande lCde32 = new LigneDeCommande(2, 25.98f);
        
        em.persist(lCde11);
        em.persist(lCde12);
        em.persist(lCde2);
        em.persist(lCde31);
        em.persist(lCde32);
   
        lCde11.setProduit(leBigBald);
        lCde12.setFormule(formule1);
        lCde2.setFormule(formule2);
        lCde31.setFormule(formule3);
        lCde32.setFormule(formule1);
        
        Commande com01 = new Commande(18.49f, today);
        Commande com02 = new Commande(13.99f,today);
        Commande com03 = new Commande(41.98f,today);
        em.persist(com01);
        em.persist(com02);
        em.persist(com03);
        
        com01.setNumTable(table01);
        com02.setNumTable(table02);
        com03.setNumTable(table03);
        com01.setSuiviCommande(staPret);
        com02.setSuiviCommande(staEnPrepa);
        com03.setSuiviCommande(staPret);
        com01.setServeur(e01);
        com02.setServeur(e04);
        com03.setServeur(e01);
        
        lCde11.setCommande(com01);
        lCde12.setCommande(com01);
        lCde2.setCommande(com02);
        lCde31.setCommande(com03);
        lCde32.setCommande(com03);
    }
}
