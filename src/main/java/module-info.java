module com.library {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires java.desktop;
    requires org.bytedeco.opencv;
    requires j3dcore;
    requires vecmath;
    requires j3dutils;

    exports view;
    opens view to javafx.fxml;
}
