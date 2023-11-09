package view.atoms.ui_components.widgets;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

public class BtnCircleImage extends Button {
  public BtnCircleImage(String image, int width, int height, int posX, int posY) {
    setTranslateX(posX);
    setTranslateY(posY);
    setMinWidth(width);
    setMinHeight(height);
    setCursor(Cursor.HAND);
    setStyle("-fx-focus-color: transparent");
    setStyle("-fx-background-color: transparent");

    ImageView imageView = new ImageView(new Image(image));
    imageView.setFitWidth(width);
    imageView.setFitHeight(height);

    Circle circle = new Circle(width / 2, height / 2, Math.min(width, height) / 2);
    imageView.setClip(circle);

    StackPane stackPane = new StackPane(imageView);
    stackPane.setPrefSize(width, height);
    stackPane.setBlendMode(BlendMode.SRC_ATOP);

    setGraphic(stackPane);
  }
}
