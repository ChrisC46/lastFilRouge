/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import com.sun.istack.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
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
public class FamilleIngredient implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(nullable = false)
    @Id
    private String ingredientFamille;
    @OneToMany(mappedBy = "familleIngredient")
    private Collection<Ingredients> ingredients;

    public FamilleIngredient() {
        ingredients = new ArrayList();
    }

    public FamilleIngredient(String ingredientFamille) {
        this();
        this.ingredientFamille = ingredientFamille;
    }

    public Collection<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Collection<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    
    public String getIngredientFamille() {
        return ingredientFamille;
    }

    public void setIngredientFamille(String ingredientFamille) {
        this.ingredientFamille = ingredientFamille;
    }
    
    
    
    @Override
    public String toString() {
        return "entites.FamilleIngredient[ " + ingredientFamille + " ]";
    }
    
}
