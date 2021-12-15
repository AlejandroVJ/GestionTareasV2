module com.mycompany.gestorpracticasprueba {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.persistence;

    opens com.mycompany.gestorpracticasprueba to javafx.fxml, org.hibernate.orm.core, java.sql;
    opens models;
    exports com.mycompany.gestorpracticasprueba;
    
}
