
package traitement;

import entites.Droits;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import outils.CustomedException;


@Stateless
public class GestionEmploye implements GestionEmployeLocal {
    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;

   
    @Override
    public List<Droits> findDroitsByLogin(String loginE) throws CustomedException{
        
        HashMap<String, String> mp = new HashMap<>();
        if(loginE == null || loginE.trim().isEmpty()){
            mp.put("loginERR", "login obligatoire");
            System.out.println("login vide");
        }else{
            String reg = "^[0-9]+$";
            if(!loginE.matches(reg)){
                mp.put("loginERR","login invalide");
            }
            
        }
        Query qr = em.createNamedQuery("entites.Droits.getDroitsParLogin");
        qr.setParameter("paramLogin", loginE);
        List<Droits> ld = qr.getResultList();
        return ld;
    }
    
    @Override
    public Boolean isLogin (String loginE, String droit)throws CustomedException{
        List<Droits> lDroits = findDroitsByLogin(loginE);
        for (Droits d : lDroits){
            if(d.getNom().equals(droit))
                return true;
        }
        return false;
    }
  
}
