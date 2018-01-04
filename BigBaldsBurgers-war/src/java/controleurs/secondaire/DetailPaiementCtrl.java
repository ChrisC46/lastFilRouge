/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs.secondaire;

import entites.LigneDeCommande;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import traitement.GestionPaiementLocal;

/**
 *
 * @author CDI305
 */

public class DetailPaiementCtrl implements SousControleur, Serializable{
@Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("detailPaiementCtrl");
        GestionPaiementLocal gestionPaiement = lookupGestionPaiementLocal();
        List<LigneDeCommande> listDetailCommande = gestionPaiement.detailCommandeByEmplacement(request.getParameter("numTable"));
        System.out.println("detail d'une commande :"+listDetailCommande);
        request.setAttribute("lDetail", listDetailCommande);
        
        String page = "/WEB-INF/caisse.jsp";
        return page;
    }
    
    private GestionPaiementLocal lookupGestionPaiementLocal() {
        try {
            Context c = new InitialContext();
            return (GestionPaiementLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionPaiement!traitement.GestionPaiementLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught PaiementCtrl", ne);
            throw new RuntimeException(ne);
        }
    }
    
}

