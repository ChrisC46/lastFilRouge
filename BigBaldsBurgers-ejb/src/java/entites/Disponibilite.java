/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tofi
 */
@Entity
public class Disponibilite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private boolean dispo;
    

    @Override
    public String toString() {
        return "entites.Disponibilite[ id=" + dispo + " ]";
    }
    
}
