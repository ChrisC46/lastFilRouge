
package traitement;

import entites.Droits;
import java.util.List;
import javax.ejb.Local;

@Local
public interface GestionDroitsLocal {
    
    public List<Droits> findAllDroits();
    
    
}
