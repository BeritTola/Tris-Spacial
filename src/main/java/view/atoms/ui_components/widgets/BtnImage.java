package view.atoms.ui_components.widgets;

import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BtnImage extends Button {
  public BtnImage(String image, int width, int height, int posX, int posY) {
    setTranslateX(posX);
    setTranslateY(posY);
    setMinWidth(width);
    setMinHeight(height);
    setCursor(Cursor.HAND);
    setStyle("-fx-focus-color: transparent; -fx-background-color: transparent;");
    CompImageView img = new CompImageView(image);
    img.setFitWidth(width);
    img.setFitHeight(height);
    setGraphic(img);
  }
}
