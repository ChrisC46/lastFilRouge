
package controleurs.secondaires;

import entites.Produit;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//public class CommandeAffichageCtrl implements SousControleur{
//    @Override
//    public String executer(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
//        GestionCatalogueLocal gestionCatalogue = lookupGestionCatalogueLocal();
//        List<Produit> lp = gestionCatalogue.findAllProduit();
//        request.setAttribute("produits", lp);
//        String page = "/WEB-INF/catalogue.jsp";
//        return page;
//    }
//    
//}
