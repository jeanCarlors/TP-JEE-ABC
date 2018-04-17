/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.CompteBanquaire;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jeanc
 */
@Stateless
@LocalBean
public class GestionnaireDeCompteBanquaire {

    @PersistenceContext(unitName = "BanqueABC-ejbPU")
    private EntityManager em;

    public CompteBanquaire creerCompte(CompteBanquaire c) {
        em.persist(c);
        return c;
    }

    public void creerComptesTest() {
        creerCompte(new CompteBanquaire("John Lennon", 150000));
        creerCompte(new CompteBanquaire("Paul McCartney", 950000));
        creerCompte(new CompteBanquaire("Ringo Starr", 20000));
        creerCompte(new CompteBanquaire("Georges Harrisson", 100000));
    }
    
    public List<CompteBanquaire> getAllComptes() {
        Query query = em.createNamedQuery("CompteBanquaire.findAll");
        return query.getResultList();
    }

    public CompteBanquaire update(CompteBanquaire compte) {
        return em.merge(compte);
    }

    public CompteBanquaire getCompte(long idCompte) {
       return em.find(CompteBanquaire.class, idCompte);
    }
    
    
}
