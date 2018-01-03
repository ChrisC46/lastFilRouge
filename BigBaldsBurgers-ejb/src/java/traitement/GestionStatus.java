package traitement;

import entites.Status;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GestionStatus implements GestionStatusLocal {

    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;

    @Override
    public Status statusEmplacment(String nom) {
        Query qr = em.createNamedQuery("statusEmp");
        qr.setParameter("typeStatus", nom);
        Status status = (Status) qr.getSingleResult();
        return status;
    }
    
}
