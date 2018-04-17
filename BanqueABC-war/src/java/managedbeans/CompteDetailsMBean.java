/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.CompteBanquaire;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.GestionnaireDeCompteBanquaire;

/**
 *
 * @author jeanc
 */
@Named(value = "compteDetailsMBean")
@ViewScoped
public class CompteDetailsMBean implements Serializable {

    private int idCompte;
    private CompteBanquaire compte;

    @EJB
    private GestionnaireDeCompteBanquaire gestionnaireDeCompteBanquaire;

    public CompteDetailsMBean() {
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBanquaire getDetails() {
        return compte;
    }

//    public String creerCompte() {
//        //compte = gestionnaireDeCompteBanquaire.creerCompte(compte);
//        return "CompteList";
//    }
    public String update() {
        System.out.println("###UPDATE###");
        gestionnaireDeCompteBanquaire.update(compte);
        return "CompteList";
    }

    public String list() {
        System.out.println("###LIST###");
        return null;  //"CustomerList";  
    }

    public void loadCompte() {
        this.compte = gestionnaireDeCompteBanquaire.getCompte(idCompte);
    }

    @PostConstruct
    public void init() {
        compte = new CompteBanquaire("Jhon", 0);
    }

    public String creerCompte() {
        System.out.println("###UPDATE###");
        gestionnaireDeCompteBanquaire.creerCompte(compte);
        return "CompteList";
    }
}
