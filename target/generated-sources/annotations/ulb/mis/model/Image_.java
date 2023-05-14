package ulb.mis.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Appointment;
import ulb.mis.model.Doctor;
import ulb.mis.model.Patient;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-14T09:54:01")
@StaticMetamodel(Image.class)
public class Image_ { 

    public static volatile SingularAttribute<Image, Doctor> iddoctor;
    public static volatile SingularAttribute<Image, Patient> idpatient;
    public static volatile SingularAttribute<Image, Appointment> idappointment;
    public static volatile SingularAttribute<Image, String> seriesuid;
    public static volatile SingularAttribute<Image, Integer> idimage;
    public static volatile SingularAttribute<Image, String> instanceuid;
    public static volatile SingularAttribute<Image, String> studyuid;
    public static volatile SingularAttribute<Image, String> patientDicomIdentifier;

}