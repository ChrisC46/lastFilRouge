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
import traitement.GestionAffichageAccueilLocal;
import traitement.GestionEmploye;
import traitement.GestionEmployeLocal;

/**
 *
 * @author Tofi
 */
public class AffichageAccueil implements Serializable, SousControleur {

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        GestionEmployeLocal gestionEmploye = lookupGestionEmployeLocal();
        String page = "/WEB-INF/home.jsp";
        String loginJSP = request.getParameter("login");
        String droitJsp = request.getParameter("choixAccueil");
        loginJSP = loginJSP.trim();
//        try {
            if (gestionEmploye.isLogin(loginJSP, droitJsp)==true) {
                if (request.getParameter("choixAccueil") != null) {
                    if (request.getParameter("choixAccueil").equals("serveur")) {
                        page = "/WEB-INF/serveur.jsp";
                    }
                    if (request.getParameter("choixAccueil").equals("client")) {
                        page = "/WEB-INF/client.jsp";
                    }
                    if (request.getParameter("choixAccueil").equals("cuisinier")) {
                        page = "/WEB-INF/cuisine.jsp";
                    }
                    if (request.getParameter("choixAccueil").equals("caissier")) {
                        page = "/WEB-INF/caisse.jsp";
                    }
                }
            }else{
                   System.out.println("coucou c'est false");
            }
//        } catch (Exception ex) {
//            System.out.println("coucou c'est false");
//            ex.printStackTrace();
//            request.setAttribute("dClasse", "erreur");
//            request.setAttribute("msg", "vous n'etes pas autorisé");
//        }
        return page;
    }

    private GestionEmployeLocal lookupGestionEmployeLocal() {
        try {
            Context c = new InitialContext();
            return (GestionEmployeLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionEmploye!traitement.GestionEmployeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught AffichageAccueil", ne);
            throw new RuntimeException(ne);
        }
    }
}
