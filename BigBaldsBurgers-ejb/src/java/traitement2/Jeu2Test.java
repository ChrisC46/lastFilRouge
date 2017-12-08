package traitement2;

import entites.Droits;
import entites.Employe;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author willDev
 */
@Stateful
public class Jeu2Test implements Jeu2TestLocal {

    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;

    @Override
    public void creerDonnees() {
        Employe e01 = new Employe(001, "Ney", "Mar", "0606060606", "neymar@gmail.com", "neymar");
        Employe e02 = new Employe(002, "Cav", "Ani", "0606060607", "cavani@gmail.com", "cavani");
        Employe e03 = new Employe(003, "Mba", "ppé", "0606060608", "mbappe@gmail.com", "mbappe");
        em.persist(e01);
        em.persist(e02);
        em.persist(e03);
        em.flush();

        Droits d01 = new Droits("serveur");
        Droits d02 = new Droits("cuisinier");
        Droits d03 = new Droits("caissier");
        em.persist(d01);
        em.persist(e02);
        em.persist(e03);
        em.flush();

    }

}
