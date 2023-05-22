/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.mis.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Liya Rosenstein
 */
@Entity
@Table(name = "doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findByIddoctor", query = "SELECT d FROM Doctor d WHERE d.iddoctor = :iddoctor"),
    @NamedQuery(name = "Doctor.findByInami", query = "SELECT d FROM Doctor d WHERE d.inami = :inami")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddoctor")
    private Integer iddoctor;
    @Basic(optional = false)
    @Column(name = "inami")
    private String inami;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson")
    @ManyToOne(optional = false)
    private Person idperson;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddesignateddoctor")
    private Collection<Patient> patientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddoctor")
    private Collection<Appointment> appointmentCollection;

    public Doctor() {
    }

    public Doctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public Doctor(Integer iddoctor, String inami) {
        this.iddoctor = iddoctor;
        this.inami = inami;
    }

    public Integer getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getInami() {
        return inami;
    }

    public void setInami(String inami) {
        this.inami = inami;
    }

    public Person getIdperson() {
        return idperson;
    }

    public void setIdperson(Person idperson) {
        this.idperson = idperson;
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    @XmlTransient
    public Collection<Appointment> getAppointmentCollection() {
        return appointmentCollection;
    }

    public void setAppointmentCollection(Collection<Appointment> appointmentCollection) {
        this.appointmentCollection = appointmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddoctor != null ? iddoctor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.iddoctor == null && other.iddoctor != null) || (this.iddoctor != null && !this.iddoctor.equals(other.iddoctor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ulb.mis.model2.Doctor[ iddoctor=" + iddoctor + " ]";
    }
    
}
