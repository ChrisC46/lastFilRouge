/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Tofi
 */
@Entity
public class Ingredients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private int prix;
    private String origine;
    @ManyToOne
    private Disponibilite disponibilite;
    @ManyToOne
    private FamilleIngredient familleIngredient;
    @ManyToMany(mappedBy = "ingredients")
    private Collection<Produit> produits;

    public Ingredients() {
        produits = new ArrayList();
    }

    public Ingredients(String nom, int prix, String origine) {
        this();
        this.nom = nom;
        this.prix = prix;
        this.origine = origine;
    }

    public String getNomIngredient() {
        return nom;
    }

    public void setNomIngredient(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Disponibilite getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Disponibilite disponibilite) {
        this.disponibilite = disponibilite;
    }

    public FamilleIngredient getFamilleIngredient() {
        return familleIngredient;
    }

    public void setFamilleIngredient(FamilleIngredient familleIngredient) {
        this.familleIngredient = familleIngredient;
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
        return "entites.Ingredients[ id=" + id + " ]";
    }

}
