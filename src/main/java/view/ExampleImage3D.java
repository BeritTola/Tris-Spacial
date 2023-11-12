package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class ExampleImage3D extends Application {
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400, true);

        PerspectiveCamera camera = new PerspectiveCamera();
        scene.setCamera(camera);

        Box box = new Box(100, 100, 300);
        box.setTranslateX(250);
        box.setTranslateY(150);
        box.setTranslateZ(250);
        box.setMaterial(new javafx.scene.paint.PhongMaterial(Color.BLUE));

        root.getChildren().add(box);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}