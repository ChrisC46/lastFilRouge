package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategorieProduit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nom;
    @OneToMany(mappedBy = "categorieProduit")
    private Collection<Produit> produits;
    @OneToMany(mappedBy = "categorieProduit")
    private Collection<LigneDeCommande> ligneDeCommandes;

    public CategorieProduit() {
        produits = new ArrayList();
        ligneDeCommandes = new ArrayList();
    }

    public CategorieProduit(String nom) {
        this();
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public Collection<LigneDeCommande> getLigneDeCommandes() {
        return ligneDeCommandes;
    }

    public void setLigneDeCommandes(Collection<LigneDeCommande> ligneDeCommandes) {
        this.ligneDeCommandes = ligneDeCommandes;
    }
    

    @Override
    public String toString() {
        return "entites.CategorieProduit = "+ nom;
    }

}
