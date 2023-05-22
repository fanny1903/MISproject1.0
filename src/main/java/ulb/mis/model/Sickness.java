/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulb.mis.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "sickness")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sickness.findAll", query = "SELECT s FROM Sickness s"),
    @NamedQuery(name = "Sickness.findByIdsickness", query = "SELECT s FROM Sickness s WHERE s.idsickness = :idsickness"),
    @NamedQuery(name = "Sickness.findBySymptom1", query = "SELECT s FROM Sickness s WHERE s.symptom1 = :symptom1"),
    @NamedQuery(name = "Sickness.findBySymptom2", query = "SELECT s FROM Sickness s WHERE s.symptom2 = :symptom2"),
    @NamedQuery(name = "Sickness.findBySymptom3", query = "SELECT s FROM Sickness s WHERE s.symptom3 = :symptom3"),
    @NamedQuery(name = "Sickness.findBySymptom4", query = "SELECT s FROM Sickness s WHERE s.symptom4 = :symptom4"),
    @NamedQuery(name = "Sickness.findByNameofsickness", query = "SELECT s FROM Sickness s WHERE s.nameofsickness = :nameofsickness")})
public class Sickness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsickness")
    private Integer idsickness;
    @Basic(optional = false)
    @Column(name = "symptom1")
    private String symptom1;
    @Basic(optional = false)
    @Column(name = "symptom2")
    private String symptom2;
    @Basic(optional = false)
    @Column(name = "symptom3")
    private String symptom3;
    @Basic(optional = false)
    @Column(name = "symptom4")
    private String symptom4;
    @Basic(optional = false)
    @Column(name = "nameofsickness")
    private String nameofsickness;
    @OneToMany(mappedBy = "idsickness")
    private Collection<Patient> patientCollection;

    public Sickness() {
    }

    public Sickness(Integer idsickness) {
        this.idsickness = idsickness;
    }

    public Sickness(Integer idsickness, String symptom1, String symptom2, String symptom3, String symptom4, String nameofsickness) {
        this.idsickness = idsickness;
        this.symptom1 = symptom1;
        this.symptom2 = symptom2;
        this.symptom3 = symptom3;
        this.symptom4 = symptom4;
        this.nameofsickness = nameofsickness;
    }

    public Integer getIdsickness() {
        return idsickness;
    }

    public void setIdsickness(Integer idsickness) {
        this.idsickness = idsickness;
    }

    public String getSymptom1() {
        return symptom1;
    }

    public void setSymptom1(String symptom1) {
        this.symptom1 = symptom1;
    }

    public String getSymptom2() {
        return symptom2;
    }

    public void setSymptom2(String symptom2) {
        this.symptom2 = symptom2;
    }

    public String getSymptom3() {
        return symptom3;
    }

    public void setSymptom3(String symptom3) {
        this.symptom3 = symptom3;
    }

    public String getSymptom4() {
        return symptom4;
    }

    public void setSymptom4(String symptom4) {
        this.symptom4 = symptom4;
    }

    public String getNameofsickness() {
        return nameofsickness;
    }

    public void setNameofsickness(String nameofsickness) {
        this.nameofsickness = nameofsickness;
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
        hash += (idsickness != null ? idsickness.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sickness)) {
            return false;
        }
        Sickness other = (Sickness) object;
        if ((this.idsickness == null && other.idsickness != null) || (this.idsickness != null && !this.idsickness.equals(other.idsickness))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ulb.mis.model2.Sickness[ idsickness=" + idsickness + " ]";
    }
    
}
