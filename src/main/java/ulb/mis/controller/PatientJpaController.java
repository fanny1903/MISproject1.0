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
import ulb.mis.model.Person;
import ulb.mis.model.Doctor;
import ulb.mis.model.Patient;
import ulb.mis.model.Sickness;

/**
 *
 * @author Liya Rosenstein
 */
public class PatientJpaController implements Serializable {

    public PatientJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Patient patient) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Person idperson = patient.getIdperson();
            if (idperson != null) {
                idperson = em.getReference(idperson.getClass(), idperson.getIdperson());
                patient.setIdperson(idperson);
            }
            Doctor iddesignateddoctor = patient.getIddesignateddoctor();
            if (iddesignateddoctor != null) {
                iddesignateddoctor = em.getReference(iddesignateddoctor.getClass(), iddesignateddoctor.getIddoctor());
                patient.setIddesignateddoctor(iddesignateddoctor);
            }
            Sickness idsickness = patient.getIdsickness();
            if (idsickness != null) {
                idsickness = em.getReference(idsickness.getClass(), idsickness.getIdsickness());
                patient.setIdsickness(idsickness);
            }
            em.persist(patient);
            if (idperson != null) {
                idperson.getPatientCollection().add(patient);
                idperson = em.merge(idperson);
            }
            if (iddesignateddoctor != null) {
                iddesignateddoctor.getPatientCollection().add(patient);
                iddesignateddoctor = em.merge(iddesignateddoctor);
            }
            if (idsickness != null) {
                idsickness.getPatientCollection().add(patient);
                idsickness = em.merge(idsickness);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Patient patient) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Patient persistentPatient = em.find(Patient.class, patient.getIdpatient());
            Person idpersonOld = persistentPatient.getIdperson();
            Person idpersonNew = patient.getIdperson();
            Doctor iddesignateddoctorOld = persistentPatient.getIddesignateddoctor();
            Doctor iddesignateddoctorNew = patient.getIddesignateddoctor();
            Sickness idsicknessOld = persistentPatient.getIdsickness();
            Sickness idsicknessNew = patient.getIdsickness();
            if (idpersonNew != null) {
                idpersonNew = em.getReference(idpersonNew.getClass(), idpersonNew.getIdperson());
                patient.setIdperson(idpersonNew);
            }
            if (iddesignateddoctorNew != null) {
                iddesignateddoctorNew = em.getReference(iddesignateddoctorNew.getClass(), iddesignateddoctorNew.getIddoctor());
                patient.setIddesignateddoctor(iddesignateddoctorNew);
            }
            if (idsicknessNew != null) {
                idsicknessNew = em.getReference(idsicknessNew.getClass(), idsicknessNew.getIdsickness());
                patient.setIdsickness(idsicknessNew);
            }
            patient = em.merge(patient);
            if (idpersonOld != null && !idpersonOld.equals(idpersonNew)) {
                idpersonOld.getPatientCollection().remove(patient);
                idpersonOld = em.merge(idpersonOld);
            }
            if (idpersonNew != null && !idpersonNew.equals(idpersonOld)) {
                idpersonNew.getPatientCollection().add(patient);
                idpersonNew = em.merge(idpersonNew);
            }
            if (iddesignateddoctorOld != null && !iddesignateddoctorOld.equals(iddesignateddoctorNew)) {
                iddesignateddoctorOld.getPatientCollection().remove(patient);
                iddesignateddoctorOld = em.merge(iddesignateddoctorOld);
            }
            if (iddesignateddoctorNew != null && !iddesignateddoctorNew.equals(iddesignateddoctorOld)) {
                iddesignateddoctorNew.getPatientCollection().add(patient);
                iddesignateddoctorNew = em.merge(iddesignateddoctorNew);
            }
            if (idsicknessOld != null && !idsicknessOld.equals(idsicknessNew)) {
                idsicknessOld.getPatientCollection().remove(patient);
                idsicknessOld = em.merge(idsicknessOld);
            }
            if (idsicknessNew != null && !idsicknessNew.equals(idsicknessOld)) {
                idsicknessNew.getPatientCollection().add(patient);
                idsicknessNew = em.merge(idsicknessNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = patient.getIdpatient();
                if (findPatient(id) == null) {
                    throw new NonexistentEntityException("The patient with id " + id + " no longer exists.");
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
            Patient patient;
            try {
                patient = em.getReference(Patient.class, id);
                patient.getIdpatient();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The patient with id " + id + " no longer exists.", enfe);
            }
            Person idperson = patient.getIdperson();
            if (idperson != null) {
                idperson.getPatientCollection().remove(patient);
                idperson = em.merge(idperson);
            }
            Doctor iddesignateddoctor = patient.getIddesignateddoctor();
            if (iddesignateddoctor != null) {
                iddesignateddoctor.getPatientCollection().remove(patient);
                iddesignateddoctor = em.merge(iddesignateddoctor);
            }
            Sickness idsickness = patient.getIdsickness();
            if (idsickness != null) {
                idsickness.getPatientCollection().remove(patient);
                idsickness = em.merge(idsickness);
            }
            em.remove(patient);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Patient> findPatientEntities() {
        return findPatientEntities(true, -1, -1);
    }

    public List<Patient> findPatientEntities(int maxResults, int firstResult) {
        return findPatientEntities(false, maxResults, firstResult);
    }

    private List<Patient> findPatientEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Patient.class));
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

    public Patient findPatient(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Patient.class, id);
        } finally {
            em.close();
        }
    }

    public int getPatientCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Patient> rt = cq.from(Patient.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
