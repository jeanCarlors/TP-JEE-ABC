/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rony BIEN-AIME
 */
@Entity
@Table(name = "OPERATIONABC")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "findAllOperation", query = "SELECT a from OperationABC a"),
@NamedQuery(name = "findLikeOperation", query = "SELECT cb FROM OperationABC cb WHERE cb.nom LIKE :like")})
public class OperationABC implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private Date date;
    private int montant;

    @OneToOne
    private CompteBanquaire compte;
    @OneToOne
    private CompteBanquaire compte1;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public OperationABC() {
    }

    public OperationABC(String nom, int montant, CompteBanquaire compte, CompteBanquaire compte1) {
        this.nom = nom;
        this.montant = montant;
        this.compte = compte;
        this.compte1 = compte1;
    }

    public Date getDate() {
        return date;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OperationABC(String nom, int montant, CompteBanquaire compte) {
        this.nom = nom;
        this.compte = compte;
        this.montant = montant;
        date = new Date();
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
        if (!(object instanceof OperationABC)) {
            return false;
        }
        OperationABC other = (OperationABC) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Operation[ id=" + id + " ]";
    }

}
