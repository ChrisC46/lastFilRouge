
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries({
@NamedQuery(name = "entites.Tva.findTVA",query = "select t from Tva t"),
@NamedQuery(name = "entites.Tva.findTVABy",query = "select t.taux from Tva t where t.nom = :paramNom" )
})
public class Tva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column (nullable = false)
    private float taux;
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(mappedBy = "tva")
    private Collection<Formule> formules;
    @OneToMany(mappedBy = "tva")
    private Collection<Produit> produits;

    public Tva() {
        formules = new ArrayList();
        produits = new ArrayList();
    }

    public Tva(String nom, float taux, Date date) {
        this();
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<Formule> getFormules() {
        return formules;
    }

    public void setFormules(Collection<Formule> formules) {
        this.formules = formules;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
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
