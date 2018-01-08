
package traitement;

import entites.LigneDeCommande;
import entites.Produit;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateful
public class GestionCuisine implements GestionCuisineLocal {

        @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;
        
        @Override
    public List<LigneDeCommande> listeProduitsCuisine() {
        Query qr = em.createNamedQuery("listePlatsCuisine");
        List<LigneDeCommande> lisProCui = qr.getResultList();
        return lisProCui;
    }

}
