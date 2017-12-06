/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tofi
 */
@Entity
public class Propriete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomPropriete;
    private String valeurPropriete;
    private String unitePropriete;

    public Propriete() {
    }

    public Propriete(String nomPropriete, String valeurPropriete, String unitePropriete) {
        this.nomPropriete = nomPropriete;
        this.valeurPropriete = valeurPropriete;
        this.unitePropriete = unitePropriete;
    }

    public String getNomPropriete() {
        return nomPropriete;
    }

    public void setNomPropriete(String nomPropriete) {
        this.nomPropriete = nomPropriete;
    }

    public String getValeurPropriete() {
        return valeurPropriete;
    }

    public void setValeurPropriete(String valeurPropriete) {
        this.valeurPropriete = valeurPropriete;
    }

    public String getUnitePropriete() {
        return unitePropriete;
    }

    public void setUnitePropriete(String unitePropriete) {
        this.unitePropriete = unitePropriete;
    }
    
    
            
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return "entites.Propriete[ "+nomPropriete+" "+valeurPropriete+" "+unitePropriete+" ]";
    }
    
}
