package traitement;

import entites.LigneDeCommande;
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
    public List<LigneDeCommande> listeCommandesCuisine() {
        Query qr = em.createNamedQuery("CommandesCuisine");
        List<LigneDeCommande> listeCommandes = qr.getResultList();
        return listeCommandes;
    }

    @Override
    public List<LigneDeCommande> listeCommandesCuisineTransmise() {
        Query qr = em.createNamedQuery("CommandesCuisineTransmise");
        List<LigneDeCommande> listeCommandes = qr.getResultList();
        return listeCommandes;
    }

    @Override
    public List<LigneDeCommande> listeCommandesCuisineEnPrepa() {
        Query qr = em.createNamedQuery("CommandesCuisineEnPrepa");
        List<LigneDeCommande> listeCommandes = qr.getResultList();
        return listeCommandes;
    }

    @Override
    public List<LigneDeCommande> listeCommandesCuisineEnPrete() {
        Query qr = em.createNamedQuery("CommandesCuisineprete");
        List<LigneDeCommande> listeCommandes = qr.getResultList();
        return listeCommandes;
    }

}
