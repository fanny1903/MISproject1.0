/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.mis.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Liya Rosenstein
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByIdperson", query = "SELECT p FROM Person p WHERE p.idperson = :idperson"),
    @NamedQuery(name = "Person.findByFirstname", query = "SELECT p FROM Person p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Person.findByDateofbirth", query = "SELECT p FROM Person p WHERE p.dateofbirth = :dateofbirth"),
    @NamedQuery(name = "Person.findByPersonpassword", query = "SELECT p FROM Person p WHERE p.personpassword = :personpassword")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperson")
    private Integer idperson;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @Basic(optional = false)
    @Column(name = "personpassword")
    private String personpassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperson")
    private Collection<Doctor> doctorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperson")
    private Collection<Patient> patientCollection;

    public Person() {
    }

    public Person(Integer idperson) {
        this.idperson = idperson;
    }

    public Person(Integer idperson, String firstname, String lastname, Date dateofbirth, String personpassword) {
        this.idperson = idperson;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.personpassword = personpassword;
    }

    public Integer getIdperson() {
        return idperson;
    }

    public void setIdperson(Integer idperson) {
        this.idperson = idperson;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPersonpassword() {
        return personpassword;
    }

    public void setPersonpassword(String personpassword) {
        this.personpassword = personpassword;
    }

    @XmlTransient
    public Collection<Doctor> getDoctorCollection() {
        return doctorCollection;
    }

    public void setDoctorCollection(Collection<Doctor> doctorCollection) {
        this.doctorCollection = doctorCollection;
    }

    @XmlTransient
    public Collection<Patient> getPatientCollection() {
        return patientCollection;
    }

    public void setPatientCollection(Collection<Patient> patientCollection) {
        this.patientCollection = patientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperson != null ? idperson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idperson == null && other.idperson != null) || (this.idperson != null && !this.idperson.equals(other.idperson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ulb.mis.model.Person[ idperson=" + idperson + " ]";
    }
    
}
