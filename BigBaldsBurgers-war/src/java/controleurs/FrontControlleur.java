/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import entites.Formule;
import entites.LigneDeCommande;
import entites.LigneDeCommande_;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cdi313
 */
@WebServlet(name = "FrontControlleur", urlPatterns = {"/FrontControlleur"})
public class FrontControlleur extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String section = request.getParameter("section");
        String consulter = request.getParameter("consulter");
        String actionPanier = request.getParameter("panier");
        String nomJsp = "promotions.jsp";
        String url = "/WEB-INF/home.jsp";

        request.setAttribute("lajsp", nomJsp);

        if (section == null) {

        }

        /* DEBUT LIEN POUR ACCUEIL - CHOIX CARTE */
        /* --------------  NIVEAU 1 --------------   */
        if ("serveur".equals(section)) {
            url = "/WEB-INF/accueil.jsp";
        }

        if ("menus".equals(consulter)) {
            nomJsp = "nos-menus.jsp";
            request.setAttribute("lajsp", nomJsp);

        }

        if ("offres".equals(consulter)) {
            nomJsp = "promotions.jsp";
            request.setAttribute("lajsp", nomJsp);
        }
        if ("burgers".equals(consulter)) {
            nomJsp = "burgers.jsp";
            request.setAttribute("lajsp", nomJsp);

        }
        if ("accompagnements".equals(consulter)) {
            nomJsp = "accompagnements.jsp";
            request.setAttribute("lajsp", nomJsp);
        }

        if ("desserts".equals(consulter)) {
            nomJsp = "desserts.jsp";
            request.setAttribute("lajsp", nomJsp);
        }
        if ("boissons".equals(consulter)) {
            nomJsp = "boissons.jsp";
            request.setAttribute("lajsp", nomJsp);
        }
        
        /* --------------  NIVEAU 2 --------------   */
        if ("menu".equals(consulter)) {
            nomJsp = "menu.jsp";
            request.setAttribute("lajsp", nomJsp);

        }

        if ("add".equals(actionPanier)) {

        }

        /* Fin LIEN POUR ACCUEIL - CHOIX CARTE */
        url = response.encodeURL(url);
        request.getRequestDispatcher(url).include(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
