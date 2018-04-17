package managedbeans;

import entities.CompteBanquaire;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.GestionnaireDeCompteBanquaire;

@Named(value = "compteMBean")
@ViewScoped
public class CompteMBean implements Serializable{
    @EJB
    private GestionnaireDeCompteBanquaire gestionnaireDeCompteBanquaire;

    public CompteMBean() {
    }
    
     public List<CompteBanquaire> getCompte(){  
        return gestionnaireDeCompteBanquaire.getAllComptes();  
    } 
     
     public String infoClient(int compteId) {
        return "CompteDetails?idCompte=" + compteId;
    }
}
