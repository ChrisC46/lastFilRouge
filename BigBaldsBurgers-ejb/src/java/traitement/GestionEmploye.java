/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Employe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi317
 */
@Stateless
public class GestionEmploye implements GestionEmployeLocal {
    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;

    @Override
    public List<Employe> findAllLoginByDroits(String droit){
        Query qr = em.createNamedQuery("entites.Droits.getLoginParDroits");
        qr.setParameter("paramDroits",droit );
        List<Employe> le = qr.getResultList();
        return le;
    }
    
    @Override
    public Boolean isLogin (String loginE, String droit){
          List<Employe> lEmp =  findAllLoginByDroits(droit);
        for (Employe emp : lEmp){
            if (emp.getLogin().equals(loginE))    
               return true; 
            }
           return false; 
    }
}
