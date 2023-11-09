module com.library {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires java.desktop;
    requires org.bytedeco.opencv;

    exports view;
    opens view to javafx.fxml;
}