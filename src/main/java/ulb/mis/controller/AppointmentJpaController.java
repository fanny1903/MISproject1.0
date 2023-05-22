/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.mis.controller;

import ulb.mis.model.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ulb.mis.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author Liya Rosenstein
 */
public class AppointmentJpaController implements Serializable {

    public AppointmentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Appointment appointment) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Doctor iddoctor = appointment.getIddoctor();
            if (iddoctor != null) {
                iddoctor = em.getReference(iddoctor.getClass(), iddoctor.getIddoctor());
                appointment.setIddoctor(iddoctor);
            }
            Patient idpatient = appointment.getIdpatient();
            if (idpatient != null) {
                idpatient = em.getReference(idpatient.getClass(), idpatient.getIdpatient());
                appointment.setIdpatient(idpatient);
            }
            em.persist(appointment);
            if (iddoctor != null) {
                iddoctor.getAppointmentCollection().add(appointment);
                iddoctor = em.merge(iddoctor);
            }
            if (idpatient != null) {
                idpatient.getAppointmentCollection().add(appointment);
                idpatient = em.merge(idpatient);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Appointment appointment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Appointment persistentAppointment = em.find(Appointment.class, appointment.getIdappointment());
            Doctor iddoctorOld = persistentAppointment.getIddoctor();
            Doctor iddoctorNew = appointment.getIddoctor();
            Patient idpatientOld = persistentAppointment.getIdpatient();
            Patient idpatientNew = appointment.getIdpatient();
            if (iddoctorNew != null) {
                iddoctorNew = em.getReference(iddoctorNew.getClass(), iddoctorNew.getIddoctor());
                appointment.setIddoctor(iddoctorNew);
            }
            if (idpatientNew != null) {
                idpatientNew = em.getReference(idpatientNew.getClass(), idpatientNew.getIdpatient());
                appointment.setIdpatient(idpatientNew);
            }
            appointment = em.merge(appointment);
            if (iddoctorOld != null && !iddoctorOld.equals(iddoctorNew)) {
                iddoctorOld.getAppointmentCollection().remove(appointment);
                iddoctorOld = em.merge(iddoctorOld);
            }
            if (iddoctorNew != null && !iddoctorNew.equals(iddoctorOld)) {
                iddoctorNew.getAppointmentCollection().add(appointment);
                iddoctorNew = em.merge(iddoctorNew);
            }
            if (idpatientOld != null && !idpatientOld.equals(idpatientNew)) {
                idpatientOld.getAppointmentCollection().remove(appointment);
                idpatientOld = em.merge(idpatientOld);
            }
            if (idpatientNew != null && !idpatientNew.equals(idpatientOld)) {
                idpatientNew.getAppointmentCollection().add(appointment);
                idpatientNew = em.merge(idpatientNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = appointment.getIdappointment();
                if (findAppointment(id) == null) {
                    throw new NonexistentEntityException("The appointment with id " + id + " no longer exists.");
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
            Appointment appointment;
            try {
                appointment = em.getReference(Appointment.class, id);
                appointment.getIdappointment();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The appointment with id " + id + " no longer exists.", enfe);
            }
            Doctor iddoctor = appointment.getIddoctor();
            if (iddoctor != null) {
                iddoctor.getAppointmentCollection().remove(appointment);
                iddoctor = em.merge(iddoctor);
            }
            Patient idpatient = appointment.getIdpatient();
            if (idpatient != null) {
                idpatient.getAppointmentCollection().remove(appointment);
                idpatient = em.merge(idpatient);
            }
            em.remove(appointment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Appointment> findAppointmentEntities() {
        return findAppointmentEntities(true, -1, -1);
    }

    public List<Appointment> findAppointmentEntities(int maxResults, int firstResult) {
        return findAppointmentEntities(false, maxResults, firstResult);
    }

    private List<Appointment> findAppointmentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Appointment.class));
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

    public Appointment findAppointment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Appointment.class, id);
        } finally {
            em.close();
        }
    }

    public int getAppointmentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Appointment> rt = cq.from(Appointment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
