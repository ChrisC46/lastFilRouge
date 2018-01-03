package controleurs.client;

import controleurs.secondaire.SousControleur;
import entites.Produit;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import traitement.GestionCategorieCarteLocal;

public class FormuleCtrl implements Serializable, SousControleur {

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {

        GestionCategorieCarteLocal carte = lookupGestionCategorieCarteLocal();
        String page = "/WEB-INF/client/detailFormule.jsp";;

        String idProduit = request.getParameter("id");
        request.setAttribute("produit", carte.getFormuleById(idProduit));
        
        List<Produit> burger = carte.getProduitByFormule("Burger", idProduit);
        List<Produit> boisson = carte.getBoissonByFormule("Boisson", idProduit);
        List<Produit> accompagnement = carte.getProduitByFormule("Accompagnement", idProduit);

        request.setAttribute("accompagnement", accompagnement);
        request.setAttribute("burger", burger);
        request.setAttribute("boisson", boisson);
        
        if ("EndBaldMeal".equals(idProduit)) {
            List<Produit> dessert = carte.getProduitByFormule("Dessert", idProduit);
            request.setAttribute("dessert", dessert);           
        }

        if ("StartBaldMeal".equals(idProduit)) {           
            List<Produit> entrees = carte.getProduitByFormule("Entree", idProduit);            
            request.setAttribute("entrees", entrees);
            
        }
        if ("FullBaldMeal".equals(idProduit)) {
            List<Produit> entrees = carte.getProduitByFormule("Entree", idProduit);
            List<Produit> dessert = carte.getProduitByFormule("Dessert", idProduit);
            request.setAttribute("dessert", dessert);
            request.setAttribute("entrees", entrees);
        }

        return page;

    }

    private GestionCategorieCarteLocal lookupGestionCategorieCarteLocal() {
        try {
            Context c = new InitialContext();
            return (GestionCategorieCarteLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionCategorieCarte!traitement.GestionCategorieCarteLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
