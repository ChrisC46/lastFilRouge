
package traitement;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import entites.Emplacement;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import outils.CustomedException;

@Stateless
public class GestionEmplacement implements GestionEmplacementLocal {

    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;

    @Override
    public Emplacement selectionEmplacement(String numero) throws CustomedException {
        try {
            Emplacement numeroEmplacement = em.find(Emplacement.class, numero);
            return numeroEmplacement;
        } catch (IllegalArgumentException ex) {
            CustomedException ce = new CustomedException("emplacement introuvable");
            ce.setStackTrace(CustomedException.SQL_ERR);
            throw ce;
        }
    }

    @Override
    public List<Emplacement> selectionListeEmplacements(string numero) {
        Query qr = em.createNamedQuery("rechercheEmplacements");
        qr.setParameter("empNumero", numero);
        List<Emplacement> lEmp = qr.getResultList();
        return lEmp;
    }

}
