package view.atoms.ui_components.widgets;

import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;

public class CompPasswordTextField extends PasswordField {
  public CompPasswordTextField(String text, int width, int height, int posX, int posY, String style) {
    setText(text);
    setTranslateX(posX);
    setTranslateY(posY);
    setMaxWidth(width);
    setMinHeight(height);
    setStyle(style);
  }

  public static void clearOnFirstClick(PasswordField textField) {
    final boolean[] isFirstClick = {true};
    textField.setOnMouseClicked((MouseEvent event) -> {
      if (isFirstClick[0]) {
        textField.clear();
        isFirstClick[0] = false;
      }
    });

    textField.focusedProperty().addListener((obs, oldVal, newVal) -> {
      if (!newVal) {
        isFirstClick[0] = true;
      }
    });
  }
}
