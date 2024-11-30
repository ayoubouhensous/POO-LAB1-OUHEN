module org.example.javafx_database {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires java.desktop;

    opens org.example.javafx_database to javafx.fxml;
    exports org.example.javafx_database;

    opens Controllers to javafx.fxml;
    exports Controllers;
    opens Entities to javafx.fxml;
    exports Entities;
}