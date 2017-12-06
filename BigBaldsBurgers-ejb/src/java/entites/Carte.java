
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @OneToMany(mappedBy = "carte")
    private Collection<CategorieFormule> categorieFormule;

    public Carte() {
        categorieFormule = new ArrayList();
    }

    public Carte(String nom) {
        this.nom = nom;
    }

    public String getNomCarte() {
        return nom;
    }

    public void setNomCarte(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<CategorieFormule> getCategorieFormule() {
        return categorieFormule;
    }

    public void setCategorieFormule(Collection<CategorieFormule> categorieFormule) {
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
        return "entites.Carte[ " + nom + " ]";
    }
    
}
