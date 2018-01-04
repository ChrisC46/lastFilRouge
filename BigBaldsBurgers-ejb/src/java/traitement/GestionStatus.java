package traitement;

import entites.Status;
import java.util.List;
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

    @Override
    public Status statusEmplacements() {
        Query qr = em.createNamedQuery("status");
        Status status = (Status) qr.getSingleResult();
        return status;
    }
    
    @Override
    public List<Status> satusAllEmplacements() {
     Query qr = em.createNamedQuery("statusAllEmp");
     List<Status> liststatus = qr.getResultList();
     return liststatus;
    }

}
