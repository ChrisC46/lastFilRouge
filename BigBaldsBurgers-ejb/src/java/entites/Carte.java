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
public class Carte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;

    public Carte() {
    }

    public Carte(String nom) {
        this.nom = nom;
    }

    public String getNomCarte() {
        return nom;
    }

    public void setNomCarte(String nom) {
        this.nom = nom;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  

    @Override
    public String toString() {
        return "entites.Carte[ " + nom + " ]";
    }
    
}
