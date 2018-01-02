
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries ({
@NamedQuery (name = "rechercheEmplacements", query = "select e from Emplacement e where e.numero=:empNumero"),
}) 
public class Emplacement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(nullable = false)
    @Id
    private String numero;
    @Column(nullable = false)
    private int nbrePlaces;

    
    @OneToMany(mappedBy = "numTable")
    private Collection<Commande> commandeEmplacement;
    @ManyToOne
    private Status dispoTable;
    
    public Emplacement() {
        commandeEmplacement = new ArrayList();
    }

    public Emplacement(String numero, int nbrePlaces) {
        this();
        this.numero = numero;
        this.nbrePlaces = nbrePlaces;
    }

    public Collection<Commande> getCommande() {
        return commandeEmplacement;
    }

    public void setCommande(Collection<Commande> commandeEmplacement) {
        this.commandeEmplacement = commandeEmplacement;
    }

    public Status getDispoTable() {
        return dispoTable;
    }

    public void setDispoTable(Status dispoTable) {
        this.dispoTable = dispoTable;
    }
       
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNbrePlaces() {
        return nbrePlaces;
    }

    public void setNbrePlaces(int nbrePlaces) {
        this.nbrePlaces = nbrePlaces;
    }

      

    @Override
    public String toString() {
        return "Numéro de table : " + numero + ". " + "Nombre places : " + nbrePlaces;
    }
    
}
