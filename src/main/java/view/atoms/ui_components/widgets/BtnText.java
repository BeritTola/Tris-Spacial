package view.atoms.ui_components.widgets;

import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BtnText extends Button {
  public BtnText(String buttonText, int width, int height, int posX, int posY, String style) {
    setTranslateX(posX);
    setTranslateY(posY);
    setMinWidth(width);
    setMinHeight(height);
    setCursor(Cursor.HAND);
    setText(buttonText);
    setStyle(style);
  }
}