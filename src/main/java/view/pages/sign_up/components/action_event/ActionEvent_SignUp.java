package view.pages.sign_up.components.action_event;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import view.Main;
import view.atoms.general.Utils.Utils_General;
import view.atoms.utils.enums.typeNotification.TypeNotBy;
import view.atoms.utils.enums.typeNotification.TypeNotConfigurations;
import view.pages.main_menu_example.MainMenuPage;
import view.pop_up.funcionality.PopUpNotification;

public class ActionEvent_SignUp {
  public static void redirectToMainMenu(ActionEvent event) {
    Main.libraryStage.setScene(new Scene((Pane) new MainMenuPage().build(), Utils_General.width, Utils_General.height));
  }

  public static void userRegister(ActionEvent event) {
    showFailureMessage("Invalid email address format");
  }

  public static void faceRecord(ActionEvent event) {
    showFaceRecord();
  }

  private static void showFailureMessage(String message) {
    new PopUpNotification(new TypeNotConfigurations(TypeNotBy.FAILURE).getChosenOption(), message);
  }

  private static void showFaceRecord() {

  }
}
