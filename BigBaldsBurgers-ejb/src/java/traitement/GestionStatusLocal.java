/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Status;
import javax.ejb.Local;

/**
 *
 * @author cdi317
 */
@Local
public interface GestionStatusLocal {
        public Status statusEmplacment(String nom);
    
}
