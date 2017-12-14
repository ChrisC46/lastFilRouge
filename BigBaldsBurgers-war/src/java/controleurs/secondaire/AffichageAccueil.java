/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.secondaire;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tofi
 */
public class AffichageAccueil implements Serializable, SousControleur {

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (request.getParameter("choixAccueil") != null) {
                if (request.getParameter("choixAccueil").equals("serveur")) {

                }
                if (request.getParameter("choixAccueil").equals("client")) {

                }
                if (request.getParameter("choixAccueil").equals("cuisine")) {

                }
                if (request.getParameter("choixAccueil").equals("caisse")) {

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("dClasse", "erreur");
            request.setAttribute("msg", "echec de votre action");
        }
        return "/WEB-INF/accueil.jsp";
    }

}
