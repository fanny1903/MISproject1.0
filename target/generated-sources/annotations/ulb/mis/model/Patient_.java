package ulb.mis.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Appointment;
import ulb.mis.model.Doctor;
import ulb.mis.model.Person;
import ulb.mis.model.Sickness;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T19:09:08")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile SingularAttribute<Patient, Integer> idpatient;
    public static volatile SingularAttribute<Patient, Sickness> idsickness;
    public static volatile SingularAttribute<Patient, Person> idperson;
    public static volatile SingularAttribute<Patient, Doctor> iddesignateddoctor;
    public static volatile CollectionAttribute<Patient, Appointment> appointmentCollection;

}