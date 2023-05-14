package ulb.mis.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ulb.mis.model.Appointment;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-14T09:54:01")
@StaticMetamodel(Note.class)
public class Note_ { 

    public static volatile SingularAttribute<Note, Appointment> idappointment;
    public static volatile SingularAttribute<Note, Integer> idnote;
    public static volatile SingularAttribute<Note, Date> dateadded;
    public static volatile SingularAttribute<Note, String> content;

}