package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int reference;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToMany
    private Collection<TypeDePaiement> typePaiements;

    public Paiement() {
        typePaiements = new ArrayList<>();
    }

    public Paiement(int reference, Date date) {
        this();
        this.reference = reference;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<TypeDePaiement> getTypePaiements() {
        return typePaiements;
    }

    public void setTypePaiements(Collection<TypeDePaiement> typePaiements) {
        this.typePaiements = typePaiements;
    }
    
    
    @Override
    public String toString() {
        return "refPaiment " + reference + " datePaiment : " + date;
    }

}
