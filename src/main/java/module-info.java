module com.example.test_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;
    requires lombok;

    opens com.example.test_javafx to javafx.fxml;
    exports com.example.test_javafx;
}