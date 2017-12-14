
package controleurs.secondaire;

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
import traitement.GestionCatalogueLocal;
import traitement.JeuDeTestLocal;


public class Catalogue implements Serializable, SousControleur {

    
   @Override
   public String executer(HttpServletRequest request, HttpServletResponse response) {
      
       
       try {
               
           } catch (Exception ex) {
               ex.printStackTrace();
               request.setAttribute("dClasse", "erreur");
               request.setAttribute("msg", "echec chargement du catalogue");
           }

           return"/WEB-INF/home.jsp";
   
   }

   private GestionCatalogueLocal lookupGestionCatalogueLocal() {
       try {
           Context c = new InitialContext();
           return (GestionCatalogueLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionCatalogue!traitement.GestionCatalogueLocal");
       } catch (NamingException ne) {
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
           throw new RuntimeException(ne);
       }
   }
}
