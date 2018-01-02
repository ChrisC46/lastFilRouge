
package controleurs.client;

import controleurs.secondaire.SousControleur;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import traitement.GestionCategorieCarteLocal;


public class FormuleCtrl implements Serializable, SousControleur{

 
    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {

        GestionCategorieCarteLocal carte = lookupGestionCategorieCarteLocal();
        String page = "/WEB-INF/client/detailFormule.jsp";;

        String idProduit = request.getParameter("id");
        request.setAttribute("produit", carte.getFormuleById(idProduit));

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
