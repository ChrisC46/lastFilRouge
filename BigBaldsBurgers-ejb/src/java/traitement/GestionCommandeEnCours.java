
 
package traitement; 
 
import entites.Commande; 
import java.util.HashMap; 
import java.util.List; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.annotation.PostConstruct; 
import javax.ejb.Singleton; 
import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.persistence.EntityManager; 
import javax.persistence.PersistenceContext; 
 
 
@Singleton 
public class GestionCommandeEnCours implements GestionCommandeEnCoursLocal { 
     
    @PersistenceContext(unitName = "BigBaldsBurgers-ejbPU") 
    private EntityManager em; 
     
   
     
    private static HashMap<String, Commande> commandeMap; 
     
    @PostConstruct 
    void init() { 
        commandeMap = new HashMap<>(); 
        GestionCommandeLocal gestionCommande = lookupGestionCommandeLocal(); 
        List<Commande> lc = gestionCommande.selectAllCommandesValideesFromDB(); 
        for (Commande c : lc) { 
            commandeMap.put(c.getNumTable().getNumero(), c); 
        } 
    } 
     
    @Override 
    public Commande selectCommandeForPlace(String numeroTable) { 
        if (commandeMap.containsKey(numeroTable)) { 
            return commandeMap.get(numeroTable); 
        } 
        return null; 
    } 
     
     
    @Override 
    public void nouvelleCommande(String numeroTable, Commande cmde) { 
        if (!checkIfCommandeEncours(numeroTable)) { 
            commandeMap.put(numeroTable, cmde); 
            return; 
        } 
        System.out.println("nouvelle commande dans le singleton echec !"); 
    } 
     
     
    @Override 
    public boolean checkIfCommandeEncours(String numeroTable) { 
        Commande cmde = selectCommandeForPlace(numeroTable); 
        return cmde != null; 
    } 
     
     
    @Override 
    public HashMap<String, Commande> selectAllCommandesEnCours() { 
        return commandeMap; 
    } 
 
    @Override 
    public void libererPlace(Commande c){ 
        commandeMap.remove(c.getNumTable().getNumero()); 
    } 
     
     private GestionCommandeLocal lookupGestionCommandeLocal() { 
        try { 
            Context c = new InitialContext(); 
            return (GestionCommandeLocal) c.lookup("java:global/BigBaldsBurgers/BigBaldsBurgers-ejb/GestionCommande!traitement.GestionCommandeLocal"); 
        } catch (NamingException ne) { 
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne); 
            throw new RuntimeException(ne); 
        } 
    } 
 
    public void persist(Object object) { 
        em.persist(object); 
    } 
} 
