module library {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;

    opens org.example.entity to javafx.base, org.hibernate.orm.core;
    exports org.example;
}
