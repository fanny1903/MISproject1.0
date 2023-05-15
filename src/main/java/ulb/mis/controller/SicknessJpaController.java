package ulb.mis.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import ulb.mis.controller.exceptions.NonexistentEntityException;
import ulb.mis.model.Sickness;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ulb.mis.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ulb.mis.controller.exceptions.IllegalOrphanException;
import ulb.mis.controller.exceptions.NonexistentEntityException;
import ulb.mis.model.Sickness;

/**
 *
 * @author Liya Rosenstein
 */
public class SicknessJpaController implements Serializable {
    
    private EntityManagerFactory emf = null;
    
    public SicknessJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Sickness sickness) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sickness);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void edit(Sickness sickness) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sickness = em.merge(sickness);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sickness.getIdsickness();
                if (findSickness(id) == null) {
                    throw new NonexistentEntityException("The sickness with id " + id + " no longer exists.");
                }
            }
            throw new NonexistentEntityException("The sickness with id " + sickness.getIdsickness() + " could not be updated.", ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sickness sickness;
            try {
                sickness = em.getReference(Sickness.class, id);
                sickness.getIdsickness();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sickness with id " + id + " no longer exists.", enfe);
            }
            em.remove(sickness);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Sickness findSickness(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sickness.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Sickness> findSicknessEntities() {
        return findSicknessEntities(true, -1, -1);
    }
    
    public List<Sickness> findSicknessEntities(int maxResults, int firstResult) {
        return findSicknessEntities(false, maxResults, firstResult);
    }
    
    private List<Sickness> findSicknessEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sickness.class));
            javax.persistence.Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public int getSicknessCount() {
        EntityManager em = getEntityManager();
        try {
            javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root<S