
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Formule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private float prix;
    private String image;
    @ManyToMany(mappedBy = "formules")
    private Collection<Produit> produits;
    @OneToMany(mappedBy = "formule")
    private Collection<LigneDeCommande> ligneDeCommandes;
    @ManyToOne
    private Tva tva;
    @ManyToOne
    private CategorieFormule categorieFormule;
    
    public Formule() {
        produits = new ArrayList();
        ligneDeCommandes = new ArrayList();
    }

    public Formule(String nom, String description, float prix, String image) {
        this();
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.image = image;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public Collection<LigneDeCommande> getLigneDeCommandes() {
        return ligneDeCommandes;
    }

    public void setLigneDeCommandes(Collection<LigneDeCommande> ligneDeCommandes) {
        this.ligneDeCommandes = ligneDeCommandes;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public CategorieFormule getCategorieFormule() {
        return categorieFormule;
    }

    public void setCategorieFormule(CategorieFormule categorieFormule) {
        this.categorieFormule = categorieFormule;
    }
    

    @Override
    public String toString() {
        return "entites.Formule[ nom de la formule= " + nom +  " ]";
    }
    
}
