package ulb.mis.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-15T14:16:00")
@StaticMetamodel(Patient.class)
public class Patient_ { 

    public static volatile SingularAttribute<Patient, Integer> idpatient;
    public static volatile SingularAttribute<Patient, String> iddesignatedsickness;
    public static volatile SingularAttribute<Patient, Person> idperson;
    public static volatile SingularAttribute<Patient, String> iddesignateddoctor;

}