
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class LigneDeCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int qteCommande;
    private float prixLigneDeCo;
    
    @ManyToOne
    private Status suiviCuisine;
    @ManyToOne
    private Commande commande;
    @OneToMany
    private Collection<Specification>commentSpec;

    public LigneDeCommande() {
        commentSpec = new ArrayList<>();
    }

    public LigneDeCommande(int qteCommande, float prixLigneDeCo) {
        this();
        this.qteCommande = qteCommande;
        this.prixLigneDeCo = prixLigneDeCo;
    }

    public Collection<Specification> getCommentSpec() {
        return commentSpec;
    }

    public void setCommentSpec(Collection<Specification> commentSpec) {
        this.commentSpec = commentSpec;
    }

    
    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Status getSuiviCuisine() {
        return suiviCuisine;
    }

    public void setSuiviCuisine(Status suiviCuisine) {
        this.suiviCuisine = suiviCuisine;
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
