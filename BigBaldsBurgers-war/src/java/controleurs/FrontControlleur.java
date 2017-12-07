/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import entites.Formule;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String url = "/WEB-INF/home.jsp";
        String section = request.getParameter("section");
        String consulter = request.getParameter("consulter");
        
       if(section == null){
                
            }
        if(section.equals("serveur")){
            url = "/WEB-INF/accueil.jsp";
        } 
        
      if("menus".equals(consulter)){
          ArrayList<Formule> maListe = new ArrayList<>();
         Formule f01 = new Formule("A", "menu A", 15f, "img");
         Formule f02 = new Formule("B", "menu B", 30f, "img");
          maListe.add(f01);
          maListe.add(f02);
          request.setAttribute("collection", maListe);
          System.out.println("test");
      }
        
        
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


