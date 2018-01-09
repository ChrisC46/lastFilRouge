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
    public List<Emplacement> selectionListeEmplacements(String numero) {
        Query qr = em.createNamedQuery("rechercheEmplacements");
        qr.setParameter("empNumero", numero);
        List<Emplacement> lEmp = qr.getResultList();
        return lEmp;
    }

    @Override
    public List<Emplacement> allEmplacements() {
        Query qr = em.createNamedQuery("rechercheAllEmplacements");
        List<Emplacement> lEmp = qr.getResultList();
        return lEmp;
    }
   
    @Override
    public List<Emplacement> emplacementDispo() {
        Query qr = em.createNamedQuery("rechercheEmplacementDispo");
        List<Emplacement> listEmpDispo = qr.getResultList();
        return listEmpDispo;
    }
    
    @Override
    public List<Emplacement> emplacementOccupe() {
        Query qr = em.createNamedQuery("rechercheEmplacementOccupe");
        List<Emplacement> listEmpOccu = qr.getResultList();
        return listEmpOccu;
    }
}
