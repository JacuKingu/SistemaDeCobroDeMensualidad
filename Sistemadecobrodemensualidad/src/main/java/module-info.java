module com.mycompany.probandofxpersistencia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.probandofxpersistencia to javafx.fxml;
    exports com.mycompany.probandofxpersistencia;
}
