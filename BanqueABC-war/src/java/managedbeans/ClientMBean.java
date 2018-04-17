package managedbeans;

import entities.ClientABC;
import static entities.CompteBanquaire_.client;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.GestionnaireDeClient;

@Named(value = "clientMBean")
@ViewScoped
public class ClientMBean implements Serializable{
    @EJB
    private GestionnaireDeClient gestionnaireDeClient;

    private ClientABC client;
    
    public ClientMBean() {
    }
     public String CreerClient(){  
        gestionnaireDeClient.creerClient(client); 
         return "ClientList";
        
    } 
    public List<ClientABC> getClient(){  
        return gestionnaireDeClient.getAllClient();  
    }  
    
}
