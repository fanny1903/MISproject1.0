/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulb.mis.model;

import java.io.Serializable;
import java.util.List;
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
 * @author Adrien Foucart
 */
@Entity
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByIdpatient", query = "SELECT p FROM Patient p WHERE p.idpatient = :idpatient"),
    @NamedQuery(name = "Patient.findByIddesignateddoctor", query = "SELECT p FROM Patient p WHERE p.iddesignateddoctor = :iddesignateddoctor"),
    @NamedQuery(name = "Patient.findByIddesignatedsickness", query = "SELECT p FROM Patient p WHERE p.iddesignatedsickness = :iddesignatedsickness")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpatient")
    private Integer idpatient;
    @Basic(optional = false)
    @Column(name = "iddesignateddoctor")
    private String iddesignateddoctor;
    @Column(name = "iddesignatedsickness")
    private String iddesignatedsickness;
    @OneToMany(mappedBy = "idpatient")
    @JoinColumn(name = "idperson", referencedColumnName = "idperson")
    @ManyToOne(optional = false)
    private Person idperson;
    

    public Patient() {
    }

    public Patient(Integer idpatient) {
        this.idpatient = idpatient;
    }

    public Integer getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Integer idpatient) {
        this.idpatient = idpatient;
    }
    
    public String getIddesignateddoctor() {
        return iddesignateddoctor;
    }

    public void setIddesignateddoctor(String iddesignateddoctor) {
        this.iddesignateddoctor = iddesignateddoctor;
    }
    
    public String getIddesignatedsickness() {
        return iddesignatedsickness;
    }

    public void setIddesignatedsickness(String iddesignatedsickness) {
        this.iddesignatedsickness = iddesignatedsickness;
    }
    
    @XmlTransient
    public Person getIdperson() {
        return idperson;
    }

    public void setIdperson(Person idperson) {
        this.idperson = idperson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpatient != null ? idpatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.idpatient == null && other.idpatient != null) || (this.idpatient != null && !this.idpatient.equals(other.idpatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idperson.toString();
    }
    
}
