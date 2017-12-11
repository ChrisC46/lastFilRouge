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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tofi
 */


@WebServlet(name = "FrontControlleur", urlPatterns = {"/FrontControlleur"})
public class FrontControlleur extends HttpServlet {
     private HashMap<String, SousControleur> mp;

     /*
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
*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String section = request.getParameter("section");

        String consulter = request.getParameter("consulter");
        String actionPanier = request.getParameter("panier");
        String nomJsp = "promotions.jsp";
        String url = "/WEB-INF/home.jsp";

        request.setAttribute("lajsp", nomJsp);

        if (section == null) {
        }

        //String page = "/WEB-INF/home.jsp";
        
        /*
        if (section!= null && mp.containsKey(section)) {
            SousControleur sc = mp.get(section);
            url = sc.executer(request, response);
        }
*/

        /* DEBUT LIEN POUR ACCUEIL - CHOIX CARTE */
        /* --------------  NIVEAU 1 --------------   */
        if ("serveur".equals(section)) {
            url = "/WEB-INF/accueil.jsp";
            System.out.println("TEST");
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
        
        if ("creerJeuDeTest".equals(section)){
            try {
                //jeuDeTest.creerDonnees();
                request.setAttribute("dClasse", "info");
                request.setAttribute("msg", "données créées !");
            } catch (Exception ex){
                ex.printStackTrace();
                request.setAttribute("dClasse", "erreur");
                request.setAttribute("msg", "echec de votre action");
            }
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

