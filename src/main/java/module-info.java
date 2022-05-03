module javafx.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens javafx.javafx to javafx.fxml;
    exports javafx.javafx;
}