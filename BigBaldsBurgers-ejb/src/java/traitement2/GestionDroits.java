
package traitement2;

import entites.Droits;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateful
public class GestionDroits implements GestionDroitsLocal {

    @PersistenceContext (unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;
    
    @Override
    public List<Droits> findAllDroits() {
        Query qr = em.createNamedQuery("findAll.Droits");
        List<Droits> lp = qr.getResultList();
        return lp;
    }
    
}
