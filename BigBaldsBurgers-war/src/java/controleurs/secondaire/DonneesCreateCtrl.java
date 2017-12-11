package controleurs.secondaire;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import traitement.JeuDeTestLocal;


public class DonneesCreateCtrl implements Serializable, SousControleur{
   

   @Override
   public String executer(HttpServletRequest request, HttpServletResponse response) {
       JeuDeTestLocal jeuDeTest = lookupJeuDeTestLocal();
       try {
               jeuDeTest.creerDonnees();
               request.setAttribute("dClasse", "info");
               request.setAttribute("msg", "données créées!");
           } catch (Exception ex) {
               ex.printStackTrace();
               request.setAttribute("dClasse", "erreur");
               request.setAttribute("msg", "echec de votre action");
           }

           return"/WEB-INF/home.jsp";
   
   }

   private JeuDeTestLocal lookupJeuDeTestLocal() {
       try {
           Context c = new InitialContext();
           return (JeuDeTestLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/JeuDeTest!traitement.JeuDeTestLocal");
       } catch (NamingException ne) {
           Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
           throw new RuntimeException(ne);
       }
   }
   
}