package controleurs.secondaire;

import entites.Emplacement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import traitement.GestionEmplacementLocal;

public class EmplacementCtrl implements SousControleur {

    @Override
    public String executer(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();

        String page = "/WEB-INF/serveur.jsp";

        GestionEmplacementLocal gestionEmplacement = lookupGestionEmplacementLocal();

        if ("empAll".equals(request.getParameter("spec"))) {
            List<Emplacement> lEmp = gestionEmplacement.allEmplacements();
            request.setAttribute("emplacements", lEmp);
        }
        if ("empDispo".equals(request.getParameter("spec"))) {
            List<Emplacement> lEmpDispo = gestionEmplacement.emplacementDispo();
            request.setAttribute("emplacementDispo", lEmpDispo);
        }
        if ("empOcc".equals(request.getParameter("spec"))) {
            List<Emplacement> lEmpOcc = gestionEmplacement.emplacementOccupe();
            request.setAttribute("emplacementOcc", lEmpOcc);
        }

        System.out.println(page);
        return page;

    }
//        String numEmplacement = request.getParameter("selection");
//        String action = request.getParameter("action");

//        if ("attribuer-emplacement".equals(action)) {
//            try {
//                gestionEmplacement.selectionEmplacement(numEmplacement);
//            } catch (CustomedException ex) {
//                System.out.println("emplacement : " + numEmplacement);
//            }
//        }
    private GestionEmplacementLocal lookupGestionEmplacementLocal() {
        try {
            Context c = new InitialContext();
            return (GestionEmplacementLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionEmplacement!traitement.GestionEmplacementLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
