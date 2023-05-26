package ulb.mis.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Patient;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-26T23:19:35")
@StaticMetamodel(Sickness.class)
public class Sickness_ { 

    public static volatile SingularAttribute<Sickness, String> symptom3;
    public static volatile SingularAttribute<Sickness, String> symptom4;
    public static volatile SingularAttribute<Sickness, String> symptom1;
    public static volatile SingularAttribute<Sickness, String> symptom2;
    public static volatile SingularAttribute<Sickness, Integer> idsickness;
    public static volatile CollectionAttribute<Sickness, Patient> patientCollection;
    public static volatile SingularAttribute<Sickness, String> nameofsickness;

}