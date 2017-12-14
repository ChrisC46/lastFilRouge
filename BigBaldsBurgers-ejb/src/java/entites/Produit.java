
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
    @NamedQuery (name = "entites.Produit.getProduitByPropriete", query = "select g from Produit g where g.nom = :paramNom"),
})
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(nullable = false)
    @Id
    private String nom;
    private float prix;
    private String image;
    private String description;
    @ManyToMany
    private Collection<Ingredients> ingredients;
    @ManyToMany
    private Collection<Propriete> proprietes;
    @ManyToOne
    private Tva tva;
    @ManyToOne
    private CategorieProduit categorieProduit;
    @OneToMany(mappedBy = "produit")
    private Collection<LigneDeCommande> ligneDeCommandes;
    @ManyToMany
    private Collection<TypeCuisson> typeCuissonProduit;
    @ManyToMany
    private Collection<Formule> formules;
    @ManyToOne
    private CategorieFormule categorieFormuleProduit;

    public Produit() {
        ingredients = new ArrayList();
        ligneDeCommandes = new ArrayList();
        typeCuissonProduit = new ArrayList();
        formules = new ArrayList();
        proprietes = new ArrayList();
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

    
    public void setTypeCuissonProduit(Collection<TypeCuisson> typeCuissonProduit) {
        this.typeCuissonProduit = typeCuissonProduit;
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

    public Collection<Propriete> getProprietes() {
        return proprietes;
    }

    public void setProprietes(Collection<Propriete> proprietes) {
        this.proprietes = proprietes;
    }

    public CategorieFormule getCategorieFormuleProduit() {
        return categorieFormuleProduit;
    }

    public void setCategorieFormuleProduit(CategorieFormule categorieFormuleProduit) {
        this.categorieFormuleProduit = categorieFormuleProduit;
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

    public Collection<TypeCuisson> getTypeCuissonProduit() {
        return typeCuissonProduit;
    }

    public void setTypeCuisson(Collection<TypeCuisson> typeCuissonProduit) {
        this.typeCuissonProduit = typeCuissonProduit;
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
        return categorieFormuleProduit;
    }

    public void setCategorieFormule(CategorieFormule categorieFormuleProduit) {
        this.categorieFormuleProduit = categorieFormuleProduit;
    }
    
    @Override
    public String toString() {
        return "entites.Produit[ "+nom+" "+prix+"]";
    }
    
}
