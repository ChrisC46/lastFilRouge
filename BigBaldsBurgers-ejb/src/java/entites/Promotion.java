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
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float remise;
    private Date dateDebutPromo;
    private Date dateFinPromo;

    public Promotion() {
    }

    public Promotion(float remise, Date dateDebutPromo, Date dateFinPromo) {
        this.remise = remise;
        this.dateDebutPromo = dateDebutPromo;
        this.dateFinPromo = dateFinPromo;
    }

    public float getRemise() {
        return remise;
    }

    public void setRemise(float remise) {
        this.remise = remise;
    }

    public Date getDateDebutPromo() {
        return dateDebutPromo;
    }

    public void setDateDebutPromo(Date dateDebutPromo) {
        this.dateDebutPromo = dateDebutPromo;
    }

    public Date getDateFinPromo() {
        return dateFinPromo;
    }

    public void setDateFinPromo(Date dateFinPromo) {
        this.dateFinPromo = dateFinPromo;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    @Override
    public String toString() {
        return "entites.Promotion[ remise" + remise + " ]";
    }
    
}
