/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Commande;
import entites.LigneDeCommande;
import entites.Produit;
import java.util.Collection;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tofi
 */
@Stateful
public class GestionCommande implements GestionCommandeLocal {

    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU")
    private EntityManager em;
    
 
    
    private HashMap<String, LigneDeCommande> panier;
    
    @PostConstruct
    public void init(){        
        panier = new HashMap<>();
    }
    
    @Override
    public void ajouter(String reference){
        if(reference != null){
            reference = reference.trim();
        }
        
        if(panier.containsKey(reference)){
            LigneDeCommande lp = panier.get(reference);
            
            int newQte = lp.getQteCommande() + 1;
            if(newQte > lp.getProduit().getQteCommande()){
                newQte = lp.getProduit().getQteCommande();
            }
            lp.setQteCommande(newQte);
        }else{
            Produit p = em.find(Produit.class, reference);
            try{
                LigneDeCommande nlp = new LigneDeCommande(p);
                panier.put(reference, nlp);
            }catch(IllegalArgumentException ex){
               
            }
        }
    }
    
   
    @Override
    public void dec(String reference){
        LigneDeCommande lp = panier.get(reference);
        if(lp.getQteCommande()>1){
            reference = reference.trim();
        
       
            
            int newQte = lp.getQteCommande() - 1;
            
            lp.setQteCommande(newQte);
        }}
           
    
    
    
    
    @Override
    public void del(String reference){ 
        this.panier.remove(reference);
    }
    
    @Override
    public Collection<LigneDeCommande> getListe(){
        return panier.values();
    }
    
    @Override
    public int getNombreProduit(){
        int somme = 0;
        for(LigneDeCommande lp : panier.values()){
            somme += lp.getQteCommande();
        }
        return somme;
    }
    
    
}
   
    


