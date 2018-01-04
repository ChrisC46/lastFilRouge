/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Status;
import entites.Tva;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CDI305
 */
@Stateless
public class GestionTva implements GestionTvaLocal {

  @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;
  
  @Override
  public List<Tva> findTVA(){
      Query qr = em.createNamedQuery("entites.Tva.findTVA");
     List<Tva> listTva = qr.getResultList();
     return listTva;
  }
  
  
}
