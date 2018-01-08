
package traitement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import outils.CustomedException;

@Stateless
public class GestionCatalogue implements GestionCatalogueLocal {
    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;

    
    

    
    
    
    
    
    
    
    public void persist(Object object) {
        em.persist(object);
    }

   
    
    
}
