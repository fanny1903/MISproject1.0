/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.mis.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Liya Rosenstein
 */
@Entity
@Table(name = "appointment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
    @NamedQuery(name = "Appointment.findByIdappointment", query = "SELECT a FROM Appointment a WHERE a.idappointment = :idappointment"),
    @NamedQuery(name = "Appointment.findByAppointmentdatetime", query = "SELECT a FROM Appointment a WHERE a.appointmentdatetime = :appointmentdatetime")})
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idappointment")
    private Integer idappointment;
    @Basic(optional = false)
    @Column(name = "appointmentdatetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentdatetime;
    @JoinColumn(name = "iddoctor", referencedColumnName = "iddoctor")
    @ManyToOne(optional = false)
    private Doctor iddoctor;
    @JoinColumn(name = "idpatient", referencedColumnName = "idpatient")
    @ManyToOne(optional = false)
    private Patient idpatient;

    public Appointment() {
    }

    public Appointment(Integer idappointment) {
        this.idappointment = idappointment;
    }

    public Appointment(Integer idappointment, Date appointmentdatetime) {
        this.idappointment = idappointment;
        this.appointmentdatetime = appointmentdatetime;
    }

    public Integer getIdappointment() {
        return idappointment;
    }

    public void setIdappointment(Integer idappointment) {
        this.idappointment = idappointment;
    }

    public Date getAppointmentdatetime() {
        return appointmentdatetime;
    }

    public void setAppointmentdatetime(Date appointmentdatetime) {
        this.appointmentdatetime = appointmentdatetime;
    }

    public Doctor getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Doctor iddoctor) {
        this.iddoctor = iddoctor;
    }

    public Patient getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Patient idpatient) {
        this.idpatient = idpatient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idappointment != null ? idappointment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointment)) {
            return false;
        }
        Appointment other = (Appointment) object;
        if ((this.idappointment == null && other.idappointment != null) || (this.idappointment != null && !this.idappointment.equals(other.idappointment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ulb.mis.model2.Appointment[ idappointment=" + idappointment + " ]";
    }
    
}
