package ulb.mis.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Appointment;
import ulb.mis.model.Image;
import ulb.mis.model.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-14T09:54:01")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile SingularAttribute<Patient, Integer> idpatient;
    public static volatile SingularAttribute<Patient, String> phonenumber;
    public static volatile ListAttribute<Patient, Appointment> appointmentList;
    public static volatile ListAttribute<Patient, Image> imageList;
    public static volatile SingularAttribute<Patient, Person> idperson;
    public static volatile SingularAttribute<Patient, String> status;

}