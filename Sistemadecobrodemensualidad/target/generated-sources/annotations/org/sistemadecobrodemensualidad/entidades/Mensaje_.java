package org.sistemadecobrodemensualidad.entidades;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.sistemadecobrodemensualidad.entidades.Persona;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-06-29T20:58:34", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Mensaje.class)
public class Mensaje_ { 

    public static volatile SingularAttribute<Mensaje, String> texto;
    public static volatile SingularAttribute<Mensaje, Date> fecha;
    public static volatile SingularAttribute<Mensaje, Persona> persona;
    public static volatile SingularAttribute<Mensaje, Integer> mensajeId;

}