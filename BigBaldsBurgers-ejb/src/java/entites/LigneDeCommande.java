
package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class LigneDeCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int qteCommande;
    private float prixLigneDeCo;

    public LigneDeCommande() {
    }

    public LigneDeCommande(int qteCommande, float prixLigneDeCo) {
        this.qteCommande = qteCommande;
        this.prixLigneDeCo = prixLigneDeCo;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQteCommande() {
        return qteCommande;
    }

    public void setQteCommande(int qteCommande) {
        this.qteCommande = qteCommande;
    }

    public float getPrixLigneDeCo() {
        return prixLigneDeCo;
    }

    public void setPrixLigneDeCo(float prixLigneDeCo) {
        this.prixLigneDeCo = prixLigneDeCo;
    }

 

    @Override
    public String toString() {
        return "qteCommande : " + qteCommande + "prixLigneDeCo : " + prixLigneDeCo;
    }

}
