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
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String definition;

    @OneToMany(mappedBy = "suiviCommande")
    private Collection<Commande> commande;
    @OneToMany(mappedBy = "dispoTable")
    private Collection<Emplacement> occupationTable;
    @OneToMany(mappedBy = "suiviCuisine")
    private Collection<LigneDeCommande> produitCommande;
    
    
    public Status() {
        commande = new ArrayList<>();
        occupationTable = new ArrayList<>();
        produitCommande = new ArrayList<>();
    }

    public Status(String nom) {
        this();
        this.nom = nom;
    }

    public Status(String nom, String definition) {
        this();
        this.nom = nom;
        this.definition = definition;
    }

    public Collection<LigneDeCommande> getProduitCommande() {
        return produitCommande;
    }

    public void setProduitCommande(Collection<LigneDeCommande> produitCommande) {
        this.produitCommande = produitCommande;
    }

    public Collection<Emplacement> getOccupationTable() {
        return occupationTable;
    }

    public void setOccupationTable(Collection<Emplacement> occupationTable) {
        this.occupationTable = occupationTable;
    }

    public Collection<Commande> getCommande() {
        return commande;
    }

    public void setCommande(Collection<Commande> commande) {
        this.commande = commande;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "nomStatus : " + nom;
    }

}
