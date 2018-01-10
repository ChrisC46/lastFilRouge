/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.secondaire;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import traitement.GestionCommandeLocal;

public class CommandeCtrl implements Serializable, SousControleur {

  @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        String action = request.getParameter("action");
        String origine = request.getParameter("origine");
        String reference = request.getParameter("ref");
        String page="/WEB-INF/acceuil.jsp";
        if (session.getAttribute("gestionCommande") == null) {
            session.setAttribute("gestionCommande", lookupGestionCommandeLocal());
        }
        GestionCommandeLocal gestionCommande = (GestionCommandeLocal) session.getAttribute("gestionCommande");

        
        if ("dec".equals(action)) {
            gestionCommande.dec(reference);
        }
        
        if ("del".equals(action)) {
            gestionCommande.del(reference);
        }
        if ("add".equals(action)) {
            gestionCommande.ajouter(reference);
        }
        if ("catalogue".equals(origine)) {
            page = "FrontControleur?section=catalogue-affichage";
        }
        if ("panier".equals(origine)) {
            page = "FrontControleur?section=panier-affichage";
        }
if("ajax".equals(origine)){
    page= "FrontControleur?section=menu-main";
}
        request.setAttribute("redirect", true);
        return page;
    }

    private GestionCommandeLocal lookupGestionCommandeLocal() {
        try {
            Context c = new InitialContext();
            return (GestionCommandeLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionCommande!traitement.GestionCommandeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
