/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.OperationABC;
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
public class GestionnaireDeOperation {

@PersistenceContext(unitName = "BanqueABC-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void creerOperation(OperationABC c) {
        em.persist(c);
    }

    public List<OperationABC> getAllOperation() {
        Query query = em.createNamedQuery("findAllOperation");
        return query.getResultList();
    }
}
