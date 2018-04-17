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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rony BIEN-AIME
 */
@Entity
@Table(name = "CLIENTABC")
@XmlRootElement
@NamedQueries({
@NamedQuery(name = "findAllClient", query = "SELECT a from ClientABC a"),
@NamedQuery(name = "findLikeClient", query = "SELECT cb FROM ClientABC cb WHERE cb.nom LIKE :like")})
public class ClientABC implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String adresse;
    
    @OneToMany
    private List<CompteBanquaire> comptes = new ArrayList<>(); 
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ClientABC(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public ClientABC() {
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
        if (!(object instanceof ClientABC)) {
            return false;
        }
        ClientABC other = (ClientABC) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Client[ id=" + id + " ]";
    }
    
    public void ajouterCompte(){
    comptes.add(new CompteBanquaire(nom, 0));
    }
}
