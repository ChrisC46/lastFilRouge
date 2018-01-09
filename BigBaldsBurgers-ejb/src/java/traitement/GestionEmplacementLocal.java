/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Emplacement;
import entites.Status;
import java.util.List;
import javax.ejb.Local;
import outils.CustomedException;

/**
 *
 * @author cdi317
 */
@Local
public interface GestionEmplacementLocal {

    public Emplacement selectionEmplacement(String numero) throws CustomedException;

    public List<Emplacement> allEmplacements();

    public List<Emplacement> selectionListeEmplacements(String numero);

    public List<Emplacement> emplacementDispo();

    public List<Emplacement> emplacementOccupe();
    
      public void updateEtat(Emplacement p); 
     
    public Status selectEtatDisponible(); 
     
    public Status selectEtatOccupe(); 
     
    public Status selectEtatANettoyer(); 
     
    public void setEtatDisponible(Emplacement p); 
     
    public void setEtatOccupe(Emplacement p); 
     
    public void setEtatANettoyer(Emplacement p); 

}
