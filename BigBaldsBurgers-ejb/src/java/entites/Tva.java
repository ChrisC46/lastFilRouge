/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tofi
 */
@Entity
public class Tva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private float taux;
    private Date date;

    public Tva() {
    }

    public Tva(String nom, float taux, Date date) {
        this.nom = nom;
        this.taux = taux;
        this.date = date;
    }

    public String getNomTva() {
        return nom;
    }

    public void setNomTva(String nom) {
        this.nom = nom;
    }

    public float getTauxTva() {
        return taux;
    }

    public void setTauxTva(float taux) {
        this.taux = taux;
    }

    public Date getDateTva() {
        return date;
    }

    public void setDateTva(Date date) {
        this.date = date;
    }
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    @Override
    public String toString() {
        return "entites.Tva[ taux TVA=" + taux+ " ]";
    }
    
}
