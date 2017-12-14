/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.CategorieFormule;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi317
 */
@Stateless
public class GestionCategorieCarte implements GestionCategorieCarteLocal {
    
    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;


    @Override
    public List<CategorieFormule> getAllCat() {
        Query qr = em.createNamedQuery("entites.CategorieFormule.AllCat");
        List<CategorieFormule> allCat = qr.getResultList();
        return allCat;
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    
    
}
