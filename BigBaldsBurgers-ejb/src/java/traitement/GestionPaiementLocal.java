/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Commande;
import entites.LigneDeCommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tofi
 */
@Local
public interface GestionPaiementLocal {

    public List<Commande> findCommandeByStatusPret(String status);

    public List<LigneDeCommande> detailCommandeByEmplacement(String numEmplacement);

    public Float getPrixTotalHT(List<LigneDeCommande> ligneDeCo);

    public Float getPrixTTC(LigneDeCommande ligneDeCo);

    public Float getPrixTotalTTC(List<LigneDeCommande> ligneDeCo);

    public Float getTvaLigneDeCo(LigneDeCommande ligneDeCo);
    
}
