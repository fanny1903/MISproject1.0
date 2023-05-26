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
import ulb.mis.model.Person;
import ulb.mis.model.Patient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ulb.mis.controller.exceptions.IllegalOrphanException;
import ulb.mis.controller.exceptions.NonexistentEntityException;
import ulb.mis.model.Doctor;

/**
 *
 * @author Liya Rosenstein
 */
public class DoctorJpaController implements Serializable {

    public DoctorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Doctor doctor) {
        if (doctor.getPatientCollection() == null) {
            doctor.setPatientCollection(new ArrayList<Patient>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Person idperson = doctor.getIdperson();
            if (idperson != null) {
                idperson = em.getReference(idperson.getClass(), idperson.getIdperson());
                doctor.setIdperson(idperson);
            }
            Collection<Patient> attachedPatientCollection = new ArrayList<Patient>();
            for (Patient patientCollectionPatientToAttach : doctor.getPatientCollection()) {
                patientCollectionPatientToAttach = em.getReference(patientCollectionPatientToAttach.getClass(), patientCollectionPatientToAttach.getIdpatient());
                attachedPatientCollection.add(patientCollectionPatientToAttach);
            }
            doctor.setPatientCollection(attachedPatientCollection);
            em.persist(doctor);
            if (idperson != null) {
                idperson.getDoctorCollection().add(doctor);
                idperson = em.merge(idperson);
            }
            for (Patient patientCollectionPatient : doctor.getPatientCollection()) {
                Doctor oldIddesignateddoctorOfPatientCollectionPatient = patientCollectionPatient.getIddesignateddoctor();
                patientCollectionPatient.setIddesignateddoctor(doctor);
                patientCollectionPatient = em.merge(patientCollectionPatient);
                if (oldIddesignateddoctorOfPatientCollectionPatient != null) {
                    oldIddesignateddoctorOfPatientCollectionPatient.getPatientCollection().remove(patientCollectionPatient);
                    oldIddesignateddoctorOfPatientCollectionPatient = em.merge(oldIddesignateddoctorOfPatientCollectionPatient);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Doctor doctor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Doctor persistentDoctor = em.find(Doctor.class, doctor.getIddoctor());
            Person idpersonOld = persistentDoctor.getIdperson();
            Person idpersonNew = doctor.getIdperson();
            Collection<Patient> patientCollectionOld = persistentDoctor.getPatientCollection();
            Collection<Patient> patientCollectionNew = doctor.getPatientCollection();
            List<String> illegalOrphanMessages = null;
            for (Patient patientCollectionOldPatient : patientCollectionOld) {
                if (!patientCollectionNew.contains(patientCollectionOldPatient)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Patient " + patientCollectionOldPatient + " since its iddesignateddoctor field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idpersonNew != null) {
                idpersonNew = em.getReference(idpersonNew.getClass(), idpersonNew.getIdperson());
                doctor.setIdperson(idpersonNew);
            }
            Collection<Patient> attachedPatientCollectionNew = new ArrayList<Patient>();
            for (Patient patientCollectionNewPatientToAttach : patientCollectionNew) {
                patientCollectionNewPatientToAttach = em.getReference(patientCollectionNewPatientToAttach.getClass(), patientCollectionNewPatientToAttach.getIdpatient());
                attachedPatientCollectionNew.add(patientCollectionNewPatientToAttach);
            }
            patientCollectionNew = attachedPatientCollectionNew;
            doctor.setPatientCollection(patientCollectionNew);
            doctor = em.merge(doctor);
            if (idpersonOld != null && !idpersonOld.equals(idpersonNew)) {
                idpersonOld.getDoctorCollection().remove(doctor);
                idpersonOld = em.merge(idpersonOld);
            }
            if (idpersonNew != null && !idpersonNew.equals(idpersonOld)) {
                idpersonNew.getDoctorCollection().add(doctor);
                idpersonNew = em.merge(idpersonNew);
            }
            for (Patient patientCollectionNewPatient : patientCollectionNew) {
                if (!patientCollectionOld.contains(patientCollectionNewPatient)) {
                    Doctor oldIddesignateddoctorOfPatientCollectionNewPatient = patientCollectionNewPatient.getIddesignateddoctor();
                    patientCollectionNewPatient.setIddesignateddoctor(doctor);
                    patientCollectionNewPatient = em.merge(patientCollectionNewPatient);
                    if (oldIddesignateddoctorOfPatientCollectionNewPatient != null && !oldIddesignateddoctorOfPatientCollectionNewPatient.equals(doctor)) {
                        oldIddesignateddoctorOfPatientCollectionNewPatient.getPatientCollection().remove(patientCollectionNewPatient);
                        oldIddesignateddoctorOfPatientCollectionNewPatient = em.merge(oldIddesignateddoctorOfPatientCollectionNewPatient);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = doctor.getIddoctor();
                if (findDoctor(id) == null) {
                    throw new NonexistentEntityException("The doctor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Doctor doctor;
            try {
                doctor = em.getReference(Doctor.class, id);
                doctor.getIddoctor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The doctor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Patient> patientCollectionOrphanCheck = doctor.getPatientCollection();
            for (Patient patientCollectionOrphanCheckPatient : patientCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Doctor (" + doctor + ") cannot be destroyed since the Patient " + patientCollectionOrphanCheckPatient + " in its patientCollection field has a non-nullable iddesignateddoctor field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Person idperson = doctor.getIdperson();
            if (idperson != null) {
                idperson.getDoctorCollection().remove(doctor);
                idperson = em.merge(idperson);
            }
            em.remove(doctor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Doctor> findDoctorEntities() {
        return findDoctorEntities(true, -1, -1);
    }

    public List<Doctor> findDoctorEntities(int maxResults, int firstResult) {
        return findDoctorEntities(false, maxResults, firstResult);
    }

    private List<Doctor> findDoctorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Doctor.class));
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

    public Doctor findDoctor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Doctor.class, id);
        } finally {
            em.close();
        }
    }

    public int getDoctorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Doctor> rt = cq.from(Doctor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
