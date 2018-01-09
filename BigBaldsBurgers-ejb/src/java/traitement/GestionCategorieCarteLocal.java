/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.CategorieFormule;
import entites.Formule;
import entites.Ingredients;
import entites.Produit;
import entites.Propriete;
import entites.Specification;
import entites.TypeCuisson;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi317
 */
@Local
public interface GestionCategorieCarteLocal {
    
     public List<CategorieFormule> getAllCat();
     public List<Produit> getProduitByProP(String nomPropriete);
     public Produit getProdById(String id);
     public List<Formule> getAllFormule();
     public Formule getFormuleById(String id);
     public List<Produit> getProduitByFormule(String nomCategorie, String nomFormule);
     public List<Produit> getBoissonByFormule(String nomCategorie, String nomFormule);
     public List<Propriete> getProprieteByProd(String id);
     public Specification getSpecificationByID(Long id);
     public List<Ingredients> getIngredientsByProd(String id);
     public TypeCuisson getCuissonByNom(String typeCuisson);

   
}
