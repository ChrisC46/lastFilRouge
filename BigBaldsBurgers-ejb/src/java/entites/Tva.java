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
    private String nomTva;
    private float tauxTva;
    private Date dateTva;

    public Tva() {
    }

    public Tva(String nomTva, float tauxTva, Date dateTva) {
        this.nomTva = nomTva;
        this.tauxTva = tauxTva;
        this.dateTva = dateTva;
    }

    public String getNomTva() {
        return nomTva;
    }

    public void setNomTva(String nomTva) {
        this.nomTva = nomTva;
    }

    public float getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(float tauxTva) {
        this.tauxTva = tauxTva;
    }

    public Date getDateTva() {
        return dateTva;
    }

    public void setDateTva(Date dateTva) {
        this.dateTva = dateTva;
    }
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    @Override
    public String toString() {
        return "entites.Tva[ id=" + id + " ]";
    }
    
}
