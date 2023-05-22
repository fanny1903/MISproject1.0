package ulb.mis.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Doctor;
import ulb.mis.model.Patient;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T11:38:42")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Date> dateofbirth;
    public static volatile SingularAttribute<Person, String> firstname;
    public static volatile ListAttribute<Person, Patient> patientList;
    public static volatile ListAttribute<Person, Doctor> doctorList;
    public static volatile SingularAttribute<Person, String> personpassword;
    public static volatile SingularAttribute<Person, Integer> idperson;
    public static volatile SingularAttribute<Person, String> lastname;

}