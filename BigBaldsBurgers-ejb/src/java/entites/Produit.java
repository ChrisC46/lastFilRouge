
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    private float prix;
    private String image;
    private String description;
    @ManyToMany
    private Collection<Ingredients> ingredients;
    @ManyToOne
    private Propriete propriete;
    @ManyToOne
    private Tva tva;
    @ManyToOne
    private CategorieProduit categorieProduit;
    @OneToMany(mappedBy = "produit")
    private Collection<LigneDeCommande> ligneDeCommandes;
    @ManyToMany
    private Collection<TypeCuisson> typeCuisson;
    @ManyToMany
    private Collection<Formule> formules;
    @ManyToOne
    private CategorieFormule categorieFormule;

    public Produit() {
        ingredients = new ArrayList();
        ligneDeCommandes = new ArrayList();
        typeCuisson = new ArrayList();
        formules = new ArrayList();
    }

    public Produit(String nom, float prix, String image, String description) {
        this();
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.description = description;
    }

    public String getNomProduit() {
        return nom;
    }

    public void setNomProduit(String nom) {
        this.nom = nom;
    }

    public float getPrixProduit() {
        return prix;
    }

    public void setPrixProduit(float prix) {
        this.prix = prix;
    }

    public String getImageProduit() {
        return image;
    }

    public void setImageProduit(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Propriete getPropriete() {
        return propriete;
    }

    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }

    public CategorieProduit getCategorieProduit() {
        return categorieProduit;
    }

    public void setCategorieProduit(CategorieProduit categorieProduit) {
        this.categorieProduit = categorieProduit;
    }

    public String getNom() {
        return nom;
    }

    public Collection<Formule> getFormules() {
        return formules;
    }

    public void setFormules(Collection<Formule> formules) {
        this.formules = formules;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public Collection<TypeCuisson> getTypeCuisson() {
        return typeCuisson;
    }

    public void setTypeCuisson(Collection<TypeCuisson> typeCuisson) {
        this.typeCuisson = typeCuisson;
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

    public Collection<LigneDeCommande> getLigneDeCommandes() {
        return ligneDeCommandes;
    }

    public void setLigneDeCommandes(Collection<LigneDeCommande> ligneDeCommandes) {
        this.ligneDeCommandes = ligneDeCommandes;
    }

    public Collection<Ingredients> getIngredients() {
        return ingredients;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public void setIngredients(Collection<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public CategorieFormule getCategorieFormule() {
        return categorieFormule;
    }

    public void setCategorieFormule(CategorieFormule categorieFormule) {
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
        return "entites.Produit[ "+nom+" "+prix+"]";
    }
    
}
