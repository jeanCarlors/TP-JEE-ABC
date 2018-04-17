/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jeanc
 */
@Entity
@Table(name = "COMPTEBANQUAIRE")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "CompteBanquaire.findAll", query = "SELECT c FROM CompteBanquaire c"),
@NamedQuery(name = "find", query = "SELECT c FROM CompteBanquaire c WHERE c.id = :id"),})
public class CompteBanquaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    private String nom;
    private int solde;

    @OneToMany
    private List<OperationABC> operations = new ArrayList<>();  

    @ManyToOne
    public ClientABC client;

    public CompteBanquaire(String nom, int solde, ClientABC client) {
        this.nom = nom;
        this.solde = solde;
        this.client = client;
    }
    
    public CompteBanquaire() {
    }

    public CompteBanquaire(String nom, int solde) {
        this.nom = nom;
        this.solde = solde;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBanquaire)) {
            return false;
        }
        CompteBanquaire other = (CompteBanquaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CompteBanquaire[ id=" + id + " ]";
    }

    public void deposer(int montant) {
        solde += montant;
    }

    public int retirer(int montant) {
        if (montant > solde) {
            solde -= montant;
            return montant;
        } else {
            return 0;
        }
    }
    
    public void transferer(CompteBanquaire compte, int montant) {
        if (solde > montant) {
            compte.deposer(montant);
            this.retirer(montant);
            operations.add(new OperationABC("Transfert", montant, this, compte));
        }
    }
}
