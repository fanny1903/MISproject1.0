/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.mis.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Liya Rosenstein
 */
@Entity
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByIdpatient", query = "SELECT p FROM Patient p WHERE p.idpatient = :idpatient"),
    @NamedQuery(name = "Patient.findByMsgFileReceived", query = "SELECT p FROM Patient p WHERE p.msgFileReceived = :msgFileReceived"),
    @NamedQuery(name = "Patient.findByMsg", query = "SELECT p FROM Patient p WHERE p.msg = :msg")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpatient")
    private Integer idpatient;
    @Lob
    @Column(name = "file")
    private byte[] file;
    @Column(name = "msgFileReceived")
    private Boolean msgFileReceived;
    @Column(name = "msg")
    private Boolean msg;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson")
    @ManyToOne(optional = false)
    private Person idperson;
    @JoinColumn(name = "iddesignateddoctor", referencedColumnName = "iddoctor")
    @ManyToOne(optional = false)
    private Doctor iddesignateddoctor;
    @JoinColumn(name = "idsickness", referencedColumnName = "idsickness")
    @ManyToOne
    private Sickness idsickness;

    public Patient() {
        this.msgFileReceived = false;
        this.msg = false;
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Boolean getMsgFileReceived() {
        return msgFileReceived;
    }

    public void setMsgFileReceived(Boolean msgFileReceived) {
        this.msgFileReceived = msgFileReceived;
    }

    public Boolean getMsg() {
        return msg;
    }

    public void setMsg(Boolean msg) {
        this.msg = msg;
    }

    public Person getIdperson() {
        return idperson;
    }

    public void setIdperson(Person idperson) {
        this.idperson = idperson;
    }

    public Doctor getIddesignateddoctor() {
        return iddesignateddoctor;
    }

    public void setIddesignateddoctor(Doctor iddesignateddoctor) {
        this.iddesignateddoctor = iddesignateddoctor;
    }

    public Sickness getIdsickness() {
        return idsickness;
    }

    public void setIdsickness(Sickness idsickness) {
        this.idsickness = idsickness;
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
        if ( idsickness != null){
            return idperson.toString() + " - suffers from : " + idsickness.getNameofsickness();
        }
        else{
            return idperson.toString();
        }
    }
    
}
