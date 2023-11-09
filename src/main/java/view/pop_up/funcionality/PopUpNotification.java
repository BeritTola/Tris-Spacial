package view.pop_up.funcionality;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.atoms.ui_components.widgets.BtnText;
import view.atoms.ui_components.widgets.CompImageView;
import view.atoms.ui_components.widgets.CompLabel;
import view.atoms.ui_components.widgets.CompText;
import view.atoms.utils.style_component.StyleCompBy;
import view.atoms.utils.style_component.StyleCompConfigurations;
import view.atoms.utils.style_text.StyleTextBy;
import view.atoms.utils.style_text.StyleTextConfigurations;

public class PopUpNotification {

  private CompImageView typeNotification;

  private CompText text;

  private String pathImage;

  private String content;

  private BtnText exit;

  public PopUpNotification(String pathImage, String content) {
    this.pathImage = pathImage;
    this.content = content;

    initComponent();
  }

  private void initComponent() {
    Stage stage = new Stage();
    Group root = new Group();
    VBox mainContainer = new VBox();
    mainContainer.setPrefSize(450, 400);

    mainContainer.setStyle("-fx-font-size: 30px; -fx-background-color: #D9D9D9; -fx-background-radius: 1em; -fx-border-radius: 1em; -fx-border-color: #30BFCD;  -fx-border-width: 4px;");

    text = new CompText(content, false, 25, 350, 45, 25);
    typeNotification = new CompImageView(pathImage, 250, 250, 90, 20);
    exit = new BtnText("", 10, 10, 0, 0, new StyleCompConfigurations(StyleCompBy.OPTION_1).getChosenOption());
    exit.setOnAction(event -> stage.close());

    mainContainer.getChildren().addAll(typeNotification, text);
    root.getChildren().addAll(mainContainer);

    Scene scene = new Scene(root, 450, 400);
    scene.setFill(Color.TRANSPARENT);

    stage.setScene(scene);
    stage.setResizable(false);

    stage.initStyle(StageStyle.UNDECORATED);
    stage.initStyle(StageStyle.TRANSPARENT);

    stage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
      if (!isNowFocused) {
        stage.close();
      }
    });

    Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    stage.setX(screenBounds.getWidth() - 1170);
    stage.setY(320);

    stage.show();
  }
}
