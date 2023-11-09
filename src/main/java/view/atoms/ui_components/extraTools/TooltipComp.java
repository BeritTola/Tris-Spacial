package view.atoms.ui_components.extraTools;

import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class TooltipComp extends Tooltip {
  public TooltipComp(String text) {
    setFont(Font.font("Poppins", FontWeight.BOLD, FontPosture.ITALIC, 15));
    setStyle("-fx-focus-color: transparent");
    setText(text);

    String style = "-fx-background-color: rgba(255, 255, 255, 0.8); " +
            "-fx-background-radius: 5; " +
            "-fx-padding: 5px 10px; " +
            "-fx-font-family: 'Playfair Display'; " +
            "-fx-font-size: 15px; " +
            "-fx-font-weight: bold; " +
            "-fx-font-style: italic; " +
            "-fx-text-fill: black;";
    setStyle(style);
  }
}
