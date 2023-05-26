package ulb.mis.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Doctor;
import ulb.mis.model.Patient;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-26T21:49:14")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Date> dateofbirth;
    public static volatile SingularAttribute<Person, String> firstname;
    public static volatile CollectionAttribute<Person, Doctor> doctorCollection;
    public static volatile CollectionAttribute<Person, Patient> patientCollection;
    public static volatile SingularAttribute<Person, String> personpassword;
    public static volatile SingularAttribute<Person, Integer> idperson;
    public static volatile SingularAttribute<Person, String> lastname;

}