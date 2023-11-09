package view.pages.main_menu_example.components;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import view.atoms.general.actionEvent.ActionEvent_General;
import view.atoms.general.Utils.Utils_General;
import view.atoms.common.ComposableComponent;
import view.atoms.ui_components.extraTools.TooltipComp;
import view.atoms.ui_components.widgets.*;
import view.atoms.utils.style_component.StyleCompBy;
import view.atoms.utils.style_component.StyleCompConfigurations;
import view.atoms.utils.style_text.StyleTextBy;
import view.atoms.utils.style_text.StyleTextConfigurations;
import view.pages.main_menu_example.components.action_event.ActionEvent_MainMenu;
import view.pages.main_menu_example.components.utils.Utils_MainMenu;

public class ExamplePage implements ComposableComponent {
  private final GridPane body;

  public ExamplePage() {
    body = new GridPane();
    body.setAlignment(Pos.CENTER);

    Utils_MainMenu.update = new BtnText("Update", 400, 70, 790, -570, new StyleCompConfigurations(StyleCompBy.OPTION_2).getChosenOption());
    Utils_MainMenu.push = new BtnImage("plugins_example/button.png", 180, 150, 900, -550);
    Utils_General.exit = new BtnText("Exit", 300, 60, 1600, -1220, new StyleCompConfigurations(StyleCompBy.OPTION_1).getChosenOption());
  }

  @Override
  public void configureComponent() {
    VBox vBox = new VBox();

    Utils_General.background = new CompImageView("plugins_example/background-Library.png", 2000, 1024, 0, 240);

    Utils_General.note = new CompTextField("write a text...", 700, 60, 650, -600, new StyleCompConfigurations(StyleCompBy.OPTION_1).getChosenOption());
    CompTextField.clearOnFirstClick(Utils_General.note);
    Utils_General.note.setTooltip(new TooltipComp("Put any text"));

    Utils_MainMenu.title = new CompLabel("Hi, Guys", true, 80, new StyleTextConfigurations(StyleTextBy.SKY_BLUE).getChosenOption(), 200, 200, 800, -620);

    vBox.getChildren().addAll(Utils_General.background, Utils_MainMenu.title, Utils_General.note, Utils_MainMenu.update, Utils_MainMenu.push, Utils_General.exit);
    body.getChildren().add(vBox);
  }

  @Override
  public Node getComponent() {
    return body;
  }

  @Override
  public void compose() {
    Utils_MainMenu.update.setOnAction(this::setUpdate);
    Utils_MainMenu.push.setOnAction(this::setPush);
    Utils_General.exit.setOnAction(this::setExit);
  }

  protected void setExit(ActionEvent event) {
    ActionEvent_General.closeMainMenu(event);
  }

  protected void setPush(ActionEvent event) {
    ActionEvent_MainMenu.redirectToMessage(event);
  }

  protected void setUpdate(ActionEvent event) {
    ActionEvent_MainMenu.updatePage(event);
  }
}
