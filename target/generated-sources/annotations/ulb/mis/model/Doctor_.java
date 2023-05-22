package ulb.mis.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Appointment;
import ulb.mis.model.Patient;
import ulb.mis.model.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T19:09:08")
@StaticMetamodel(Doctor.class)
public class Doctor_ { 

    public static volatile SingularAttribute<Doctor, Integer> iddoctor;
    public static volatile SingularAttribute<Doctor, String> inami;
    public static volatile CollectionAttribute<Doctor, Patient> patientCollection;
    public static volatile SingularAttribute<Doctor, Person> idperson;
    public static volatile CollectionAttribute<Doctor, Appointment> appointmentCollection;

}