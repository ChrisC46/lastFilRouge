/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitement;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import entites.Emplacement;
import java.util.List;
import javax.ejb.Local;
import outils.CustomedException;

/**
 *
 * @author cdi317
 */
@Local
public interface GestionEmplacementLocal {

    public Emplacement selectionEmplacement(String numero) throws CustomedException;

    public List<Emplacement> selectionListeEmplacements(string numero);



}