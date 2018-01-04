/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.secondaire;

import entites.Tva;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import traitement.GestionTvaLocal;


public class TvaCtrl implements SousControleur, Serializable{

    
    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        GestionTvaLocal gestionTva = lookupGestionTvaLocal();
        List<Tva> lTva = gestionTva.findTVA();
        request.setAttribute("lTva", lTva);
        String page = "/WEB-INF/caisse.jsp";
        
        return page;
    }
    
   

    private GestionTvaLocal lookupGestionTvaLocal() {
        try {
            Context c = new InitialContext();
            return (GestionTvaLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionTva!traitement.GestionTvaLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught PaiementCtrl", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
