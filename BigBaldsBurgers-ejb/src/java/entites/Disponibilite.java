/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Tofi
 */
@Entity
public class Disponibilite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean dispo;
    @OneToMany(mappedBy = "disponibilite")
    private Collection<Ingredients> ingredients;

    public Disponibilite() {
        ingredients = new ArrayList<>();
    }

    public Disponibilite(boolean dispo) {
        this();
        this.dispo = dispo;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public Collection<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "entites.Disponibilite[ id=" + dispo + " ]";
    }

}
