module javafx.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens javafx.javafx to javafx.fxml;
    exports javafx.javafx;
    exports javafx.javafx.controllers;
    opens javafx.javafx.controllers to javafx.fxml;
}