package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery (name = "entites.TypeCuisson.getByNom", query = "select g from TypeCuisson g where g.cuisson = :paramNom")
})
public class TypeCuisson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cuisson;
    @ManyToMany(mappedBy = "typeCuissonProduit")
    private Collection<Produit> produits;
    @OneToMany(mappedBy = "typeCuissonLigneCo")
    private Collection<LigneDeCommande>ligneDeCo;

    public TypeCuisson() {
        produits = new ArrayList();
        ligneDeCo = new ArrayList<>();
    }

    public TypeCuisson(String cuisson) {
        this();
        this.cuisson = cuisson;
    }

    public Collection<LigneDeCommande> getLigneDeCo() {
        return ligneDeCo;
    }

    public void setLigneDeCo(Collection<LigneDeCommande> ligneDeCo) {
        this.ligneDeCo = ligneDeCo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuisson() {
        return cuisson;
    }

    public void setCuisson(String cuisson) {
        this.cuisson = cuisson;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return "type de cuisson : " + cuisson;
    }

}
