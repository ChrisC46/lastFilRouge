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
public class AffichageAccueil implements Serializable,SousControleur{
    
    
    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response){
        return "/WEB-INF/accueil.jsp";
    }
    
}
