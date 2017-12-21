
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries({
    @NamedQuery(name = "findAll.Commande",query = "select c from Commande c"),
    @NamedQuery(name = "entites.Commande.findCommandeByStatusPret", query = "select c.numTable from Commande c where c.suiviCommande = :staPret" )
})
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float prixTotal;
    @Temporal(TemporalType.TIME)
    private Date date;

    @ManyToOne
    private Emplacement numTable;
    @ManyToOne
    private Employe serveur;
    @OneToMany(mappedBy = "commandes")
    private Collection<Paiement>payer;
    @ManyToOne
    private Status suiviCommande;
    @OneToMany(mappedBy = "commande")
    private Collection<LigneDeCommande>ligneDeCo;
    
    public Commande() {
        payer = new ArrayList<>();
        ligneDeCo = new ArrayList<>();
    }

    public Commande(Float prixTotal, Date date) {
        this();
        this.prixTotal = prixTotal;
        this.date = date;
    }

    public Collection<LigneDeCommande> getLigneDeCo() {
        return ligneDeCo;
    }

    public void setLigneDeCo(Collection<LigneDeCommande> ligneDeCo) {
        this.ligneDeCo = ligneDeCo;
    }

    public Collection<Paiement> getPayer() {
        return payer;
    }

    public void setPayer(Collection<Paiement> payer) {
        this.payer = payer;
    }

    public Status getSuiviCommande() {
        return suiviCommande;
    }

    public void setSuiviCommande(Status suiviCommande) {
        this.suiviCommande = suiviCommande;
    }


    public Employe getServeur() {
        return serveur;
    }

    public void setServeur(Employe serveur) {
        this.serveur = serveur;
    }

    public Emplacement getNumTable() {
        return numTable;
    }

    public void setNumTable(Emplacement numTable) {
        this.numTable = numTable;
    }
          
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

  
    @Override
    public String toString() {
        return "Date commande : " + date + ". " + " Prix Total : " + prixTotal;
    }
    
}
