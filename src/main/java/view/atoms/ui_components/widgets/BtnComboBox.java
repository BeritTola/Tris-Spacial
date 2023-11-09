package view.atoms.ui_components.widgets;

import javafx.scene.Cursor;
import javafx.scene.control.ComboBox;

public class BtnComboBox extends ComboBox<String> {
  public BtnComboBox(String[] options, String promptText, int width, int height, int posX, int posY) {
    getItems().addAll(options);
    setPromptText(promptText);
    setTranslateX(posX);
    setTranslateY(posY);
    setMinWidth(width);
    setMinHeight(height);
    setCursor(Cursor.HAND);
    setStyle("-fx-font-family: 'Poppins'; -fx-font-size: 25px; -fx-background-color: #E9F4F6; -fx-border-color: #00BFFF; -fx-border-width: 3px; -fx-background-radius: 10em; -fx-border-radius: 10em;");
  }
}
