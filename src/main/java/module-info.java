module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires java.xml.bind;
    opens org.example.entity to javafx.base, org.hibernate.orm.core;

    opens org.example to javafx.fxml;
    exports org.example;
}