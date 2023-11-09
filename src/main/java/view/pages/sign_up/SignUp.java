package view.pages.sign_up;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import view.atoms.general.actionEvent.ActionEvent_General;
import view.atoms.general.Utils.Utils_General;
import view.atoms.common.ComposableComponent;
import view.atoms.ui_components.extraTools.CompWriter_Cbox;
import view.atoms.ui_components.extraTools.CompWriter_Tf;
import view.atoms.ui_components.widgets.*;
import view.atoms.utils.style_component.StyleCompBy;
import view.atoms.utils.style_component.StyleCompConfigurations;
import view.atoms.utils.style_text.StyleTextBy;
import view.atoms.utils.style_text.StyleTextConfigurations;
import view.pages.sign_up.components.action_event.ActionEvent_SignUp;
import view.pages.sign_up.components.utils.Utils_SignUp;

public class SignUp implements ComposableComponent {
  private final GridPane body;

  public SignUp() {
    body = new GridPane();
    body.setAlignment(Pos.CENTER);

    Utils_General.back = new BtnImage("plugins_example/back-Library.png", 60, 60, 120, 180);
    Utils_SignUp.faceRecord = new BtnImage("plugins_example/camera-Library.png", 130, 60, 1600, 60);
    Utils_SignUp.logIn_Btn = new BtnText("Sign Up", 250, 60, 820, -1270, new StyleCompConfigurations(StyleCompBy.OPTION_2).getChosenOption());
    Utils_General.exit = new BtnText("Exit", 10, 10, 0, 0, new StyleCompConfigurations(StyleCompBy.OPTION_1).getChosenOption());
  }

  @Override
  public void configureComponent() {
    VBox vBox = new VBox();

    Utils_General.background = new CompImageView("plugins_example/background-Library.png", 2000, 1024, 0, 1120);
    Utils_General.background_record = new CompImageView("plugins_example/recordBackground-Library.png", 900, 770, 500, 120);
    Utils_SignUp.logIn_Title = new CompImageView("plugins_example/signUpTitle-Library.png", 250, 60, 300, 90);

    Utils_SignUp.userName = new CompLabel("User Name", true, 25, new StyleTextConfigurations(StyleTextBy.BLACK).getChosenOption(), 350, 200, 600, -690);
    Utils_SignUp.userName_Tf = (new CompWriter_Tf("", 700, 60, 600 , -760, new StyleCompConfigurations(StyleCompBy.OPTION_1).getChosenOption(), "Put your user name")).returnComp();

    Utils_SignUp.address = new CompLabel("Address Gmail", true, 25, new StyleTextConfigurations(StyleTextBy.BLACK).getChosenOption(), 350, 200, 600, -820);
    Utils_SignUp.address_Tf = (new CompWriter_Tf("", 700, 60, 600 , -900, new StyleCompConfigurations(StyleCompBy.OPTION_1).getChosenOption(), "Put your address")).returnComp();

    Utils_SignUp.ci = new CompLabel("C. I.", true, 25, new StyleTextConfigurations(StyleTextBy.BLACK).getChosenOption(), 350, 200, 600, -960);
    Utils_SignUp.ci_Tf = (new CompWriter_Tf("", 700, 60, 600 , -1030, new StyleCompConfigurations(StyleCompBy.OPTION_1).getChosenOption(), "Put your ci")).returnComp();

    Utils_SignUp.password = new CompLabel("Password", true, 25, new StyleTextConfigurations(StyleTextBy.BLACK).getChosenOption(), 350, 200, 600, -1090);
    Utils_SignUp.password_Tf = (new CompWriter_Tf("", 700, 60, 600 , -1160, new StyleCompConfigurations(StyleCompBy.OPTION_1).getChosenOption(), "Put your password")).returnComp();

    Utils_SignUp.role = new CompLabel("Role", true, 25, new StyleTextConfigurations(StyleTextBy.BLACK).getChosenOption(), 350, 200, 600, -1220);
    String[] roles = {"Option 1", "Option 2", "Option 3"};
    Utils_SignUp.role_BtnComboBox = (new CompWriter_Cbox(roles, "Roles", 700, 60, 600, -1290, "Put your role")).returnComp();

    vBox.getChildren().addAll(Utils_General.background, Utils_General.back, Utils_SignUp.logIn_Title, Utils_SignUp.faceRecord, Utils_General.background_record, Utils_SignUp.userName, Utils_SignUp.userName_Tf, Utils_SignUp.address, Utils_SignUp.address_Tf, Utils_SignUp.ci, Utils_SignUp.ci_Tf, Utils_SignUp.password, Utils_SignUp.password_Tf, Utils_SignUp.role, Utils_SignUp.role_BtnComboBox, Utils_SignUp.logIn_Btn);
    body.getChildren().add(vBox);
  }

  @Override
  public Node getComponent() {
    return body;
  }

  @Override
  public void compose() {
    Utils_SignUp.logIn_Btn.setOnAction(this::setLogIn);
    Utils_SignUp.faceRecord.setOnAction(this::setFaceRecord);
    Utils_General.back.setOnAction(this::setBack);
    Utils_General.exit.setOnAction(this::setExit);
  }

  protected void setExit(ActionEvent event) {
    ActionEvent_General.closeMainMenu(event);
  }

  protected void setBack(ActionEvent event) {
    ActionEvent_SignUp.redirectToMainMenu(event);
  }

  protected void setLogIn(ActionEvent event) {
    ActionEvent_SignUp.userRegister(event);
  }

  protected void setFaceRecord(ActionEvent event) {
    ActionEvent_SignUp.faceRecord(event);
  }
}
