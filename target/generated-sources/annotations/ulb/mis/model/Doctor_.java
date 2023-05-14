package ulb.mis.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Appointment;
import ulb.mis.model.Image;
import ulb.mis.model.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-14T09:54:01")
@StaticMetamodel(Doctor.class)
public class Doctor_ { 

    public static volatile SingularAttribute<Doctor, Integer> iddoctor;
    public static volatile SingularAttribute<Doctor, String> specialty;
    public static volatile SingularAttribute<Doctor, String> inami;
    public static volatile ListAttribute<Doctor, Appointment> appointmentList;
    public static volatile ListAttribute<Doctor, Image> imageList;
    public static volatile SingularAttribute<Doctor, Person> idperson;

}