package view.atoms.ui_components.widgets;

import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CompLabel extends Label {
  public CompLabel(String text, boolean bold, int sizeText, String color, int width, int height, int posX, int posY) {
    setText(text);
    setFont(configurationFont(bold, sizeText));
    javafx.scene.paint.Color textColor = javafx.scene.paint.Color.web(color);
    setTextFill(textColor);
    setWrapText(true);
    setTranslateX(posX);
    setTranslateY(posY);
    setMinWidth(width);
    setMinHeight(height);
  }

  public Font configurationFont(boolean bold, int sizeText) {
    if (bold) {
      return Font.font("Poppins", FontWeight.BOLD, sizeText);
    }
    return Font.font("Poppins", sizeText);
  }
}
