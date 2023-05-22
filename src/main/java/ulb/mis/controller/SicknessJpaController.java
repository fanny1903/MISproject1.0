/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.mis.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ulb.mis.controller.exceptions.NonexistentEntityException;
import ulb.mis.model.Sickness;

/**
 *
 * @author fanny
 */
public class SicknessJpaController implements Serializable {

    public SicknessJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

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

    public void edit(Sickness sickness) throws NonexistentEntityException, Exception {
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
            throw ex;
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

    public List<Sickness> findSicknessEntities() {
        return findSicknessEntities(true, -1, -1);
    }

    public List<Sickness> findSicknessEntities(int maxResults, int firstResult) {
        return findSicknessEntities(false, maxResults, firstResult);
    }

    private List<Sickness> findSicknessEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sickness.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
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

    public int getSicknessCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sickness> rt = cq.from(Sickness.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
