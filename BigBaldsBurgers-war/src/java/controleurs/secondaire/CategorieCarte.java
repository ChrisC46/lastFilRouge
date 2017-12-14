/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.secondaire;

import entites.CategorieFormule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import traitement.GestionCategorieCarteLocal;


public class CategorieCarte implements Serializable, SousControleur  {

   @Override
   public String executer(HttpServletRequest request, HttpServletResponse response) {
      
       GestionCategorieCarteLocal carte = lookupGestionCategorieCarteLocal();
       
       try {
            request.setAttribute("categorieCarte", carte.getAllCat());
            request.setAttribute("msg", "chargement de la liste des categories du catalogue OK");
           } catch (Exception ex) {
               ex.printStackTrace();
               request.setAttribute("dClasse", "erreur");
               request.setAttribute("msg", "echec chargement des categories du catalogue");
           }

           return"/WEB-INF/home.jsp";
   
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
