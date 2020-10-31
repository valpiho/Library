module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;

    opens org.example to javafx.fxml;
    exports org.example;
}