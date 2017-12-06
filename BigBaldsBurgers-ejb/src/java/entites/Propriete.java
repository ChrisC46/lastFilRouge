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
    private String nom;
    private String valeur;
    private String unite;

    public Propriete() {
    }

    public Propriete(String nom, String valeur, String unite) {
        this.nom = nom;
        this.valeur = valeur;
        this.unite = unite;
    }

    public String getNomPropriete() {
        return nom;
    }

    public void setNomPropriete(String nom) {
        this.nom = nom;
    }

    public String getValeurPropriete() {
        return valeur;
    }

    public void setValeurPropriete(String valeur) {
        this.valeur = valeur;
    }

    public String getUnitePropriete() {
        return unite;
    }

    public void setUnitePropriete(String unite) {
        this.unite = unite;
    }
    
    
            
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return "entites.Propriete[ "+nom+" "+valeur+" "+unite+" ]";
    }
    
}
