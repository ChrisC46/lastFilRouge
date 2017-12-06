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

    @Override
    public String toString() {
        return "entites.Disponibilite[ id=" + dispo + " ]";
    }

}
