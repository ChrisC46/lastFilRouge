
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@NamedQueries({
    @NamedQuery (name = "entites.Propriete.getProprieteParNom", query = "select g from Propriete g where g.nom = :paramNom"),
    @NamedQuery (name = "entites.Propriete.getAllProptiete", query = "select g from Propriete g "),
    @NamedQuery (name = "entites.Propriete.getByProd", query = "select g from Propriete g join g.produits p where p.nom = :paramNom") 
})
public class Propriete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String valeur;
    @Column(nullable = false)
    private String unite;
    @ManyToMany(mappedBy = "proprietes")
    private Collection<Produit> produits;

    public Propriete() {
        produits = new ArrayList();
    }

    public Propriete(String nom, String valeur, String unite) {
        this();
        this.nom = nom;
        this.valeur = valeur;
        this.unite = unite;
    }

    public String getNomPropriete() {
        return nom;
    }

    public void setNomPropriete(String nom) {
        this.nom = nom;
    }

    public String getValeurPropriete() {
        return valeur;
    }

    public void setValeurPropriete(String valeur) {
        this.valeur = valeur;
    }

    public String getUnitePropriete() {
        return unite;
    }

    public void setUnitePropriete(String unite) {
        this.unite = unite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
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
        return " "+valeur+" "+unite;
    }
    
}
