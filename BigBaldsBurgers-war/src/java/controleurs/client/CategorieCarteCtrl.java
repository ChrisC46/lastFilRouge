/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.client;

import controleurs.secondaire.SousControleur;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import traitement.GestionCategorieCarteLocal;

/**
 *
 * @author cdi317
 */
public class CategorieCarteCtrl implements Serializable, SousControleur {

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {

        GestionCategorieCarteLocal carte = lookupGestionCategorieCarteLocal();
        String page = "/WEB-INF/client/produitsByCat.jsp";
       

        if ("BoissonG".equals(request.getParameter("section"))) {
            request.setAttribute("produits", carte.getProduitByProP("Boisson"));
            request.setAttribute("categorie", "Boisson");
        }
        if ("AccompagnementG".equals(request.getParameter("section"))) {
            request.setAttribute("produits", carte.getProduitByProP("Accompagnement"));
            request.setAttribute("categorie", "Accompagnement");
        }
        if ("EntreeG".equals(request.getParameter("section"))) {
            request.setAttribute("produits", carte.getProduitByProP("Entree"));
            request.setAttribute("categorie", "Entree");
        }
        if ("DessertG".equals(request.getParameter("section"))) {
            request.setAttribute("produits", carte.getProduitByProP("Dessert"));
            request.setAttribute("categorie", "Dessert");
        }
        if ("BurgerG".equals(request.getParameter("section"))) {
            request.setAttribute("produits", carte.getProduitByProP("Burger"));
            request.setAttribute("categorie", "Burger");
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
