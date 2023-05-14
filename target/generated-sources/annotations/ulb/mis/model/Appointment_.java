package ulb.mis.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Doctor;
import ulb.mis.model.Image;
import ulb.mis.model.Note;
import ulb.mis.model.Patient;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-14T09:54:01")
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SingularAttribute<Appointment, Doctor> iddoctor;
    public static volatile SingularAttribute<Appointment, Patient> idpatient;
    public static volatile SingularAttribute<Appointment, String> reason;
    public static volatile SingularAttribute<Appointment, Integer> idappointment;
    public static volatile SingularAttribute<Appointment, Float> price;
    public static volatile SingularAttribute<Appointment, Date> appointmenttime;
    public static volatile ListAttribute<Appointment, Note> noteList;
    public static volatile ListAttribute<Appointment, Image> imageList;

}