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
import traitement.GestionCategorieCarteLocal;

/**
 *
 * @author cdi317
 */
public class CategorieCarteCtrl implements Serializable, SousControleur {

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {

        GestionCategorieCarteLocal carte = lookupGestionCategorieCarteLocal();
        String page = "";

        if ("Boisson".equals(request.getParameter("section"))) {
            request.setAttribute("produits", carte.getProduitByProP("Boisson"));
            page = "/WEB-INF/client/produitsByCat.jsp";
        }
        if ("Accompagnement".equals(request.getParameter("section"))) {
           request.setAttribute("produits", carte.getProduitByProP("Accompagnement"));
            page = "/WEB-INF/client/produitsByCat.jsp";
        }
        if ("Entree".equals(request.getParameter("section"))) {
           request.setAttribute("produits", carte.getProduitByProP("Entree"));
            page = "/WEB-INF/client/produitsByCat.jsp";
        }
        if ("Dessert".equals(request.getParameter("section"))) {
            request.setAttribute("produits", carte.getProduitByProP("Dessert"));
            page = "/WEB-INF/client/produitsByCat.jsp";
        }
        if ("Burger".equals(request.getParameter("section"))) {
            request.setAttribute("produits", carte.getProduitByProP("Burger"));
            page = "/WEB-INF/client/produitsByCat.jsp";
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