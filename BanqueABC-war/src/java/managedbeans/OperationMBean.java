/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.OperationABC;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.GestionnaireDeOperation;

/**
 *
 * @author jeanc
 */
@Named(value = "operationMBean")
@ViewScoped
public class OperationMBean implements Serializable{
    @EJB
    private GestionnaireDeOperation gestionnaireDeOperation;

    /**
     * Creates a new instance of OperationMBean
     */
    public OperationMBean() {
    }
    
    public List<OperationABC> getOperation(){  
        return gestionnaireDeOperation.getAllOperation();  
    } 
}
