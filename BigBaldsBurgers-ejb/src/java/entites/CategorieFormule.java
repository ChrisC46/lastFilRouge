
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
    @NamedQuery(name = "entites.Categorie", query = "select c from CategorieFormule c ")
})
public class CategorieFormule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(nullable = false)
    private String nom;
    @OneToMany(mappedBy = "categorieFormule")
    private Collection<Formule> formules;
    @OneToMany(mappedBy = "categorieFormuleProduit")
    private Collection<Produit> produits;
    @ManyToMany
    private Collection<Promotion> promotions;
    @ManyToOne
    private Carte carte;

    public CategorieFormule() {
        formules = new ArrayList();
        produits = new ArrayList();
        promotions = new ArrayList();
    }

    public CategorieFormule(String nom) {
        this();
        this.nom = nom;
    }

    public String getNomCF() {
        return nom;
    }

    public void setNomCF(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public Collection<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Collection<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }
    
    @Override
    public String toString() {
        return "entites.CategorieFormule[" + nom + " ]";
    }
    
}
