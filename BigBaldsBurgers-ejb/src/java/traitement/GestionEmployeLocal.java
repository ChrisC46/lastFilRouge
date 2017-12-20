/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import entites.Droits;
import entites.Employe;
import java.util.List;
import javax.ejb.Local;
import outils.CustomedException;

/**
 *
 * @author cdi317
 */
@Local
public interface GestionEmployeLocal {
//
//    public Boolean isDroits(String loginE, String droit);
//
//    public List<Employe> findAllLoginByDroits(String droit);

    public List<Droits> findDroitsByLogin(String loginE) throws CustomedException;

    public Boolean isLogin(String loginE, String droit);
    
}
