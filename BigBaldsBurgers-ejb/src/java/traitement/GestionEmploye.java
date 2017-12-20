/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Droits;
import entites.Employe;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import outils.CustomedException;

/**
 *
 * @author cdi317
 */
@Stateless
public class GestionEmploye implements GestionEmployeLocal {
    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;

//    @Override
//    public List<Employe> findAllLoginByDroits(String droit){
//        Query qr = em.createNamedQuery("entites.Droits.getLoginParDroits");
//        qr.setParameter("paramDroits",droit );
//        List<Employe> le = qr.getResultList();
//        return le;
//    }
    
    @Override
    public List<Droits> findDroitsByLogin(String loginE) throws CustomedException{
        
        HashMap<String, String> mp = new HashMap<>();
        if(loginE == null || loginE.trim().isEmpty()){
            mp.put("loginErr", "code obligatoire");
        }else{
            loginE = loginE.trim();
        }
        Query qr = em.createNamedQuery("entites.Droits.getDroitsParLogin");
        qr.setParameter("paramLogin", loginE);
        List<Droits> ld = qr.getResultList();
        return ld;
    }
    
    @Override
    public Boolean isLogin (String loginE, String droit){
        List<Droits> lDroits = findDroitsByLogin(loginE);
        for (Droits d : lDroits){
            if(d.getNom().equals(droit))
                return true;
        }
        return false;
    }
    
//    @Override
//    public Boolean isDroits (String loginE, String droit){
//          List<Employe> lEmp =  findAllLoginByDroits(droit);
//        for (Employe emp : lEmp){
//            if (emp.getLogin().equals(loginE))    
//               return true; 
//            }
//           return false; 
//    }
}
