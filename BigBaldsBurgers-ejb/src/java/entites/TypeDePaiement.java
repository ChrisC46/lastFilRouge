package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TypeDePaiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @ManyToMany(mappedBy = "typePaiements")
    private Collection<Paiement> paiements;

    public TypeDePaiement() {
        paiements = new ArrayList<>();
    }

    public TypeDePaiement(String nom) {
        this();
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Paiement> getPaiments() {
        return paiements;
    }

    public void setPaiments(Collection<Paiement> paiments) {
        this.paiements = paiments;
    }
    

    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TypePaiment : " + nom;
    }

}
