/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import controleurs.secondaire.SousControleur;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tofi
 */
public class FrontControlleur extends HttpServlet {
     private HashMap<String, SousControleur> mp;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.        
        mp = new HashMap<>();
//        mp.put("catalogue-affichage", new CatalogueAffichageCtrl());
//        mp.put("operations-panier", new OperationsPanierCtrl());
        Enumeration<String> noms = config.getInitParameterNames();
        while(noms.hasMoreElements()){
            String nom = noms.nextElement();
            String valeur = config.getInitParameter(nom);
            try {
                SousControleur sc = (SousControleur) Class.forName(valeur).newInstance();
                mp.put(nom, sc);
            } catch (ClassNotFoundException ex) {
                
            } catch (InstantiationException ex) {
            
            } catch (IllegalAccessException ex) {
            
            }
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String section = request.getParameter("section");
        String page = "/WEB-INF/home.jsp";

        if (section!= null && mp.containsKey(section)) {
            SousControleur sc = mp.get(section);
            page = sc.executer(request, response);
        }
 
        page = response.encodeURL(page);
        //System.out.println(">>>>>>>>>>>>> page = "+page);
        Boolean ok = (Boolean) request.getAttribute("redirect");
        if(ok != null && ok){
            response.sendRedirect(page);
        }else{
            getServletContext().getRequestDispatcher(page).include(request, response);
        }
    }

}
