module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;

    opens org.example to javafx.fxml;
    exports org.example;
}