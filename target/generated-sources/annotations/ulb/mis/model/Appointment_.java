package ulb.mis.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Doctor;
import ulb.mis.model.Patient;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T18:48:10")
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SingularAttribute<Appointment, Doctor> iddoctor;
    public static volatile SingularAttribute<Appointment, Patient> idpatient;
    public static volatile SingularAttribute<Appointment, Integer> idappointment;
    public static volatile SingularAttribute<Appointment, Date> appointmentdatetime;

}