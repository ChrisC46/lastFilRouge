/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author cdi312
 */
@Entity
@NamedQueries ({
    @NamedQuery(name = "findAll.Droits", query = "select d from Droits d")
})
public class Droits implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column (nullable = false)
    @Id
    private String nom;

    @ManyToMany(mappedBy = "typeDroit")
    private Collection<Employe> employe;
    
    public Droits() {
        employe = new ArrayList<>();
    }

    public Droits(String nom) {
        this();
        this.nom = nom;
    }

    public Collection<Employe> getEmploye() {
        return employe;
    }

    public void setEmploye(Collection<Employe> employe) {
        this.employe = employe;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    @Override
    public String toString() {
        return "Droit employé : " + nom;
    }
    
}
