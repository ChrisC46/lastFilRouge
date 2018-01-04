/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.client;

import controleurs.secondaire.SousControleur;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import traitement.GestionCategorieCarteLocal;

public class BurgerCtrl implements Serializable, SousControleur {

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {

        GestionCategorieCarteLocal carte = lookupGestionCategorieCarteLocal();
        String page = "/WEB-INF/client/detailBurger.jsp";;
        String idProduit = request.getParameter("id");

        request.setAttribute("produit", carte.getProdById(idProduit));
         request.setAttribute("proprietes", carte.getProprieteByProd(idProduit));
         request.setAttribute("ingredients", carte.getIngredientsByProd(idProduit));

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
