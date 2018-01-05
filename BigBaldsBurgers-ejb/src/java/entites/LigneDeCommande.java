
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
@NamedQuery(name = "entites.LigneDeCommande.detailCommandeByEmplacement", query = "select lc from LigneDeCommande lc, lc.formule.tva ftva, lc.produit.tva ptva, lc.commande.numTable num where num.numero= :paramNumEmplacement")
})
public class LigneDeCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int qteCommande;
    private float prixLigneDeCo;
    
    @ManyToOne
    private Status suiviCuisine;
    @ManyToOne
    private Commande commande;
    @OneToMany
    private Collection<Specification>commentSpec;
    @ManyToOne
    private CategorieProduit categorieProduit;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private Formule formule;
    @ManyToOne
    private TypeCuisson typeCuissonLigneCo;
    @OneToMany
    private Collection<LigneDeCommande> sousLigneDeCo;
    public LigneDeCommande() {
        commentSpec = new ArrayList<>();
        sousLigneDeCo = new ArrayList<>();
        
    }
 public LigneDeCommande(Produit p) throws IllegalArgumentException {
        if (produit != null) {
            this.produit = produit;
            qteCommande = 1;
        } else {
            throw new IllegalArgumentException("le produit est null!!!");
        }
    }
 
    public LigneDeCommande(int qteCommande, float prixLigneDeCo) {
        this();
        this.qteCommande = qteCommande;
        this.prixLigneDeCo = prixLigneDeCo;
    }

    public TypeCuisson getTypeCuissonLigneCo() {
        return typeCuissonLigneCo;
    }

    public void setTypeCuissonLigneCo(TypeCuisson typeCuissonLigneCo) {
        this.typeCuissonLigneCo = typeCuissonLigneCo;
    }

    public Collection<LigneDeCommande> getSousLigneDeCo() {
        return sousLigneDeCo;
    }

    public void setSousLigneDeCo(Collection<LigneDeCommande> sousLigneDeCo) {
        this.sousLigneDeCo = sousLigneDeCo;
    }

    public Collection<Specification> getCommentSpec() {
        return commentSpec;
    }

    public void setCommentSpec(Collection<Specification> commentSpec) {
        this.commentSpec = commentSpec;
    }

    
    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Status getSuiviCuisine() {
        return suiviCuisine;
    }

    public void setSuiviCuisine(Status suiviCuisine) {
        this.suiviCuisine = suiviCuisine;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQteCommande() {
        return qteCommande;
    }

    public void setQteCommande(int qteCommande) {
        this.qteCommande = qteCommande;
    }

    public float getPrixLigneDeCo() {
        return prixLigneDeCo;
    }

    public Formule getFormule() {
        return formule;
    }

    public void setFormule(Formule formule) {
        this.formule = formule;
    }

    public void setPrixLigneDeCo(float prixLigneDeCo) {
        this.prixLigneDeCo = prixLigneDeCo;
    }

    public CategorieProduit getCategorieProduit() {
        return categorieProduit;
    }

    public void setCategorieProduit(CategorieProduit categorieProduit) {
        this.categorieProduit = categorieProduit;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

 

    @Override
    public String toString() {
        return "qteCommande : " + qteCommande + "prixLigneDeCo : " + prixLigneDeCo;
    }

}
