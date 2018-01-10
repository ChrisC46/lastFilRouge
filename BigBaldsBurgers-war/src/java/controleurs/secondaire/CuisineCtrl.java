package controleurs.secondaire;

import entites.LigneDeCommande;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import traitement.GestionCuisineLocal;

public class CuisineCtrl implements SousControleur {

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        String page = "/WEB-INF/cuisine.jsp";

        GestionCuisineLocal gestionCuisine = lookupGestionCuisineLocal();

        if ("all".equals(request.getParameter("describe"))) {
            List<LigneDeCommande> commandesCuisine = gestionCuisine.listeCommandesCuisine();
            request.setAttribute("ligneCommande", commandesCuisine);
        }

        if ("transmis".equals(request.getParameter("describe"))) {
            List<LigneDeCommande> commandeCuisine = gestionCuisine.listeCommandesCuisineTransmise();
            request.setAttribute("ligneCommande", commandeCuisine);
        }

        if ("preparation".equals(request.getParameter("describe"))) {
            List<LigneDeCommande> commandeCuisine = gestionCuisine.listeCommandesCuisineEnPrepa();
            request.setAttribute("ligneCommande", commandeCuisine);
        }

        if ("pret".equals(request.getParameter("describe"))) {
            List<LigneDeCommande> commandeCuisine = gestionCuisine.listeCommandesCuisineEnPrete();
            request.setAttribute("ligneCommande", commandeCuisine);
        }

        return page;

    }

    private GestionCuisineLocal lookupGestionCuisineLocal() {
        try {
            Context c = new InitialContext();
            return (GestionCuisineLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionCuisine!traitement.GestionCuisineLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
