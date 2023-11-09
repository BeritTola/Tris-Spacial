package view.atoms.ui_components.widgets;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class CompText extends Text {
  public CompText(String text, boolean bold, int sizeText, int width, int posX, int posY) {
    setText(text);
    setFont(isBold(bold, sizeText));
    setFill(Color.BLACK);
    setTranslateX(posX);
    setTranslateY(posY);
    setWrappingWidth(width);
    setTextAlignment(TextAlignment.CENTER);
  }

  public Font isBold(boolean bold, int sizeText) {
    if (bold) {
      return Font.font("Poppins", FontWeight.BOLD, sizeText);
    }
    return Font.font("Poppins", FontWeight.NORMAL, sizeText);
  }
}
