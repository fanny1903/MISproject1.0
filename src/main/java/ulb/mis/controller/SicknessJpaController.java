/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.mis.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ulb.mis.model.Patient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ulb.mis.controller.exceptions.NonexistentEntityException;
import ulb.mis.model.Sickness;

/**
 *
 * @author Liya Rosenstein
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
        if (sickness.getPatientCollection() == null) {
            sickness.setPatientCollection(new ArrayList<Patient>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Patient> attachedPatientCollection = new ArrayList<Patient>();
            for (Patient patientCollectionPatientToAttach : sickness.getPatientCollection()) {
                patientCollectionPatientToAttach = em.getReference(patientCollectionPatientToAttach.getClass(), patientCollectionPatientToAttach.getIdpatient());
                attachedPatientCollection.add(patientCollectionPatientToAttach);
            }
            sickness.setPatientCollection(attachedPatientCollection);
            em.persist(sickness);
            for (Patient patientCollectionPatient : sickness.getPatientCollection()) {
                Sickness oldIdsicknessOfPatientCollectionPatient = patientCollectionPatient.getIdsickness();
                patientCollectionPatient.setIdsickness(sickness);
                patientCollectionPatient = em.merge(patientCollectionPatient);
                if (oldIdsicknessOfPatientCollectionPatient != null) {
                    oldIdsicknessOfPatientCollectionPatient.getPatientCollection().remove(patientCollectionPatient);
                    oldIdsicknessOfPatientCollectionPatient = em.merge(oldIdsicknessOfPatientCollectionPatient);
                }
            }
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
            Sickness persistentSickness = em.find(Sickness.class, sickness.getIdsickness());
            Collection<Patient> patientCollectionOld = persistentSickness.getPatientCollection();
            Collection<Patient> patientCollectionNew = sickness.getPatientCollection();
            Collection<Patient> attachedPatientCollectionNew = new ArrayList<Patient>();
            for (Patient patientCollectionNewPatientToAttach : patientCollectionNew) {
                patientCollectionNewPatientToAttach = em.getReference(patientCollectionNewPatientToAttach.getClass(), patientCollectionNewPatientToAttach.getIdpatient());
                attachedPatientCollectionNew.add(patientCollectionNewPatientToAttach);
            }
            patientCollectionNew = attachedPatientCollectionNew;
            sickness.setPatientCollection(patientCollectionNew);
            sickness = em.merge(sickness);
            for (Patient patientCollectionOldPatient : patientCollectionOld) {
                if (!patientCollectionNew.contains(patientCollectionOldPatient)) {
                    patientCollectionOldPatient.setIdsickness(null);
                    patientCollectionOldPatient = em.merge(patientCollectionOldPatient);
                }
            }
            for (Patient patientCollectionNewPatient : patientCollectionNew) {
                if (!patientCollectionOld.contains(patientCollectionNewPatient)) {
                    Sickness oldIdsicknessOfPatientCollectionNewPatient = patientCollectionNewPatient.getIdsickness();
                    patientCollectionNewPatient.setIdsickness(sickness);
                    patientCollectionNewPatient = em.merge(patientCollectionNewPatient);
                    if (oldIdsicknessOfPatientCollectionNewPatient != null && !oldIdsicknessOfPatientCollectionNewPatient.equals(sickness)) {
                        oldIdsicknessOfPatientCollectionNewPatient.getPatientCollection().remove(patientCollectionNewPatient);
                        oldIdsicknessOfPatientCollectionNewPatient = em.merge(oldIdsicknessOfPatientCollectionNewPatient);
                    }
                }
            }
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
            Collection<Patient> patientCollection = sickness.getPatientCollection();
            for (Patient patientCollectionPatient : patientCollection) {
                patientCollectionPatient.setIdsickness(null);
                patientCollectionPatient = em.merge(patientCollectionPatient);
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
