
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float remise;
    private Date dateDebutPromo;
    private Date dateFinPromo;
    @ManyToMany(mappedBy = "promotions")
    private Collection<CategorieFormule> categorieFormule;

    public Promotion() {
        categorieFormule = new ArrayList();
    }

    public Promotion(float remise, Date dateDebutPromo, Date dateFinPromo) {
        this();
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

    public Collection<CategorieFormule> getCategorieFormule() {
        return categorieFormule;
    }

    public void setCategorieFormule(Collection<CategorieFormule> categorieFormule) {
        this.categorieFormule = categorieFormule;
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
