package traitement;

import entites.Emplacement;
import entites.Status;
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
    
    @Override 
    public void updateEtat(Emplacement p) { 
        em.merge(p); 
    } 
 
    @Override 
    public Status selectEtatDisponible() { 
        return new Status("table disponible"); 
    } 
 
    @Override 
    public Status selectEtatOccupe() { 
        return new Status("table non disponible"); 
    } 
 
    @Override 
    public Status selectEtatANettoyer() { 
        return new Status("table à debarasser"); 
    } 
 
    @Override 
    public void setEtatDisponible(Emplacement p) { 
        p.setDispoTable(selectEtatDisponible()); 
        updateEtat(p); 
    } 
 
    @Override 
    public void setEtatOccupe(Emplacement p) { 
        p.setDispoTable(selectEtatOccupe()); 
        updateEtat(p); 
    } 
 
    @Override 
    public void setEtatANettoyer(Emplacement p) { 
        p.setDispoTable(selectEtatANettoyer()); 
        updateEtat(p); 
    } 
}
