package view.atoms.ui_components.widgets;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CompTextField extends TextField {
  public CompTextField(String text, int width, int height, int posX, int posY, String style) {
    setText(text);
    setTranslateX(posX);
    setTranslateY(posY);
    setMaxWidth(width);
    setMinHeight(height);
    setStyle(style);
  }

  public static void clearOnFirstClick(TextField textField) {
    final boolean[] isFirstClick = {true};
    textField.setOnMouseClicked((MouseEvent event) -> {
      if (isFirstClick[0]) {
        textField.clear();
        isFirstClick[0] = false;
      }
    });
  }
}
